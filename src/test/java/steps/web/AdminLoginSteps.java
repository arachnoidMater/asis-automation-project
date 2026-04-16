package steps.web;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import pages.web.AdminLoginPage;

public class AdminLoginSteps {

    AdminLoginPage adminloginPage = new AdminLoginPage();

    @Given("Kullanici login sayfasina gider")
    public void kullanici_login_sayfasina_gider() {
    }

    @When("Kullanici gecerli kullanici adi ve sifre ile giris yapar")
    public void kullanici_gecerli_bilgilerle_giris_yapar() {
        adminloginPage.login("Admin", "admin123");
    }

    @Then("Dashboard sayfasi goruntulenir")
    public void dashboard_sayfasi_goruntulenir() {
        Assertions.assertTrue(adminloginPage.isDashboardDisplayed());
    }

    @When("Kullanici {string} ve {string} bilgileri ile giris yapar")
    public void kullanici_hatali_bilgilerle_giris_yapar(String username, String password) {
        adminloginPage.login(username, password);
    }

    @Then("Hata mesaji goruntulenir")
    public void hata_mesaji_goruntulenir() {
        Assertions.assertEquals("Invalid credentials", adminloginPage.getErrorMessageText());
    }

    @When("Kullanici bilgi girmeden login butonuna tiklar")
    public void kullanici_bos_giris_yapar() {
        adminloginPage.clickLoginButton();
    }

    @Then("Zorunlu alan uyarilari goruntulenir")
    public void zorunlu_alan_uyarilari_goruntulenir() {
        Assertions.assertTrue(adminloginPage.getRequiredMessageCount() > 0);
    }
}