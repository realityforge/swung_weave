require 'buildr'
require 'buildr/java'
require 'buildr/swung_weave/version'
require 'tempfile'

module Buildr
  module SwungWeave
    class << self

      def api_artifact
        "#{GROUP}:swung-weave-api:jar:#{VERSION}"
      end

      def enhance(dir)
        cp = Buildr.artifacts(requires).each(&:invoke).map(&:to_s)
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

      # Repositories containing the requirements
      def remote_repository
        'http://www.stocksoftware.com.au/repositories/releases'
      end

      private

      def requires
        [
          self.api_artifact,
          "#{GROUP}:swung-weave-tool:jar:#{VERSION}",
          ASM_ARTIFACT
        ]
      end
    end

    def swung_weave_enhance
      SwungWeave.enhance(compile.target.to_s)
    end
  end
end

class Buildr::Project
  include Buildr::SwungWeave
end