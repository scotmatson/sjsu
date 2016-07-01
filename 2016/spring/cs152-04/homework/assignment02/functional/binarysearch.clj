; Attributes:
;     http://programming-pages.com/2012/01/31/binary-search-in-clojure

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

(defn binary-search [numlist target]
    (def uppercount (dec (count numlist)))
    (loop [lower 0 upper uppercount]
        (if (> lower upper) nil
            (let [mid (quot (+ lower upper) 2)
                midvalue (nth numlist mid)]
                (cond
                    (> midvalue target) (recur lower (dec mid))
                    (< midvalue target) (recur (inc mid) upper)
                    (= midvalue target) mid)))))

(def randInts (random-integers 10 101))
(def sortedInts (merge-sort randInts))
(def randInt (rand-int 101))

(println "Sequence of random integers")
(println randInts)
(println "Sorted sequence:")
(println sortedInts)
(print "Target Integer: ")
(println randInt)
(println (binary-search sortedInts randInt)) 
