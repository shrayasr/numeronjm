(ns numeronjm.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] "hello world")
  (route/not-found "not found"))

(defn make-numeronym
  [input]
  (let [cnt (count input)
        start (first input)
        end (last input)
        nums (- (count input) 2)]
    (cond (= cnt 0) ""
          (> cnt 2) (str start nums end)
          (= cnt 2) (str start end))))


(def app
  (wrap-defaults app-routes site-defaults))
