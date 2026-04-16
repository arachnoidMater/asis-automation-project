package steps.mobile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.mobile.FormPage;

public class FormSteps {

    FormPage formPage = new FormPage();
    String enteredText;

    @When("Kullanici {string} alanina tiklar")
    public void kullanici_alanina_tiklar(String menuName) {
        if (menuName.equals("Views")) {
            formPage.clickViews();
        }
    }

    @When("Kullanici {string} alanindan {string} ekranini acar")
    public void kullanici_alanindan_ekranini_acar(String menuName, String theme) {
        if (menuName.equals("Controls")) {
            formPage.openControlsTheme(theme);
        }
    }

    @And("Kullanici {string} bilgisini input alanina girer")
    public void kullanici_bilgisini_input_alanina_girer(String text) {
        enteredText = text;
        formPage.enterText(text);
    }

    @And("Checkbox alanlarini secer")
    public void checkbox_alanlarini_secer() {
        formPage.selectFormElements();
    }

    @Then("Girilen bilgi goruntulenir")
    public void girilen_bilgi_goruntulenir() {
        Assertions.assertEquals(enteredText, formPage.getInputText());
        Assertions.assertTrue(formPage.isCheckbox1Selected());
        Assertions.assertTrue(formPage.isRadioButton1Selected());
        Assertions.assertEquals("Mars", formPage.getSelectedPlanet());
    }
}