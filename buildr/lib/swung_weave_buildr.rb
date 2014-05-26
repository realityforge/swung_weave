require 'buildr'
require 'buildr/swung_weave/version'
require 'tempfile'

module Buildr
  module SwungWeave
    class << self

      def api_artifact
        "#{GROUP}:swung-weave-api:jar:#{VERSION}"
      end

      def enhance(dir, dependencies)
        cp = Buildr.artifacts(dependencies).each(&:invoke).map(&:to_s)
        tf = Tempfile.open('swung_weave')
        begin
          tf << Dir["#{dir}/**/*.class"].join("\n")
          tf.close
          args = []
          args << "@#{tf.path}"
          args << "-d"
          args << dir
          args << "--verbose"
          args << "--debug" if Buildr.application.options.trace
          
          Java::Commands.java 'org.realityforge.swung_weave.tool.Main', *(args + [{:classpath => cp}])
        rescue
          tf.close!
        end
      end

      def dependencies
        [
          # We do not need asm as it is merged into the tool jar
          self.api_artifact,
          "#{GROUP}:swung-weave-tool:jar:#{VERSION}"
        ]
      end
    end

    def swung_weave_enhance
      SwungWeave.enhance(compile.target.to_s, compile.dependencies)
    end

    def swung_weave(buildr_project = nil)
      if buildr_project.nil? && Buildr.application.current_scope.size > 0
        buildr_project = Buildr.project(Buildr.application.current_scope.join(':'))
      end

      if buildr_project.iml?
        buildr_project.iml.add_facet('SwungWeave', 'SwungWeave') do |facet|
          facet.configuration
        end
      end
      buildr_project.compile { buildr_project.swung_weave_enhance }
      buildr_project.compile.with Buildr::SwungWeave.dependencies
    end
  end
end

class Buildr::Project
  include Buildr::SwungWeave
end
