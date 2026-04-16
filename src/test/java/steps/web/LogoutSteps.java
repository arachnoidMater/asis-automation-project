package steps.web;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.web.LogoutPage;

public class LogoutSteps {

    LogoutPage logoutPage = new LogoutPage();

    @When("Kullanici sag ustteki profil menusune tiklar")
    public void kullanici_sag_ustteki_profil_menusune_tiklar() {
        logoutPage.clickProfileMenu();
    }

    @When("Kullanici Logout secenegine tiklar")
    public void kullanici_logout_secenegine_tiklar() {
        logoutPage.clickLogout();
    }

    @Then("Login sayfasi goruntulenir")
    public void login_sayfasi_goruntulenir() {
        Assertions.assertTrue(
                logoutPage.isLoginPageDisplayed(),
                "Login sayfasi goruntulenemedi!"
        );
    }
}