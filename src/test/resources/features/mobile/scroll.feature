@mobile @scroll
Feature: Scroll ve Navigation

  Scenario: Scroll ile hedef elemana ulasma
    Given Kullanici uygulamayi acar
    When Kullanici "Views" alanina tiklar
    And Kullanici scroll yaparak "WebView3" elementini bulur
    And Hedef elemente tiklar
    Then Detay ekrani goruntulenir