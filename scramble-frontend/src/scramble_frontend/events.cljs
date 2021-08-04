(ns scramble-frontend.events
  (:require
   [re-frame.core :as re-frame]
   [scramble-frontend.db :as db]
   [scramble-frontend.config :as config]
   [day8.re-frame.http-fx]
   [ajax.core :as ajax]
   ))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(re-frame/reg-event-fx
 ::update-base-string
 (fn [world-state event]
   (let [new-value (second event)
         db        (:db world-state)
         new-db    (assoc db :base-string new-value)]
     {:db new-db})))

(re-frame/reg-event-fx
 ::update-target-string
 (fn [world-state event]
   (let [new-value (second event)
         db        (:db world-state)
         new-db    (assoc db :target-string new-value)]
     {:db new-db})))

(re-frame/reg-event-fx
 ::fetch-scramble
 (fn [world-state _]
   (let [db            (:db world-state)
         base-string   (:base-string db)
         target-string (:target-string db)]

         {:http-xhrio {:method :get
                       :uri (str config/api-url
                                 "?base-string=" base-string
                                 "&target-string=" target-string)
                       :timeout         1000
                       :response-format (ajax/text-response-format)
                       :on-success      [::request-success]
                       :on-failure      [::connection-error]}})))

(re-frame/reg-event-fx
 ::request-success
 (fn [world-state event]
   (let [db (:db world-state)
         response (second event)
         new-db (assoc db :scramble-result response)]
     {:db new-db})))

(re-frame/reg-event-fx
 ::connection-error
 (fn [world-state event]
   (let [db (:db world-state)
         response (second event)
         new-db (assoc db :scramble-result
                       (str "Error: " (get response :status-text)))]
     {:db new-db})))
