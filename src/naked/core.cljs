(ns naked.core
  (:require
    [utils.asyncawait :refer [await] :refer-macros [async]]
    [cljs.core.async :refer [chan <! >! timeout] :refer-macros [go go-loop] :as a]
    [taoensso.tufte :as tufte :refer-macros (defnp p profiled profile)]))

(tufte/add-basic-println-handler! {})

(defn get-x [] (println :x))
(defn get-y [] (println :y))

(defn start []
  ;; No warning here:
  (profile {}
           (dotimes [_ 5]
             (p :get-x (get-x))
             (p :get-y (get-y))))

  ;; Wrong number of args (11) passed to taoensso.tufte/HandlerVal
  (async ;; <- no warning in a go block
    (profile {}
             (dotimes [_ 5]
               (p :get-x (get-x))
               (p :get-y (get-y))))))
