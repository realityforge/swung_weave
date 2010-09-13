
def init_iris_release_to
  repositories.release_to = {
    :url => "sftp://www.stocksoftware.com.au/www/stocksoftware/web/repositories/releases",
    :username => ENV["RELEASE_USER"]
  }
  repositories.remote = ['http://www.stocksoftware.com.au/repositories/external']
end

def init_external_release_to
  repositories.release_to = {
    :url => "sftp://www.stocksoftware.com.au/www/stocksoftware/web/repositories/external",
    :username => ENV["RELEASE_USER"]
  }
  repositories.remote =
    [
      'http://www.stocksoftware.com.au/repositories/external',
      'http://www.ibiblio.org/maven2',
      'https://repository.apache.org/content/repositories/releases',
      'http://repository.jboss.org/maven2', # For velocity 1.5
    ]
end

init_iris_release_to

desc "Mirror the non-snapshot dependencies to the external repository"
task :mirror_external_dependencies do
  raise "User must specify RELEASE_USER environment variable." unless ENV["RELEASE_USER"]
  init_external_release_to

  artifacts = {}
  Buildr.projects.each do |project|
    deps = project.compile.dependencies + project.test.dependencies
    Buildr.artifacts(deps).
      select { |artifact| Artifact === artifact }.
      select { |artifact| !artifact.snapshot? }.
      each { |artifact| artifacts[artifact.to_spec] = artifact }
  end
  sources = {}
  artifacts.values.each do |artifact|
    if artifact.to_hash[:type] != :pom && File.exist?(artifact.sources_artifact.to_s)
      source = artifact.sources_artifact
      sources[source.to_spec] = source
    end
  end
  (artifacts.values + sources.values).each do |artifact|
    artifact_path = "#{artifact.group.split('.').join('/')}/#{artifact.id}/#{artifact.version}"
    artifact_name = "#{artifact.id}-#{artifact.version}#{artifact.classifier ? "-#{artifact.classifier}" : ""}.#{artifact.type}"
    full_path = "/repositories/external/#{artifact_path}/#{artifact_name}"
    do_upload = false
    Net::HTTP.start('www.stocksoftware.com.au') do |http|
      req = Net::HTTP::Head.new(full_path)
      do_upload = Net::HTTPNotFound === http.request(req)
    end
    #puts "Should upload #{artifact.to_spec}" if do_upload
    artifact.upload if do_upload
  end

  init_iris_release_to
end
