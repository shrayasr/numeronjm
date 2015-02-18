(ns numeronjm.core)

(defn make-numeronym
  [input]
  (let [cnt (count input)
        start (first input)
        end (last input)
        nums (- (count input) 2)]
    (cond (= cnt 0) ""
          (> cnt 2) (str start nums end)
          (= cnt 2) (str start end))))

(defn -main
  "main function"
  [input_name]
  (println (make-numeronym input_name)))
