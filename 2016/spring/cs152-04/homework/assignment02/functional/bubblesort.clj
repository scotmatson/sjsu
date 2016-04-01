(defn random-integers[m n]
    (take m (repeatedly #(rand-int n))))

(defn compute-across [myfunc elements value]
    (if (empty? elements)
        value
        (recur myfunc (rest elements) (myfunc value (first elements)))))

(defn total-of [numbers]
    (compute-across + numbers 0))

(defn largest-of [x y]
    (if (> x y) x y))

(defn greatest-of [numbers]
    (compute-across largest-of numbers (first numbers)))

(def randInts (random-integers 10 101))

(println "Sequence of random integers")
(println randInts)
(print "Max value: ")
(println (greatest-of randInts))
