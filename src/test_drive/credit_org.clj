(ns test-drive.credit-org
  (:require [clojure.spec.alpha :as s]))

(defn line [line-type bank-charge limit])

(defn card [card-type limit])

(defn security [security-type advance])

(defn legal-mortgage [mortgage-type advance])


(s/def ::line-type #{:guarantor :margin-trading :others})
(s/def ::bank-charge #{:first :second :fifth})
(s/def ::limit pos-int? )

(s/def ::card-type #{:unsecured :secured})

(s/def ::security-type #{:mortgage :vehicle :fd :others :intangibles})
(s/def ::advance pos-int?)
(s/def ::value pos-int?)

(s/def ::mortgage-type #{:open :closed})
(s/def ::higher-charge pos-int?)
(s/def ::cpf-charge pos-int?)
(s/def ::external-charge pos-int?)

(s/def ::line (s/keys :req [::line-type ::bank-charge ::limit]))
(s/def ::card (s/keys :req [::card-type ::limit]))
(s/def ::security (s/keys :req [::security-type ::advance]))
(s/def ::mortgage (s/keys :req [::mortgage-type ::higher-charge ::cpf-charge ::external-charge]))
