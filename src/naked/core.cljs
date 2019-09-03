(ns naked.core
  (:require
    [com.rpl.specter :as sp :refer [setval select-one]]
    [utils.asyncawait :refer [await] :refer-macros [async]]
    ))


(defn start []
  (async
    (let [user-info  {:hello {:thing "hihi"}}
          user-info2 (setval [:hello :thing] "haha" user-info)]
      (println user-info)
      (println user-info2))))
