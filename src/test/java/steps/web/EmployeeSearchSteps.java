package steps.web;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import pages.web.EmployeeSearchPage;

public class EmployeeSearchSteps {

    EmployeeSearchPage employeeSearchPage = new EmployeeSearchPage();


    @When("Kullanici {string} alanina giris yapar")
    public void kullanici_alanina_giris_yapar(String employeeName) {
        employeeSearchPage.enterEmployeeName(employeeName);
    }

    @When("Arama butonuna tiklar")
    public void arama_butonuna_tiklar() {
        employeeSearchPage.clickSearchButton();
    }

    @Then("Sonuc listesi dogru filtrelenir")
    public void sonuc_listesi_dogru_filtrelenir() {
        Assertions.assertTrue(employeeSearchPage.isOneRecordFound());
    }

    @Then("Sonuclarda {string} bilgisi goruntulenir")
    public void sonuclarda_bilgisi_goruntulenir(String lastName) {
        Assertions.assertTrue(employeeSearchPage.isLastNameDisplayed(lastName));
    }
}