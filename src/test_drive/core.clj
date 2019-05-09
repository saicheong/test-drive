(ns test-drive.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

;; what is Limit, Security, Cdl
;(defrecord Limit fac-type cpf-charge-type amount)
;(defrecord Security sec-type collateral-value)
;(defrecord Cdl cdl-type amount)

(defn line [line-type bank-charge limit])

(defn security [security-type advance])

(defn card [card-type limit])

(defn margin-trading-line [])

(defn legal-mortgage [mortgage-type advance])


(defn cdl-type [securities])

(defn cdl
  "returns the cdl for the given limits and securities
  limit is one of

  cdl, limit, security is one or more of type-amount tuple

  cdl type is one of:
    :fd, :mortgage, :vehicle, :margin :others, :unsecured

  limit type is
    :margin-trading :others

  security type is
    :mortgage, :vehicle, :fd, :other-secured :intangible
    "

  [limits securities])