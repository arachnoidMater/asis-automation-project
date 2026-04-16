package pages.web;

import core.Driver;
import core.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployeePage {

    WebDriver driver = Driver.getDriver();

    private final By pimMenu = By.xpath("//span[text()='PIM']");
    private final By addEmployeeTab = By.xpath("//a[text()='Add Employee']");
    private final By firstNameInput = By.name("firstName");
    private final By lastNameInput = By.name("lastName");
    private final By saveButton = By.xpath("//button[@type='submit']");
    private final By profileHeader = By.xpath("//h6[text()='Personal Details']");
    private final By otherIdInput = By.xpath("//label[text()='Other Id']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By licenseNumberInput = By.xpath("//label[text()=\"Driver's License Number\"]/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By licenseExpiryDateInput = By.xpath("//label[text()='License Expiry Date']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By nationalityDropdown = By.xpath("//label[text()='Nationality']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private final By maritalStatusDropdown = By.xpath("//label[text()='Marital Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private final By dateOfBirthInput = By.xpath("//label[text()='Date of Birth']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By femaleGenderRadio = By.xpath("//label[text()='Female']");
    private final By dropdownOptionTurkish = By.xpath("//span[text()='Turkish']");
    private final By dropdownOptionSingle = By.xpath("//span[text()='Single']");
    private final By formLoader = By.cssSelector(".oxd-form-loader");

    public void clickPimMenu() {
        Utils.waitForClickability(pimMenu);
        driver.findElement(pimMenu).click();
    }

    public void clickAddEmployeeTab() {
        Utils.waitForClickability(addEmployeeTab);
        driver.findElement(addEmployeeTab).click();
    }

    public void enterEmployeeInfo(String firstName, String lastName) {
        Utils.waitForVisibility(firstNameInput);
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void clickSave() {
        Utils.waitForClickability(saveButton);
        driver.findElement(saveButton).click();
    }

    public boolean isProfilePageOpened() {
        Utils.waitForVisibility(profileHeader);
        return driver.findElement(profileHeader).isDisplayed();
    }

    public String getOtherIdValue() {
        return driver.findElement(otherIdInput).getAttribute("value");
    }

    public String getLicenseNumberValue() {
        return driver.findElement(licenseNumberInput).getAttribute("value");
    }

    public void fillProfileDetails() {

        Utils.waitForInvisibility(formLoader);

        //Utils.waitForVisibility(otherIdInput);
        driver.findElement(otherIdInput).click();
        driver.findElement(otherIdInput).sendKeys("123");

        driver.findElement(licenseNumberInput).click();
        driver.findElement(licenseNumberInput).sendKeys("456789");
        driver.findElement(licenseExpiryDateInput).sendKeys("2026-12-31");

        Utils.waitForClickability(nationalityDropdown);
        driver.findElement(nationalityDropdown).click();
        driver.findElement(dropdownOptionTurkish).click();

        Utils.waitForClickability(maritalStatusDropdown);
        driver.findElement(maritalStatusDropdown).click();
        driver.findElement(dropdownOptionSingle).click();

        driver.findElement(dateOfBirthInput).sendKeys("1995-10-10");
        driver.findElement(femaleGenderRadio).click();
    }
}