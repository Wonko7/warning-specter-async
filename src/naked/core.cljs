(ns naked.core
  (:require
    [sqlingvo.core        :as sql]
    [sqlingvo.node.driver :as driver]
    [sqlingvo.node.sync   :as db]
    ))

(defn start []
  (let [db (db/db "postgresql://xxx:xxx@localhost:6543/xxx")
        res @(sql/select db ['(max :version)]
               (sql/from :meta))]
    (println res)))
