(ns naked.core
  (:require
    [com.rpl.specter :as sp :refer [setval select-one]]
    [utils.asyncawait :refer [await] :refer-macros [async]]
    [cljs.core.async :refer [chan <! >! timeout] :refer-macros [go go-loop] :as a]
    ))


(defn start []
  (go
    (let [user-info  {:hello {:thing "hihi"}}
          user-info2 (setval [:hello :thing] "haha" user-info)]
      (println user-info)
      (println user-info2))))
