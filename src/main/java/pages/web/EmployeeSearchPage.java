package pages.web;

import core.Driver;
import core.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeSearchPage {

    WebDriver driver = Driver.getDriver();

    private final By employeeNameInput = By.xpath("(//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input)[1]");
    private final By searchButton = By.xpath("//button[@type='submit']");
    private final By recordFoundText = By.xpath("//span[contains(.,'Record Found')]");

    public void enterEmployeeName(String employeeName) {
        Utils.waitForVisibility(employeeNameInput);
        driver.findElement(employeeNameInput).click();
        driver.findElement(employeeNameInput).sendKeys(employeeName);
    }

    public void clickSearchButton() {
        Utils.waitForClickability(searchButton);
        driver.findElement(searchButton).click();
    }

    public boolean isOneRecordFound() {
        Utils.waitForVisibility(recordFoundText);
        String text = driver.findElement(recordFoundText).getText();
        return text.contains("(1)");
    }

    public boolean isLastNameDisplayed(String lastName) {
        By dynamicLastNameCell = By.xpath("//div[@role='row']//div[contains(text(),'" + lastName + "')]");
        Utils.waitForVisibility(dynamicLastNameCell);
        return driver.findElement(dynamicLastNameCell).isDisplayed();
    }
}