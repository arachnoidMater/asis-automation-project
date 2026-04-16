@mobile @alert
Feature: Alert Dialog

  Scenario: Alert dialog kontrol
    Given Kullanici uygulamayi acar
    When Kullanici "App" menüsünden "Alert Dialogs" ekranina gider
    And Kullanici "Repeat alarm" secenegine tiklar
    And Kullanici "Cancel" secenegine tiklar
    Then Alert dialogun kapandigi dogrulanir
    And Kullanici "Repeat alarm" secenegine tiklar
    And Kullanici "Every Friday" secenegini isaretler
    And Kullanici "OK" secenegine tiklar
    And Kullanici "Repeat alarm" secenegine tiklar
    Then "Every Friday" seceneginin secili oldugu dogrulanir