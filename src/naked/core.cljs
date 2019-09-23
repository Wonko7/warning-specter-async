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
          thing      (select-one [:hello FIRST :thing] user-info)
          ;;thing      (get-thing user-info) ;; 2/ with async: commenting the previous line and using this instead works, select-one needs to be compiled outside the async block
          ]
      (println thing))))
