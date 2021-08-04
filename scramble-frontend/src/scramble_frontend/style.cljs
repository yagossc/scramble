(ns scramble-frontend.style)

(defn submit-button-style
  "Defines a reusable form button style."
  []
  {:background-color "#7f41fa"
   :border "none"
   :border-radius "14px"
   :color "white"
   :cursor "pointer"
   :float "bottom"
   :font-color "#695aed"
   :font-size "1em"
   :margin-top "10px"
   :padding "15px 20px"})

(defn main-container-style
  "Defines a reusable container style."
  []
  {:style {:align "center"
           :background-color "#f2f2f2"
           :border-radius "5px"
           :height "100%"
           :margin "0 25%"
           :padding "20px"
           :text-align "center"
           :width "50%"}})

(defn input-text-field-style
  "Defines a reusable style for the input fields."
  []
  {:border "1px solid #ccc"
   :border-radius "4px"
   :padding "12px"
   :width "50%"})

(defn label-style
  "Defines a reusable style for the input labels."
  []
  {:style {:display "inline-block"
           :padding "12px 12px 12px 0"}})
