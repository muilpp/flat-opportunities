(defproject idealista-especulation "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [clj-http "3.12.3"]
                 [org.jsoup/jsoup "1.14.3"]
                 [morse "0.4.3"]
                 [cheshire "5.10.1"]
                 [org.clojure/data.json "2.4.0"]
                 [telegrambot-lib "1.2.0"]
                 [sonian/carica "1.2.2"]]
  :plugins [[lein-environ "0.4.0"]]
  :main ^:skip-aot idealista-especulation.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
