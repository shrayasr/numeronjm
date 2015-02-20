(ns numeronjm.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn make-numeronym
  [request]
  (let [word (get-in request [:params :word])
        cnt (count word)
        start (first word)
        end (last word)
        nums (- (count word) 2)]
    (cond (= cnt 0) ""
          (> cnt 2) (str start nums end)
          (= cnt 2) (str start end))))

(defroutes app-routes
  (GET "/"                  [] "run <pre>/numeronym/&lt;word&gt;</pre> for
                               generating a numeronym")
  (GET "/numeronym/:word"   []  (fn [request]
                                  (let [numeronym (make-numeronym request)]
                                    (str "<pre>" numeronym "</pre>"))))
  (route/not-found "not found"))

(def app
  (wrap-defaults app-routes site-defaults))
