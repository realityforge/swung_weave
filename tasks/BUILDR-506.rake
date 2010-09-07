require 'buildr/packaging/gems'

module Buildr
  class PackageGemTask < ArchiveTask
    private

    def create_from(file_map)
      spec.mark_version
      spec.validate

      File.open(name, 'wb') do |io|
        Gem::Package.open(io, 'w', nil) do |pkg|
          pkg.metadata = spec.to_yaml
          file_map.each do |path, content|
            next if content.nil? || File.directory?(content.to_s)
            pkg.add_file_simple(path, File.stat(content.to_s).mode & 0777, File.size(content.to_s)) do |os|
              File.open(content.to_s, "rb") do |file|
                os.write file.read(4096) until file.eof?
              end
            end
          end
        end
      end
    end
  end
end
