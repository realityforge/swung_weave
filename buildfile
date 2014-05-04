require 'buildr/bnd'
require 'buildr/git_auto_version'
require 'buildr/single_intermediate_layout'
require 'buildr/top_level_generate_dir'

desc 'SwungWeave: Bytecode weaver to simplify Swing UI code'
define 'swung-weave' do
  project.group = 'org.realityforge.swung-weave'
  compile.options.source = '1.6'
  compile.options.target = '1.6'
  compile.options.lint = 'all'

  ipr.extra_modules << 'idea/idea.iml'

  desc 'SwungWeave: API and Annotations'
  define 'api' do
    test.using :testng
    test.using :properties => {'java.awt.headless' => true}
    package(:bundle).tap do |bnd|
      bnd['Export-Package'] = "org.realityforge.swung_weave.*;version=#{version}"
    end
    package(:sources)
  end

  desc 'SwungWeave: Bytecode weaver tool'
  define 'tool' do
    compile.with :asm, projects('api')
    test.using :testng
    package(:bundle).tap do |bnd|
      bnd['Export-Package'] = "org.realityforge.swung_weave.tool.*;version=#{version}"
      bnd['Private-Package'] = 'org.objectweb.asm.*'
    end
  end

  desc 'SwungWeave: IntelliJ IDEA plugin'
  define 'idea-plugin', :base_dir => 'idea' do
    compile.with OPENAPI, :jdom, projects('tool')
    project.no_iml
    project.resources.filter.using :'version' => project.version
    test.using :testng
    package(:jar)
  end

  doc.using :javadoc
  doc.from projects('tool','api')

  desc 'SwungWeave: Buildr extension'
  define 'buildr' do

    generated_file = _(:target, :generated, 'version.rb')
    file(generated_file => Buildr.application.buildfile) do
      mkdir_p File.dirname(generated_file)
      File.open(generated_file, 'wb') do |f|
        f.write <<TEXT
module Buildr
  module SwungWeave
    private
      VERSION='#{project.version}'
      ASM_ARTIFACT='#{artifact(:asm).to_spec}'
      GROUP='#{project.group}'
  end
end
TEXT
      end
    end
    package(:gem).tap do |gem|
      gem.spec do |spec|
        spec.authors        = ['Peter Donald']
        spec.email          = ['peter@realityforge.org']

        spec.homepage       = 'http://github.com/realityforge/swung_weave'
        spec.summary        = 'Buildr extension to run the swung_weave tool'
        spec.description    = <<-TEXT
Buildr extension to process bytecode using swung-weaver. Swung weaver is
bytecode weaving of annotated UI classes to ensure all UI updates occur
in the Event Dispatch Thread
TEXT
        spec.require_paths  = ['lib']
        spec.has_rdoc         = false
      end
      gem.include :from => _('lib'), :path => 'lib'
      gem.include ['LICENSE', 'README.rdoc', 'NOTICE']
      gem.include generated_file, :as => 'lib/buildr/swung_weave/version.rb'
      gem.prerequisites << generated_file
    end
  end
end
