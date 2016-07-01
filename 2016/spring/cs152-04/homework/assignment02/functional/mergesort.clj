; Attributes:
;     https://gist.github.com/baabelfish/6573984

(defn random-integers[m n]
    (take m (repeatedly #(rand-int n))))

(defn merge-parts [[x & xrest :as X] [y & yrest :as Y] R]
    (if (and (not-empty X) (not-empty Y))
        (if (<= x y)
            (merge-parts xrest Y (conj R x))
            (merge-parts X yrest (conj R y)))
        (concat R X Y)))

(defn merge-sort [X]
    (if (> (count X) 1)
        (let [sides (split-at (/ (count X) 2) X)]
            (merge-parts (merge-sort (get sides 0))
                (merge-sort (get sides 1)) []))X))

(def randInts (random-integers 10 101))
(println "Sequence of random integers")
(println randInts)
(println "Sorted sequence")
(println (merge-sort randInts))
