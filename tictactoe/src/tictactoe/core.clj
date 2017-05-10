(ns tictactoe.core
  (:require [clojure.string :as str])
  (:gen-class))

(def board-size 2) ;starts from 0
(def board [["X"  "O"  " "] [" "  " "  " "] [" "  " "  " "]])

(defn mark-cell
  "Mark the cell in the board"
  [board row col val]
  {:pre [(<= 0 row board-size) (<= 0 col board-size) (= " " (get-in board [row col]))]}
  (assoc-in board [row col] val))

(defn read-cell
  "Returns the element at a cell in board"
  [board row col]
  {:pre [(<= 0 row board-size) (<= 0 col board-size)]}
  (get-in board [row col]))

(defn row-str
  [row]
  (str " " (str/join " | " row) " "))

(defn print-board 
  "Prints the board"
  [board]
  (print (str/join "\n" (for [row board] (row-str row)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
