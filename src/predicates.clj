(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== n k)))

(defn set->predicate [a-set]
  (fn [e] (contains? a-set e)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (nil? string)
      (empty? string)
      (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(has-award? book %) awards))

(defn my-some [pred a-seq]
  (let [f (filter pred a-seq)]
    (if (not (empty? f))
      (pred (first f)))))

(defn my-every? [pred a-seq]
  (not (some (complement pred) a-seq)))

(defn prime? [n]
  (not (some #(zero? (mod n %)) (range 2 n))))
;^^
