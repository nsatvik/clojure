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

(defn transpose [m]
  (apply mapv vector m))

(defn winner? [board]
  (first (map keys (filter (fn [m] (and (= 1 (count m)) (or (= 3 (m "X")) (= 3 (m "O"))))) (map frequencies board)))))

(defn diagonal-winner? [board]
  (cond (= (get-in board [0 0]) (get-in board [1 1]) (get-in board [2 2]) "X") "X"
        (= (get-in board [0 0]) (get-in board [1 1]) (get-in board [2 2]) "O") "O"
        (= (get-in board [2 0]) (get-in board [1 1]) (get-in board [0 2]) "X") "X"
        (= (get-in board [2 0]) (get-in board [1 1]) (get-in board [0 2]) "O") "O"))

(defn print-board 
  "Prints the board"
  [board]
  (print (str/join "\n" (for [row board] (row-str row)))))

(defn find-winner
  "Find the winner if any"
  [board]
  (or (winner? board) (winner? (transpose board)) (diagonal-winner? board)))

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
