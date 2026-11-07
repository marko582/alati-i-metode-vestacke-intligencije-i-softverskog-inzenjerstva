(ns seminarski.core-test
  (:require [midje.sweet :refer :all]
            [seminarski.core :refer :all]))

(fact "Clockwise face rotation"
      (rotate-face-cw
        [:0 :1 :2
         :3 :4 :5
         :6 :7 :8])
      =>
      [:6 :3 :0
       :7 :4 :1
       :8 :5 :2])

(fact "Counter-clockwise face rotation"
      (rotate-face-ccw
        [:0 :1 :2
         :3 :4 :5
         :6 :7 :8])
      =>
      [:2 :5 :8
       :1 :4 :7
       :0 :3 :6])

(fact "Clockwise and counter-clockwise are inverses"
      (-> [:0 :1 :2
           :3 :4 :5
           :6 :7 :8]
          rotate-face-cw
          rotate-face-ccw)
      =>
      [:0 :1 :2
       :3 :4 :5
       :6 :7 :8])

; R move
(fact "R move applied 4 times returns cube to previous state"
      (-> (solved-cube) r r r r) => (solved-cube))

(fact "R move applied 4 times returns cube to previous state"
      (-> (sample-cube) r r r r) => (sample-cube))

(fact "R' move applied 4 times returns cube to previous state"
      (-> (solved-cube) r-prime r-prime r-prime r-prime) => (solved-cube))

(fact "R' move applied 4 times returns cube to previous state"
      (-> (sample-cube) r-prime r-prime r-prime r-prime) => (sample-cube))

(fact "R and R' are inverse operations"
      (-> (solved-cube) r r-prime) => (solved-cube))

(fact "R and R' are inverse operations"
      (-> (sample-cube) r r-prime) => (sample-cube))

(fact "Three R moves are equivalent to one R' move"
      (-> (solved-cube) r r r) => (r-prime (solved-cube)))

(fact "Three R moves are equivalent to one R' move"
      (-> (sample-cube) r r r) => (r-prime (sample-cube)))

; L move
(fact "L move applied 4 times returns cube to previous state"
      (-> (solved-cube) l l l l) => (solved-cube))

(fact "L move applied 4 times returns cube to previous state"
      (-> (sample-cube) l l l l) => (sample-cube))

(fact "L' move applied 4 times returns cube to previous state"
      (-> (solved-cube) l-prime l-prime l-prime l-prime) => (solved-cube))

(fact "L' move applied 4 times returns cube to previous state"
      (-> (sample-cube) l-prime l-prime l-prime l-prime) => (sample-cube))

(fact "L and L' are inverse operations"
      (-> (solved-cube) l l-prime) => (solved-cube))

(fact "L and L' are inverse operations"
      (-> (sample-cube) l l-prime) => (sample-cube))

(fact "Three L moves are equivalent to one L' move"
      (-> (solved-cube) l l l) => (l-prime (solved-cube)))

(fact "Three L moves are equivalent to one L' move"
      (-> (sample-cube) l l l) => (l-prime (sample-cube)))

; U move
(fact "U move applied 4 times returns cube to previous state"
      (-> (solved-cube) u u u u) => (solved-cube))

(fact "U move applied 4 times returns cube to previous state"
      (-> (sample-cube) u u u u) => (sample-cube))

(fact "U' move applied 4 times returns cube to previous state"
      (-> (solved-cube) u-prime u-prime u-prime u-prime) => (solved-cube))

(fact "U' move applied 4 times returns cube to previous state"
      (-> (sample-cube) u-prime u-prime u-prime u-prime) => (sample-cube))

(fact "U and U' are inverse operations"
      (-> (solved-cube) u u-prime) => (solved-cube))

(fact "U and U' are inverse operations"
      (-> (sample-cube) u u-prime) => (sample-cube))

(fact "Three U moves are equivalent to one U' move"
      (-> (solved-cube) u u u) => (u-prime (solved-cube)))

(fact "Three U moves are equivalent to one U' move"
      (-> (sample-cube) u u u) => (u-prime (sample-cube)))

; D move
(fact "D move applied 4 times returns cube to previous state"
      (-> (solved-cube) d d d d) => (solved-cube))

(fact "D move applied 4 times returns cube to previous state"
      (-> (sample-cube) d d d d) => (sample-cube))

(fact "D' move applied 4 times returns cube to previous state"
      (-> (solved-cube) d-prime d-prime d-prime d-prime) => (solved-cube))

(fact "D' move applied 4 times returns cube to previous state"
      (-> (sample-cube) d-prime d-prime d-prime d-prime) => (sample-cube))

(fact "D and D' are inverse operations"
      (-> (solved-cube) d d-prime) => (solved-cube))

(fact "D and D' are inverse operations"
      (-> (sample-cube) d d-prime) => (sample-cube))

(fact "Three D moves are equivalent to one D' move"
      (-> (solved-cube) d d d) => (d-prime (solved-cube)))

(fact "Three D moves are equivalent to one D' move"
      (-> (sample-cube) d d d) => (d-prime (sample-cube)))

; F move
(fact "F move applied 4 times returns cube to previous state"
      (-> (solved-cube) f f f f) => (solved-cube))

(fact "F move applied 4 times returns cube to previous state"
      (-> (sample-cube) f f f f) => (sample-cube))

(fact "F' move applied 4 times returns cube to previous state"
      (-> (solved-cube) f-prime f-prime f-prime f-prime) => (solved-cube))

(fact "F' move applied 4 times returns cube to previous state"
      (-> (sample-cube) f-prime f-prime f-prime f-prime) => (sample-cube))

(fact "F and F' are inverse operations"
      (-> (solved-cube) f f-prime) => (solved-cube))

(fact "F and F' are inverse operations"
      (-> (sample-cube) f f-prime) => (sample-cube))

(fact "Three F moves are equivalent to one F' move"
      (-> (solved-cube) f f f) => (f-prime (solved-cube)))

(fact "Three F moves are equivalent to one F' move"
      (-> (sample-cube) f f f) => (f-prime (sample-cube)))

; B move
(fact "B move applied 4 times returns cube to previous state"
      (-> (solved-cube) b b b b) => (solved-cube))

(fact "B move applied 4 times returns cube to previous state"
      (-> (sample-cube) b b b b) => (sample-cube))

(fact "B' move applied 4 times returns cube to previous state"
      (-> (solved-cube) b-prime b-prime b-prime b-prime) => (solved-cube))

(fact "B' move applied 4 times returns cube to previous state"
      (-> (sample-cube) b-prime b-prime b-prime b-prime) => (sample-cube))

(fact "B and B' are inverse operations"
      (-> (solved-cube) b b-prime) => (solved-cube))

(fact "B and B' are inverse operations"
      (-> (sample-cube) b b-prime) => (sample-cube))

(fact "Three B moves are equivalent to one B' move"
      (-> (solved-cube) b b b) => (b-prime (solved-cube)))

(fact "Three B moves are equivalent to one B' move"
      (-> (sample-cube) b b b) => (b-prime (sample-cube)))