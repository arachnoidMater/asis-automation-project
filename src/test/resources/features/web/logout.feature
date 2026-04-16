@web @logout
Feature: Logout

  Scenario: Basarili logout
    Given Kullanici sisteme giris yapar
    When Kullanici sag ustteki profil menusune tiklar
    And Kullanici Logout secenegine tiklar
    Then Login sayfasi goruntulenir