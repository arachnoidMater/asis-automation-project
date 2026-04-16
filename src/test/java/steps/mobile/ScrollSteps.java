package steps.mobile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.mobile.ScrollPage;

public class ScrollSteps {

    ScrollPage scrollPage = new ScrollPage();

    @And("Kullanici scroll yaparak {string} elementini bulur")
    public void scroll_yaparak_elementi_bulur(String elementText) {
        scrollPage.scrollToText(elementText);
    }

    @And("Hedef elemente tiklar")
    public void hedef_elemente_tiklar() {
        scrollPage.clickWebView();
    }

    @Then("Detay ekrani goruntulenir")
    public void detay_ekrani_goruntulenir() {
        Assertions.assertTrue(scrollPage.isDetailPageDisplayed());
    }
}