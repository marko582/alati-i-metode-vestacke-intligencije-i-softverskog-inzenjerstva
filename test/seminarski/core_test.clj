(ns seminarski.core-test
  (:require [clojure.test :refer [deftest is testing]]
            [seminarski.core :refer [solved-cube rotate-face-cw rotate-face-ccw r r-prime]]))

(deftest test-face-rotations
  (testing "Clockwise face rotation"
    (let [face [:0 :1 :2
                :3 :4 :5
                :6 :7 :8]
          expected [:6 :3 :0
                    :7 :4 :1
                    :8 :5 :2]]
      (is (= expected (rotate-face-cw face)))))

  (testing "Counter-clockwise face rotation"
    (let [face [:0 :1 :2
                :3 :4 :5
                :6 :7 :8]
          expected [:2 :5 :8
                    :1 :4 :7
                    :0 :3 :6]]
      (is (= expected (rotate-face-ccw face)))))

  (testing "Clockwise and counter-clockwise are inverses"
    (let [face [:0 :1 :2
                :3 :4 :5
                :6 :7 :8]]
      (is (= face (-> face rotate-face-cw rotate-face-ccw))))))

(deftest test-r-moves
  (testing "R move applied 4 times returns cube to previous state"
    (let [initial (solved-cube)
          after-4-r (-> initial r r r r)]
      (is (= initial after-4-r))))

  (testing "R and R' are inverse operations"
    (let [initial (solved-cube)
          modified (-> initial r r-prime)]
      (is (= initial modified)))))