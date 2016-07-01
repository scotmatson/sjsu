; Attributes:
;     https://stackoverflow.com/question/9024452/insertion-sort-using-clojure

(defn random-integers[m n]
    (take m (repeatedly #(rand-int n))))

(defn insert[n numbers]
    (cond 
        (empty? numbers) (list n) 
        (> (first numbers) n) (conj numbers n)
        :else 
            (conj (insert n (rest numbers)) (first numbers))))

(defn insertion-sort[numbers]
    (loop [list numbers result '()]
        (if (empty? list) result
            (recur (rest list) (insert (first list) result)))))

(def randInts (random-integers 10 101))
(println "Sequence of random integers")
(println randInts)
(println "Sorted sequence")
(println (insertion-sort randInts))
