(defproject fortunes-clojure "0.0.1"
  :description "Fortunes as a Service"
  :url "http://github.com/TrevorS/fortunes-clojure"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/data.json "0.2.1"]
                 [io.pedestal/pedestal.service "0.4.1"]

                 ;; Remove this line and uncomment one of the next lines to
                 ;; use Immutant or Tomcat instead of Jetty:
                 [io.pedestal/pedestal.jetty "0.4.1"]
                 ;; [io.pedestal/pedestal.immutant "0.4.1"]
                 ;; [io.pedestal/pedestal.tomcat "0.4.1"]

                 [ch.qos.logback/logback-classic "1.1.3" :exclusions [org.slf4j/slf4j-api]]
                 [org.slf4j/jul-to-slf4j "1.7.12"]
                 [org.slf4j/jcl-over-slf4j "1.7.12"]
                 [org.slf4j/log4j-over-slf4j "1.7.12"]]
  :min-lein-version "2.0.0"
  :resource-paths ["config", "resources"]
  :profiles {:dev {:aliases {"run-dev" ["trampoline" "run" "-m" "fortunes-clojure.server/run-dev"]}
                   :dependencies [[io.pedestal/pedestal.service-tools "0.4.1"]]}
             :uberjar {:aot [fortunes-clojure.server]}}
  :main ^{:skip-aot true} fortunes-clojure.server)
