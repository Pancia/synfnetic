(defproject synfnetic/syntaxic "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.8.51"]
                 [org.omcljs/om "1.0.0-alpha32" :scope "test"]
                 [navis/untangled-spec "0.3.6" :scope "test"]
                 [synfnetic/catalyst "0.1.0-SNAPSHOT"]]

  :plugins [[com.jakemccrary/lein-test-refresh "0.15.0"]]

  :test-refresh {:report untangled-spec.reporters.terminal/untangled-report
                 :with-repl true
                 :changes-only true}

  :source-paths ["src"]
  :test-paths ["specs"]
  :clean-targets ^{:protect false} ["resources/public/js/compiled"]

  :cljsbuild {:builds [{:id           "test"
                        :source-paths ["specs" "src"]
                        :figwheel     true
                        :compiler     {:main                 syntaxic.spec-main
                                       :output-to            "resources/public/js/specs/specs.js"
                                       :output-dir           "resources/public/js/compiled/specs"
                                       :asset-path           "js/compiled/specs"
                                       :optimizations        :none}}]}

  :profiles {:dev {:source-paths ["dev" "src"]
                   :dependencies [[binaryage/devtools "0.6.1"]
                                  [com.cemerick/piggieback "0.2.1"]
                                  [figwheel-sidecar "0.5.3-1" :exclusions [joda-time clj-time]]
                                  [org.clojure/tools.nrepl "0.2.12"]]
                   :repl-options {:init-ns user
                                  :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}})
