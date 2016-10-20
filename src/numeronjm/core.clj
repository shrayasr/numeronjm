(ns numeronjm.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn make-numeronym
  [word]
  (let [cnt (count word)
        start (first word)
        end (last word)
        nums (- (count word) 2)]
    (cond (= cnt 0) ""
          (> cnt 2) (str start nums end)
          (= cnt 2) (str start end))))

(defroutes app-routes
  (GET "/"                  [] "go to <pre>/numeronym/&lt;word&gt;</pre> for
                               generating a numeronym<br/><hr/>
                               <a href='https://github.com/shrayasr/numeronjm'>Github</a>")
  (GET "/numeronym/:word"   []  (fn [request]
                                  (let [word (get-in request [:params :word])
                                        numeronym (make-numeronym word)]
                                    (str "<pre>" numeronym "</pre>"))))
  (route/not-found "not found"))

(def app
  (wrap-defaults app-routes site-defaults))
