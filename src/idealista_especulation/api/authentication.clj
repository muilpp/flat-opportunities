(ns idealista-especulation.api.authentication
  (:require [clojure.data.json :as json]
            [clj-http.client :as client]
            [carica.core :as env]))

(defn parse-authenticate-json-response
  [body]
  ((json/read-str body :key-fn keyword):access_token))

(defn get-idealista-token
  []
  (parse-authenticate-json-response
    ((client/post "https://api.idealista.com/oauth/token"
                       {
                        :basic-auth [(env/config :idealista :user) (env/config :idealista :pwd)]
                        :headers {:content-type "application/x-www-form-urlencoded"}
                        :query-params {:grant_type "client_credentials" :scope "read"}
                        }):body))
  )