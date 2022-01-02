(ns idealista-especulation.telegram.telegram
  (:require [telegrambot-lib.core :as tbot]
            [carica.core :as env]))

(def tel-bot (tbot/create (env/config :telegram :token)))

(defn send-flats-to-telegram
  [all-flats]
  (loop [flats all-flats]
    (if (empty? flats)
      ""
      (let [flat (first flats)
            rooms (:rooms flat)
            city (:municipality flat)
            size (:size flat)
            url (:url flat)
            price (:price flat)
            ]
        (tbot/send-message tel-bot {:chat_id (env/config :telegram :chat-id) :text (str city" " size"m2, "  rooms " habitacions" "\nPreu: " price "\n" url) })
        (recur (rest flats)))
      )
    ))