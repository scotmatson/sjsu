; Attributes:
;     http://www.fatvat.co.uk/2008/12/bubbling-clojure.html 
;     http://clojure.org/reference/lazy

(defn random-integers[m n]
    (take m (repeatedly #(rand-int n))))

(defn bubble [numbers]
    (if (or (nil? numbers) (nil? (second numbers)))
        numbers
        (if (> (first numbers) (second numbers))
            (cons (second numbers) (cons (first numbers) (nthrest numbers 2)))
            (lazy-seq
                (when-let [s (seq numbers)]
                    (cons (first s) (bubble (rest s))))))))

(defn bubble-sort [numbers]
    (if (= (bubble numbers) numbers)
        numbers (recur (bubble numbers))))

(def randInts (random-integers 10 101))
(println "Sequence of random integers")
(println randInts)
(println "Sorted sequence")
(println (bubble-sort randInts))
