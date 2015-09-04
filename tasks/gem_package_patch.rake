require 'buildr/packaging/gems'

module Buildr #:nodoc:
  class PackageGemTask < ArchiveTask

    def create_from(file_map)
      base_dir = "#{self.name}.pkg"
      FileUtils.mkdir_p base_dir

      file_map.each do |path, content|
        next if content.nil? || File.directory?(content.to_s)
        full_path = "#{base_dir}/#{path}"
        FileUtils.mkdir_p File.dirname(full_path)
        FileUtils.cp content, full_path
        File.chmod(File.stat(content.to_s).mode & 0777, full_path)
      end

      spec.files = file_map.keys.select { |f| !File.directory?(f.to_s) }.collect { |f| f.to_s }
      wd = Dir.pwd
      begin
        Dir.chdir base_dir
        spec.mark_version
        spec.validate
        Gem::Package.build(spec)
        FileUtils.mkdir_p File.dirname(self.name)
        FileUtils.mv spec.file_name, self.name
      ensure
        Dir.chdir wd
        FileUtils.rm_rf base_dir
      end
    end
  end
end
