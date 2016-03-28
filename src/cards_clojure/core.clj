(ns cards-clojure.core
  (:gen-class))

(def suits [:clubs :spades :hearts :diamonds])
(def ranks (range 1 14))
(def rank-names {1 :ace 11 :jack 12 :queen 13 :king})

(defn create-deck [] ; CREATES ALL COMBINATIONS OF SUITS AND RANKS
  (set
    (for [suit suits
          rank ranks]
      {:suit suit
       :rank (get rank-names rank rank)})))
      
(defn create-hands [deck]
  (set
    (for [c1 deck
          c2 (disj deck c1)
          c3 (disj deck c1 c2)
          c4 (disj deck c1 c2 c3)]
      #{c1 c2 c3 c4})))

(defn -main []
  (let [deck (create-deck)
        hands (create-hands deck)]
    (count hands)))
