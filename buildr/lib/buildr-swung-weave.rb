require 'buildr'
require 'buildr/java'

module Buildr
  module SwungWeave
    class << self

      def api_artifact
        "org.realityforge:swung-weave-api:jar:#{Buildr::SwungWeave::Version::STRING}"
      end

      def enhance(dir)
        args = Dir["#{dir}/**/*.class"]
        args << "-d"
        args << dir
        args << "--verbose"
        args << "--debug" if Buildr.application.options.trace
        cp = Buildr.artifacts(self.requires).each(&:invoke).map(&:to_s).join(File::PATH_SEPARATOR)
        Java::Commands.java 'org.realityforge.swung_weave.tool.Main', *(args + [{ :classpath => cp }])
      end

      private

      def requires
        [
          self.api_artifact,
          "org.realityforge:swung-weave-tool:jar:#{Buildr::SwungWeave::Version::STRING}",
          'asm:asm-all:jar:3.3'
        ]
      end
    end

    def swung_weave_enhance
      SwungWeave.enhance(compile.target)
    end
  end
end

class Buildr::Project
  include Buildr::SwungWeave
end