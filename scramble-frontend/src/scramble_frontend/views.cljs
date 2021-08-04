(ns scramble-frontend.views
  (:require
   [re-frame.core :as re-frame]
   [scramble-frontend.components :as components]
   [scramble-frontend.subs :as subs]
   [scramble-frontend.events :as events]))

(defn main-panel []
  (let [scramble-result (re-frame/subscribe [::subs/scramble-result])
        base-string     (re-frame/subscribe [::subs/base-string])
        target-string   (re-frame/subscribe [::subs/target-string])]

    [:div
     [:h1 "Flexiana's Scramble"]

     [:div [components/form-component
            ["Source" "Target"]
            [@base-string @target-string]
            [::events/update-base-string ::events/update-target-string]]]

     [:br]
     [:span @scramble-result]]))
