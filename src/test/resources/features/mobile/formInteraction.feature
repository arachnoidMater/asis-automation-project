@mobile @formInteraction
Feature: Form Etkileşimi

  Scenario Outline: Form elemanlari ile etkilesim
    Given Kullanici uygulamayi acar
    When Kullanici "Views" alanina tiklar
    When Kullanici "Controls" alanindan "<theme>" ekranini acar
    And Kullanici "<text>" bilgisini input alanina girer
    And Checkbox alanlarini secer
    Then Girilen bilgi goruntulenir

    Examples:
      | text | theme       |
      | Red  | Light Theme |