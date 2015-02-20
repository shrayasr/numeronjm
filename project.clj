(defproject numeronjm "0.1.0-SNAPSHOT"
  :description "A simple numeronym generator"
  :url "https://github.com/shrayasr/numeronjm"
  :license {:name "MIT"
            :url "http://opensource.org/licenses/MIT"}
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [ring/ring-defaults "0.1.2"]]
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler numeronjm.core/app})
