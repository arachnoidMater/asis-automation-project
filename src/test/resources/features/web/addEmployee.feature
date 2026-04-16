@web @addEmployee
Feature: Çalışan Ekleme

  Scenario Outline: Yeni calisan ekleme
    Given Kullanici sisteme giris yapar
    When Kullanici sidebar uzerinden PIM menusune tiklar
    When Kullanici tabs uzerinden Add Employee sekmesine tiklar
    When Kullanici "<firstName>" ve "<lastName>" bilgileri ile calisan ekler
    And Kullanici kaydi tamamlar
    Then Calisan profil sayfasi acilir
    And Kullanici profil bilgilerini doldurur
    And Kullanici kaydi tamamlar
    Then Calisan basariyla kaydedilir

    Examples:
      | firstName | lastName |
      | Melis     | Ayhan    |