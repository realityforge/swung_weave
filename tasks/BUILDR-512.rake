require 'buildr/core/util'

module Buildr
  module Util
    extend self

    def ruby(*args)
      options = Hash === args.last ? args.pop : {}
      cmd = []
      ruby_bin = normalize_path(Config::CONFIG['ruby_install_name'], Config::CONFIG['bindir'])
      if options.delete(:sudo) && !(win_os? || Process.uid == File.stat(ruby_bin).uid)
        cmd << 'sudo' << '-u' << "##{File.stat(ruby_bin).uid}"
      end
      cmd << ruby_bin
      cmd << '-S' << options.delete(:command) if options[:command]
      cmd.concat args.flatten
      cmd.push options
      sh *cmd do |ok, status|
        ok or fail "Command ruby failed with status (#{status ? status.exitstatus : 'unknown'}): [#{cmd.join(" ")}]"
      end
    end
  end
end
