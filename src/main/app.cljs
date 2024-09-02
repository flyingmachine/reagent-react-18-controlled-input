(ns main.app
  (:require
   [goog.dom :as gdom]
   [reagent.core :as r]
   [reagent.dom :as rdom]))

(defn text []
  (r/with-let [text (r/atom "")]
    [:input {:type :text
             :on-change #(reset! text (.. % -target -value))
             :value @text}]))

(defn password []
  (r/with-let [text (r/atom "")]
    [:input {:type :password
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
    [:tr [:td "password"] [:td [password]]]
    [:tr [:td "email"] [:td [email]]]
    [:tr [:td "number"] [:td [number]]]]])

(defn ^:dev/after-load start []
  (rdom/render [app] (gdom/getElement "app")))

(defn init
  []
  (start))
