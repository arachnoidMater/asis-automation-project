package pages.mobile;

import core.Driver;
import core.Utils;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class FormPage {

    private final By viewsMenu = AppiumBy.xpath("//*[@text='Views']");
    private final By controlsMenu = AppiumBy.xpath("//*[@text='Controls']");
    private final By inputField = AppiumBy.className("android.widget.EditText");

    private final By checkbox1 = AppiumBy.accessibilityId("Checkbox 1");
    private final By checkbox2 = AppiumBy.accessibilityId("Checkbox 2");
    private final By radioButton1 = AppiumBy.accessibilityId("RadioButton 1");
    private final By starButton = AppiumBy.accessibilityId("Star");

    private final By firstToggleButton = AppiumBy.xpath("(//*[@text='OFF'])[1]");
    private final By planetDropdown = AppiumBy.xpath("//*[@text='Mercury']");
    private final By marsOption = AppiumBy.xpath("//*[@text='Mars']");

    public void clickViews() {
        Utils.waitForMobileVisibility(viewsMenu);
        Driver.getMobileDriver().findElement(viewsMenu).click();
    }

    public void openControlsTheme(String theme) {
        Utils.waitForMobileVisibility(controlsMenu);
        Driver.getMobileDriver().findElement(controlsMenu).click();

        By themeOption = AppiumBy.xpath("//*[contains(@text,'" + theme + "')]");
        Utils.waitForMobileVisibility(themeOption);
        Driver.getMobileDriver().findElement(themeOption).click();
    }

    public void enterText(String text) {
        Utils.waitForMobileVisibility(inputField);
        Driver.getMobileDriver().findElement(inputField).click();
        Driver.getMobileDriver().findElement(inputField).sendKeys(text);
        try {
            Driver.getMobileDriver().hideKeyboard();
        } catch (Exception ignored) {
        }
    }

    public void selectFormElements() {
        Driver.getMobileDriver().findElement(checkbox1).click();
        Driver.getMobileDriver().findElement(checkbox2).click();
        Driver.getMobileDriver().findElement(radioButton1).click();
        Driver.getMobileDriver().findElement(starButton).click();
        Driver.getMobileDriver().findElement(firstToggleButton).click();

        Driver.getMobileDriver().findElement(planetDropdown).click();
        Utils.waitForMobileVisibility(marsOption);
        Driver.getMobileDriver().findElement(marsOption).click();
    }

    public String getInputText() {
        return Driver.getMobileDriver().findElement(inputField).getText();
    }

    public boolean isCheckbox1Selected() {
        return "true".equals(Driver.getMobileDriver().findElement(checkbox1).getAttribute("checked"));
    }

    public boolean isRadioButton1Selected() {
        return "true".equals(Driver.getMobileDriver().findElement(radioButton1).getAttribute("checked"));
    }

    public String getSelectedPlanet() {
        return Driver.getMobileDriver().findElement(marsOption).getText();
    }
}