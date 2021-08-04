(ns scramble-frontend.subs
  (:require
   [re-frame.core :as re-frame]))

;; suscribe scramble result lambda
(re-frame/reg-sub ::scramble-result (fn [db] (:scramble-result db)))

;; suscribe base input-field lambda
(re-frame/reg-sub ::base-string (fn [db] (:base-string db)))

;; suscribe target input-field lambda
(re-frame/reg-sub ::target-string (fn [db] (:target-string db)))
