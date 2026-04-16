@web @login
Feature: Admin Login

  Scenario: Basarili giris
    Given Kullanici login sayfasina gider
    When Kullanici gecerli kullanici adi ve sifre ile giris yapar
    Then Dashboard sayfasi goruntulenir

  Scenario Outline: Hatali giris
    Given Kullanici login sayfasina gider
    When Kullanici "<username>" ve "<password>" bilgileri ile giris yapar
    Then Hata mesaji goruntulenir

    Examples:
      | username | password |
      | Wrong    | wrong123 |

  Scenario: Bos alan validasyon kontrol
    Given Kullanici login sayfasina gider
    When Kullanici bilgi girmeden login butonuna tiklar
    Then Zorunlu alan uyarilari goruntulenir