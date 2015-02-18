(ns numeronjm.core)

(defn make-numeronym
  [input]
  (let [cnt (count input)]
    (cond (= cnt 0) ""
          (> cnt 2)
            (let [start (first input)
                  end   (last input)
                  nums (- (count input) 2)]
              (str start nums end))
          (= cnt 2)
            (let [start (first input)
                  end (last input)]
              (str start end)))))

(defn -main
  "main function"
  [input_name]
  (println (make-numeronym input_name)))
