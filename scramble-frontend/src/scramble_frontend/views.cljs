(ns scramble-frontend.views
  (:require
   [re-frame.core :as re-frame]
   [scramble-frontend.subs :as subs]
   [scramble-frontend.events :as events]))

(defn main-panel []
  (let [scramble-result (re-frame/subscribe [::subs/scramble-result])
        base-string     (re-frame/subscribe [::subs/base-string])
        target-string   (re-frame/subscribe [::subs/target-string])]

    [:div
     [:h1 "Flexiana's Scramble"]
     [:form
      [:div
       [:label "Source"]
       [:input {:type "text"
                :value @base-string
                :on-change #(re-frame/dispatch
                             [::events/update-base-string (-> % .-target .-value)])}]]

      [:div
       [:label "Target"]
       [:input {:type "text"
                :value @target-string
                :on-change #(re-frame/dispatch
                             [::events/update-target-string (-> % .-target .-value)])}]]

      [:input {:type "button"
           :value "Scramble away!"
               :on-click #(re-frame/dispatch [::events/fetch-scramble])}]]

     [:br]
     [:span @scramble-result]]))
