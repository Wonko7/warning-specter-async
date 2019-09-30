(ns naked.core
  (:require
    [cljs.core.async :refer [chan <! >! timeout] :refer-macros [go go-loop] :as a]
    [com.rpl.specter :as sp :refer [setval select-one FIRST]]
    [utils.asyncawait :refer [await] :refer-macros [async]]
    ))

(def get-thing #(select-one [:hello FIRST :thing] %))

(defn start []
  (async ;; 1/ changing this into a go block compiles and works (node prints out hi)
    (let [user-info  {:hello [{:thing "hi"}]}
          get-thing  #(select-one [:hello FIRST :thing] %)
          ]
      (println (get-thing user-info)))))
