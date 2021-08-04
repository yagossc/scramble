(defproject scramble-ui "0.1.0-SNAPSHOT"
  :min-lein-version "2.9.6"
  :url "https://github.com/yagossc/scramble/scramble-frontend"
  :description "Scramble Challenge Frontend"
  :license {:name "MIT LICENSE" :url ""}

  :dependencies [[org.clojure/clojure "1.10.3"]
                 [org.clojure/clojurescript "1.10.773"]
                 [reagent "1.0.0"]
                 [re-frame "1.2.0"]
                 [day8.re-frame/http-fx "0.2.3"]]

  :plugins [[lein-cljsbuild "1.1.8"]]

  :source-paths ["src/clj" "src/cljs" "src/scramble_frontend"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :profiles {:dev {} :prod {}}

  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src/scramble_frontend"]
     :figwheel     {:on-jsload "scramble_frontend.core/mount-root"}
     :compiler     {:main                 scramble-frontend.core
                    :output-to            "resources/public/js/compiled/app.js"
                    :output-dir           "resources/public/js/compiled/out"
                    :closure-defines      {goog.DEBUG true}
                    :asset-path           "js/compiled/out"
                    :source-map-timestamp true}}]})
