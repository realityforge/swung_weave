module Buildr
  module PerBuildCustomization
    module ProjectExtension
      include Extension
      before_define do
        unless @customizations_loaded
          local_config = "#{File.dirname(Buildr.application.buildfile.to_s)}/_buildr.rb"
          require local_config if File.exist?(local_config)
          @customizations_loaded = true
        end
      end
    end
  end
end

class Buildr::Project
  include Buildr::PerBuildCustomization::ProjectExtension
end