(ns scramble.core)


(defn occur-in?
  "Builds a list of boolean values that represent, for each char in
  INPUT-STRING, if this char is sufficiently present in the frequencies
  map INPUT-MAP"
  [input-map input-string]
  (let [tmp-map (atom input-map)]
    (for [char input-string]
      (do (if (get @tmp-map char)
            (do (swap! tmp-map
                       (fn [old-map]
                         (update old-map char dec)))
                (<= 0 (get @tmp-map char)))
            false)))))


(defn scramble?
  "Checks if a portion of BASE-STRING can be rearranged to form TARGET-STRING."
  [base-string target-string]
  (let [base-frequencies (frequencies base-string)]
    (empty? (filter false? (occur-in? base-frequencies target-string)))))


;; REPL testing
;; (scramble? "abcdefffffffffff" "abcdefg")
