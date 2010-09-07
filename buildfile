gem 'buildr-bnd', :version => '0.0.5'
gem 'buildr-iidea', :version => '0.0.8'

VERSION_NUMBER = "1.0.0"
GROUP = "org.realityforge"

require 'buildr_bnd'
require 'buildr_iidea'

repositories.remote << 'https://repository.apache.org/content/repositories/releases'
repositories.remote << 'http://repository.springsource.com/maven/bundles/external'
repositories.remote << 'http://repository.code-house.org/content/repositories/release' # OSGi - jmx RI

repositories.remote << Buildr::Bnd.remote_repository

ASM = 'asm:asm-all:jar:3.3'
                                               
artifact('asm:asm-all:jar:3.3').from(File.dirname(__FILE__) + "/repository/asm/asm-all/3.3/asm-all-3.3.jar")
artifact('asm:asm-all:jar:sources:3.3').from(File.dirname(__FILE__) + "/repository/asm/asm-all/3.3/asm-all-3.3-sources.jar")

class CentralLayout < Layout::Default
  def initialize(key, top_level, use_subdir)
    super()
    prefix = top_level ? '' : '../'
    subdir = use_subdir ? "/#{key}" : ''
    self[:target] = "#{prefix}target#{subdir}"
    self[:target, :main] = "#{prefix}target#{subdir}"
    self[:reports] = "#{prefix}reports#{subdir}"
  end
end

def define_with_central_layout(name, top_level = false, use_subdir = true, & block)
  define(name, :layout => CentralLayout.new(name, top_level, use_subdir), & block)
end

desc 'SwungWeave: Bytecode weaver to simplify Swing UI code'
define_with_central_layout("swung-weave", true, false) do
  project.version = VERSION_NUMBER
  project.group = GROUP

  desc "SwingWeave: API and Annotations"
  define_with_central_layout "api" do
    test.using :testng
    package(:bundle).tap do |bnd|
      bnd['Export-Package'] = "org.realityforge.swung_weave.*;version=#{version}"
    end
  end

  desc "SwingWeave: Bytecode weaver tool"
  define_with_central_layout "tool" do
    compile.with ASM, projects('api')
    test.using :testng
    package(:bundle).tap do |bnd|
      bnd['Export-Package'] = "org.realityforge.swung_weave.tool.*;version=#{version}"
      bnd['Private-Package'] = "org.objectweb.asm.*"
    end
  end

end

namespace :deploy do
  task :tag do
    system("git tag -a #{VERSION_NUMBER} -m 'Released #{VERSION_NUMBER}'")
    puts "Tagged locally.  `git push --tags` if you're sure."
  end
end
