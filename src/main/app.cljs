(ns main.app
  (:require
   ["react" :as react]
   ["react-dom/client" :refer [createRoot]]
   [goog.dom :as gdom]
   [reagent.core :as r]))

(defonce root (createRoot  (gdom/getElement "app")))

(defn repro []
  (r/with-let [text (r/atom "")]
    [:input {:type :email
             :on-change #(reset! text (.. % -target -value))
             :value @text}]))
(defn app
  []
  [:div
   "email type repro"
   [repro]])

(defn ^:dev/after-load start []
  (prn "starting")
  (.render root (r/as-element [app])))

(defn init
  []
  (start))
