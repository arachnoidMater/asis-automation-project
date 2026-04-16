@web @employeeSearch
Feature: Çalışan Arama (PIM)

  Scenario Outline: Calisan arama
    Given Kullanici sisteme giris yapar
    When Kullanici sidebar uzerinden PIM menusune tiklar
    And Kullanici "<employeeName>" alanina giris yapar
    And Arama butonuna tiklar
    Then Sonuc listesi dogru filtrelenir
    And Sonuclarda "<lastName>" bilgisi goruntulenir

    Examples:
      | employeeName | lastName |
      | Melis Ayhan  | Ayhan    |