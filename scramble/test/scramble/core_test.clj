(ns scramble.core-test
  (:require [clojure.test :refer :all]
            [scramble.core :refer :all]))


(deftest scramble-test-success
  (testing "scramble? test success cases"
    (is (= true (and (scramble? "rekqodlw" "world")
                     (scramble? "cedewaraaossoqqyt" "codewars")
                     (scramble? "abcdeeeee" "cde")
                     (scramble? "helloworld" "world")
                     (scramble? "123" "1")
                     (scramble? "11" "11")
                     (scramble? "112" "11")
                     (scramble? "anything" "")
                     (scramble? "" ""))))))

(deftest scramble-test-fail
  (testing "scramble? test fail cases"
    (is (= false (and (scramble? "abcd"  "cde")
                      (scramble? "11" "111")
                      (scramble? "nope" "nopes")
                      (scramble? "yep" "yeps")
                      (scramble? "" "anything"))))))

