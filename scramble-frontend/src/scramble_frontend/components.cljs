(ns scramble-frontend.components
  (:require
   [re-frame.core :as re-frame]
   [scramble-frontend.events :as events]
   [scramble-frontend.subs :as subs]))

(defn submit-button
  "Defines a button component for the reusable form."
  [label]
  [:input {:type "button"
           :value label
           :on-click #(re-frame/dispatch [::events/fetch-scramble])}])


(defn form-component
  "Defines a reusable two values form component.
   It receives both of each LABELS, SUBS and EVENTS."
  [labels subs events]
  (let [[label-1 label-2] labels
        [sub-1 sub-2]     subs
        [event-1 event-2] events]
    [:form
     [:div
      [:label label-1]
      [:input {:type "text"
               :value sub-1
               :on-change #(re-frame/dispatch
                            [event-1 (-> % .-target .-value)])}]]

     [:div
      [:label label-2]
      [:input {:type "text"
               :value sub-2
               :on-change #(re-frame/dispatch
                            [event-2 (-> % .-target .-value)])}]]

     [submit-button "Scramble away!"]]))
