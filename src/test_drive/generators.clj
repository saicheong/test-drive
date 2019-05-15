(ns test-drive.generators
  (:require [clojure.test.check.generators :as gen]))



(comment
  (clojure.core/require 'test-drive.generators)

  (def s gen/sample)
  (def g gen/generate)

  "Generate a min-max tuple that can be used to
  generate the existing limit and new limit
  ===================================================="

  "Strategy 1: given the existing limit - generate a
  new limit that is higher than existing"

  (defn more-than [n]
    (gen/tuple
      (gen/return n)
      (gen/choose n (* 5 (inc n)))))

  (defn more-than2 [n]
    [n (* 5 (inc n))])

  (s (gen/choose 0 5))

  (s (gen/bind gen/pos-int more-than))
  (s (gen/fmap more-than2 gen/pos-int))


  (def min-max (gen/fmap (fn [n] [n (* (inc n) 5)])
                         gen/pos-int))

  (def min-max2 (gen/bind gen/pos-int
                          (fn [n]
                            (let [m (inc n)]
                              (gen/tuple (gen/return n)
                                         (gen/choose m (* m 5)))))))

  (def min-max3 (gen/let [n gen/pos-int
                          k (gen/choose (inc n) (* (inc n) 5))]
                  [n k]))

  (def min-max4 (gen/let [n gen/pos-int]
                  (gen/tuple (gen/return n)
                             (gen/choose (inc n)
                                         (* (inc n) 5)))))

  (time (last (s min-max 50)))
  (time (last (s min-max2 50)))
  (time (last (s min-max3 50)))
  (time (last (s min-max4 50)))

  (s min-max4 5)

  "Strategy 2: Just generate 2 ints representing existing
  and increment"
  (s (gen/vector gen/pos-int 2))

  (s (gen/tuple gen/pos-int gen/s-pos-int))


  "Generate a collection that contain a single LM along
  with a number of other security "

  (def other-secs (gen/vector (gen/elements [:FD :SS :UT :IN]) 1 3))
  (def LMs (gen/vector (gen/return :LM) 1 2))

  (g (gen/tuple LMs other-secs))
  (g (gen/fmap flatten (gen/tuple LMs other-secs)))



  "Generate collections"
  (s (gen/vector gen/pos-int))
  (s (gen/not-empty (gen/vector gen/pos-int)))

=======)
