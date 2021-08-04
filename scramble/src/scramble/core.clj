(ns scramble.core
  (:require [clojure.pprint :as pp]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer :all]
            [org.httpkit.server :as server]))


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

(defn parse-response
  "Parses and returns the HTTP response."
  [status body]
  {:status  status
   :headers {"Content-Type" "text/html"
             "Access-Control-Allow-Origin" "*"
             "Access-Control-Allow-Headers" "Content-Type"}
   :body (str body)})


(defn scramble-route
  "Scramble route's handler function"
  [req]
  (let [base-string (-> req :params :base-string)
        target-string (-> req :params :target-string)]
    ;; debugging
    (pp/pprint req)
    (if (scramble? base-string target-string)
      (parse-response 200 "Yep, that works.")
      (parse-response 200 "Nope, sorry."))))


(defroutes app-routes
  "Defines server's routes and handlers."
  (GET "/scramble" [] scramble-route)
  (route/not-found "Not found."))


(defn -main
  "Backend application's entry point."
  [& args]
  (let [port (Integer/parseInt (or (System/getenv "SCRAMBLE_PORT")
                                   "8080"))]
    (server/run-server
     (wrap-defaults #'app-routes site-defaults) {:port port})
    (println (str "Running server at http://127.0.0.1:" port "/"))))
