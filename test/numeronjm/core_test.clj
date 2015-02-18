(ns numeronjm.core-test
  (:require [clojure.test :refer :all]
            [numeronjm.core :refer :all]))

(deftest a-test
  (testing "internationalization gives i18n"
    (is (= (make-numeronym "internationalization") "i18n")))
  (testing "localization gives l10n"
    (is (= (make-numeronym "localization") "l10n")))
  (testing "empty string gives empty string"
    (is (= (make-numeronym "") "")))
  (testing "2 charactered inputs gives just those 2 characters"
    (is (= (make-numeronym "ab") "ab"))))
