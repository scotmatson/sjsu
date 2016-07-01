; Attributions


(defn hamming-distance [n m]
    (reduce + (map
        (fn [base1 base2]
            (if (= base1 base2) 0 1))
            n
            m)))

(def num1 (rand-int 101))
(def num2 (rand-int 101))

(print "Num One: ")
(println num1)
(print "Num Two: ")
(println num2)
(println "Calculating Hamming Distance")
(hamming-distance num1 num2)
;(println (hamming-distance num1 num2))


