(ns game-of-life.core
  (:require [clojure.string :as str])
  (:gen-class))


(def board [[" "  "0"  " "] ["0"  " "  "O"] [" "  "0"  " "]])
(def empty-board [[" "  " "  " "] [" "  " "  " "] [" "  " "  " "]])

(defn mark-cell
  "Mark the cell in the board"
  [board row col val]
  (assoc-in board [row col] val))

(defn get-cell
  "Returns the element at a cell in board"
  [board row col]
  {:pre [(<= 0 row 2) (<= 0 col 2)]}
  (get-in board [row col]))

(defn row-str
  [row]
  (str " " (str/join " | " row) " "))

(defn print-board 
  "Prints the board"
  [board]
  (do (println (str/join "\n" (for [row board] (row-str row))))
      (println "--------------------------------")))

(defn neighbour-count [board r c]
  (count (filter (fn [x] (= x "0")) [(get-in board [(- r 1) (- c 1)])
                            (get-in board [(- r 1) c]) 
                            (get-in board [(- r 1) (+ c 1)]) 
                            (get-in board [r (- c 1)]) 
                            (get-in board [r (+ c 1)]) 
                            (get-in board [(+ 1 r) (- c 1)]) 
                            (get-in board [(+ 1 r) c]) 
                            (get-in board [(+ r 1) (+ c 1)])])))

(defn next-generation [board next-gen-board r c]
  (do (print-board  board) (print-board next-gen-board) (println r c)
      (if (= r 3)
    next-gen-board
    (if (= c 3)
      (next-generation board next-gen-board (+ r 1) 0)
      (if (or (= 2 (neighbour-count board r c)) false) 
        (next-generation board (mark-cell next-gen-board r c "0") r (+ c 1))
        (next-generation board next-gen-board r (+ c 1)))))))



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
