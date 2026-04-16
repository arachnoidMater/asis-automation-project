package pages.web;

import core.Driver;
import core.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage {

    WebDriver driver = Driver.getDriver();

    private final By usernameInput = By.name("username");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By errorMessage = By.xpath("//*[text()='Invalid credentials']");
    private final By requiredMessage = By.xpath("//*[text()='Required']");
    private final By dashboardHeader = By.xpath("//h6[text()='Dashboard']");

    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getErrorMessageText() {
        return driver.findElement(errorMessage).getText();
    }

    public int getRequiredMessageCount() {
        return driver.findElements(requiredMessage).size();
    }

    public boolean isDashboardDisplayed() {
        Utils.waitForVisibility(dashboardHeader);
        return driver.findElement(dashboardHeader).isDisplayed();
    }
}