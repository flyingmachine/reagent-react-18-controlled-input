(ns main.app
  (:require
   ["react" :as react]
   ["react-dom/client" :refer [createRoot]]
   [goog.dom :as gdom]
   [reagent.core :as r]
   [reagent.dom.client :as client]))

(defonce root (createRoot  (gdom/getElement "app")))

(defn text []
  (r/with-let [text (r/atom "")]
    [:input {:type :text
             :on-change #(reset! text (.. % -target -value))
             :value @text}]))

(defn email []
  (r/with-let [text (r/atom "")]
    [:input {:type :email
             :on-change #(reset! text (.. % -target -value))
             :value @text}]))

(defn number []
  (r/with-let [text (r/atom "")]
    [:input {:type :number
             :on-change #(reset! text (.. % -target -value))
             :value @text}]))

(defn app
  []
  [:table
   [:tbody
    [:tr [:td "text"] [:td [text]]]
    [:tr [:td "email"] [:td [email]]]
    [:tr [:td "number"] [:td [number]]]]])

(defn ^:dev/after-load start []
  (client/render root [app]))

(defn init
  []
  (start))
