package steps.mobile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.mobile.AlertPage;

public class AlertSteps {

    AlertPage alertPage = new AlertPage();

    @When("Kullanici {string} menüsünden {string} ekranina gider")
    public void kullanici_menuden_ekrana_gider(String menu, String screen) {
        alertPage.navigateToScreen(menu, screen);
    }

    @And("Kullanici {string} secenegine tiklar")
    public void kullanici_secenegine_tiklar(String optionName) {
        switch (optionName) {
            case "Repeat alarm":
                alertPage.clickRepeatAlarm();
                break;
            case "Cancel":
                alertPage.clickCancel();
                break;
            case "OK":
                alertPage.clickOk();
                break;
        }
    }

    @And("Kullanici {string} secenegini isaretler")
    public void kullanici_secenegini_isaretler(String optionName) {
        if (optionName.equals("Every Friday")) {
            alertPage.selectEveryFriday();
        }
    }

    @Then("Alert dialogun kapandigi dogrulanir")
    public void alert_dialogun_kapandigi_dogrulanir() {
        Assertions.assertTrue(alertPage.isDialogClosed());
    }


    @Then("{string} seceneginin secili oldugu dogrulanir")
    public void seceneginin_secili_oldugu_dogrulanir(String optionName) {
        if (optionName.equals("Every Friday")) {
            Assertions.assertTrue(alertPage.isEveryFridaySelected());
        }
    }
}