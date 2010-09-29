require 'buildr/packaging/artifact'

module Buildr
  class Repositories
    def release_to
      unless @release_to
        value = Buildr.settings.user['repositories'] && Buildr.settings.user['repositories']['release_to']
        unless value
          value = Buildr.settings.build['repositories'] && Buildr.settings.build['repositories']['release_to']
        end
        @release_to = Hash === value ? value.inject({}) { |hash, (key, value)| hash.update(key.to_sym=>value) } : { :url=>Array(value).first }
      end
      @release_to
    end
  end
end
