package steps.mobile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.mobile.AppLaunchPage;

public class AppLaunchSteps {

    AppLaunchPage homePage = new AppLaunchPage();

    @Given("Kullanici uygulamayi acar")
    public void kullanici_uygulamayi_acar() {
    }

    @Then("{string} basligi goruntulenir")
    public void baslik_goruntulenir(String expectedTitle) {
        String actualTitle = homePage.getTitleText();
        Assertions.assertEquals(expectedTitle, actualTitle);
    }
}