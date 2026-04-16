package pages.web;

import org.openqa.selenium.By;
import core.Driver;
import core.Utils;

public class LogoutPage {

    private final By profileMenu = By.xpath("//span[@class='oxd-userdropdown-tab']");
    private final By logoutButton = By.xpath("//a[text()='Logout']");
    private final By loginPageTitle = By.xpath("//h5[text()='Login']");

    public void clickProfileMenu() {
        Utils.waitForVisibility(profileMenu);
        Driver.getDriver().findElement(profileMenu).click();
    }

    public void clickLogout() {
        Utils.waitForVisibility(logoutButton);
        Driver.getDriver().findElement(logoutButton).click();
    }

    public boolean isLoginPageDisplayed() {
        Utils.waitForVisibility(loginPageTitle);
        return Driver.getDriver().findElement(loginPageTitle).isDisplayed();
    }
}