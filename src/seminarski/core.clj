(ns seminarski.core
  (:gen-class))

(defn solved-cube []
  {:u [:w :w :w :w :w :w :w :w :w]
   :d [:y :y :y :y :y :y :y :y :y]
   :f [:r :r :r :r :r :r :r :r :r]
   :b [:o :o :o :o :o :o :o :o :o]
   :l [:b :b :b :b :b :b :b :b :b]
   :r [:g :g :g :g :g :g :g :g :g]})


(defn rotate-face-cw [face]
  (let [[p0 p1 p2 p3 p4 p5 p6 p7 p8] face]
    [p6 p3 p0 p7 p4 p1 p8 p5 p2]))


(defn get-right-col [face]
  [(nth face 2) (nth face 5) (nth face 8)])


(defn set-right-col [face new-col]
  (let [[c0 c1 c2] new-col]
    (assoc face 2 c0 5 c1 8 c2)))


(defn get-left-col [face]
  [(nth face 0) (nth face 3) (nth face 6)])


(defn set-left-col [face new-col]
  (let [[c0 c1 c2] new-col]
    (assoc face 0 c0 3 c1 6 c2)))


(defn r [cube]
  (let [u-col (get-right-col (:u cube))
        f-col (get-right-col (:f cube))
        d-col (get-right-col (:d cube))
        b-col (get-left-col (:b cube))]
    (-> cube
        (update :r rotate-face-cw)
        (assoc :f (set-right-col (:f cube) u-col))
        (assoc :d (set-right-col (:d cube) f-col))
        (assoc :b (set-left-col (:b cube) d-col))
        (assoc :u (set-right-col (:u cube) b-col)))))
