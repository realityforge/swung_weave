require 'buildr/packaging/gems'

module Buildr
  module PackageAsGem #:nodoc:
    def package_as_gem(file_name) #:nodoc:
      PackageGemTask.define_task(file_name).tap do |gem|
        %w{ lib test doc }.each do |dir|
          gem.include :from=>_(dir), :path=>dir if File.directory?(_(dir))
        end
        gem.spec do |spec|
          spec.name = id
          spec.version = version.gsub('-','.')
          spec.summary = full_comment
          spec.has_rdoc = true
          spec.rdoc_options << '--title' << comment
          spec.require_path = 'lib'
        end
      end
    end
  end
end
