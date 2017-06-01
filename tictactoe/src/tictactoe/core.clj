(ns tictactoe.core
  (:require [clojure.string :as str])
  (:gen-class))

(def board [["X"  "X"  "X"] ["O"  "O"  "O"] ["X"  "X"  "O"]])

(defn mark-cell
  "Mark the cell in the board"
  [board row col val]
  {:pre [(<= 0 row 2) (<= 0 col 2) (= " " (get-in board [row col]))]}
  (assoc-in board [row col] val))

(defn get-cell
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

(defn find-winner
  "Find the winner if any"
  [board]
  (print "Finds the winner if any"))

(defn draw? 
  "Checks if it is a draw based on blank counts"
  [board]
  (zero? (apply + (map (fn [m] (m " " 0)) (map frequencies board)))))



(defn start-game
  "Starts the game"
  []
  (println "Starts the game"))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Enter :")
  (def input (read-line))
  (println (int input))
  (println "End"))
