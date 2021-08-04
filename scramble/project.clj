(defproject scramble "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://github.com/yagossc/scramble/scramble"
  :license {:name "MIT LICENSE" :url ""}
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :repl-options {:init-ns scramble.core}
  :main ^:skip-aot scramble.core
  :target-path "target/%s"
  :profiles {:socket {:jvm-opts ["-Dclojure.server.repl={:name \"repl-server\"
                                               :port 5555
                                               :address \"0.0.0.0\"
                                               :accept clojure.core.server/repl
                                               :bind-err true
                                               :server-daemon false
                                               :client-daemon false}"]}
             :uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
