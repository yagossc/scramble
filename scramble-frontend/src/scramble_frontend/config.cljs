(ns scramble-frontend.config)

(def debug?
  ^boolean goog.DEBUG)

;; Defines the api port for sending the requests.
(def api-port "8080")

;; Defines the api host for sending the requests.
(def api-host "localhost")

;; Defines the api url, based on API-HOST and API-PORT, for sending the requests.
(def api-url (str "http://" api-host ":" api-port "/scramble"))
