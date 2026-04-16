package steps.web;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import pages.web.AddEmployeePage;
import pages.web.AdminLoginPage;

public class AddEmployeeSteps {

    AdminLoginPage adminLoginPage = new AdminLoginPage();
    AddEmployeePage addEmployeePage = new AddEmployeePage();

    @Given("Kullanici sisteme giris yapar")
    public void kullanici_sisteme_giris_yapar() {
        adminLoginPage.login("Admin", "admin123");
    }

    @When("Kullanici sidebar uzerinden PIM menusune tiklar")
    public void kullanici_pim_menu_tiklar() {
        addEmployeePage.clickPimMenu();
    }

    @When("Kullanici tabs uzerinden Add Employee sekmesine tiklar")
    public void kullanici_add_employee_tiklar() {
        addEmployeePage.clickAddEmployeeTab();
    }

    @When("Kullanici {string} ve {string} bilgileri ile calisan ekler")
    public void kullanici_calisan_ekler(String firstName, String lastName) {
        addEmployeePage.enterEmployeeInfo(firstName, lastName);
    }

    @And("Kullanici kaydi tamamlar")
    public void kullanici_kaydi_tamamlar() {
        addEmployeePage.clickSave();
    }

    @Then("Calisan profil sayfasi acilir")
    public void calisan_profil_sayfasi_acilir() {
        Assertions.assertTrue(addEmployeePage.isProfilePageOpened());
    }

    @When("Kullanici profil bilgilerini doldurur")
    public void kullanici_profil_bilgilerini_doldurur() {
        addEmployeePage.fillProfileDetails();
    }

    @Then("Calisan basariyla kaydedilir")
    public void calisan_kaydedildi() {
        Assertions.assertTrue(addEmployeePage.isProfilePageOpened());
        Assertions.assertEquals("123", addEmployeePage.getOtherIdValue());
        Assertions.assertEquals("456789", addEmployeePage.getLicenseNumberValue());
    }
}