(ns utils.asyncawait
  (:require [cloroutine.core]))

(def ^:dynamic *success*)
(def ^:dynamic *failure*)
(def ^:dynamic *status*)
(def ^:dynamic *result*)

(defn await [p]
  (.then p *success* *failure*))

(defn thunk []
  (if *status* *result* (throw *result*)))

(defn spawn [c]
  (letfn [(run []
            (binding [*success* success
                      *failure* failure]
              (c)))
          (success [x]
            (binding [*status* true
                      *result* x] (run)))
          (failure [x]
            (binding [*status* false
                      *result* x] (run)))]
   (run)))
