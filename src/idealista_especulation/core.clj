(ns idealista-especulation.core
  (:gen-class)
  (:require [idealista-especulation.api.flats :as flats]
            [idealista-especulation.api.authentication :as auth]
            [idealista-especulation.telegram.telegram :as telegram]))

(defn -main
  "Get flats from Idealista matching the required parameters supplied and send them to telegram"
  []
  (telegram/send-flats-to-telegram (flats/get-flats (auth/get-idealista-token))))