(ns idealista-especulation.api.flats
  (:require [clojure.data.json :as json]
            [clj-http.client :as client]))

(defn parse-flats-json-response
  [flats-json-response]
  ((json/read-str flats-json-response :key-fn keyword):elementList))

(defn get-flats
  [token]
  (parse-flats-json-response ((client/post "https://api.idealista.com/3.5/es/search"
                                                    {
                                                     :headers {
                                                               :content-type "application/x-www-form-urlencoded"
                                                               :authorization (str "Bearer " token)
                                                               }
                                                     :query-params {:country "es"
                                                                    :operation "sale"
                                                                    :propertyType "homes"
                                                                    :distance "8000"
                                                                    :maxItems "40"
                                                                    :maxPrice "95000"
                                                                    :minPrice "80000"
                                                                    :elevator "true"
                                                                    :center "41.6053142,2.2851149"}
                                                     }):body))
  )