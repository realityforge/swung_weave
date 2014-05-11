task 'ci:setup' do
  ENV['TEST'] = 'all'
end

task 'ci:package' => %w(ci:setup clean package doc)
