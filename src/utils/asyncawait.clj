(ns utils.asyncawait
  (:refer-clojure :exclude [await])
  (:require [cloroutine.core :refer [cr]]))

(defmacro async [& body]
  `(js/Promise. (fn [s# f#]
                  (spawn (cr {await thunk}
                           (try (s# (do ~@body))
                            (catch :default e# (f# e#))))))))
