def lib_to_spec(lib)
  "org.jetbrains.intellij:intellij-#{lib}:jar:#{OPENAPI_VERSION}"
end

OPENAPI_VERSION='13.1.2'
OPENAPI_LIBS = %w(openapi util extensions annotations)
OPENAPI = OPENAPI_LIBS.collect{|lib| lib_to_spec(lib)}

desc 'Upload required OpenAPI jars to repository from local IDEA installation.'
task 'openapi:upload' do
  env_key = "IDEA_HOME_#{OPENAPI_VERSION.gsub('.','_')}"
  raise "Must define the '#{env_key}' environment variable" unless ENV[env_key]
  raise "The '#{env_key}' environment variable must point at a directory that exists" unless File.directory?(ENV[env_key])

  OPENAPI_LIBS.each do |lib|
    file = "#{ENV[env_key]}/lib/#{lib}.jar"
    begin
      spec = lib_to_spec(lib)
      puts "Attempting to upload #{spec} from #{file}"
      artifact(spec).from(file).upload
    rescue Exception => e
      puts "Failed to upload due to #{e}"
    end
  end
end
