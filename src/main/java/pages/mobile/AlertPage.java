package pages.mobile;

import core.Driver;
import core.Utils;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class AlertPage {

    private final By repeatAlarmOption = AppiumBy.xpath("//*[@text='Repeat alarm']");
    private final By cancelButton = AppiumBy.xpath("//*[@text='Cancel']");
    private final By okButton = AppiumBy.xpath("//*[@text='OK']");
    private final By everyFridayOption = AppiumBy.xpath("//*[@text='Every Friday']");

    public void navigateToScreen(String menu, String screen) {
        Driver.getMobileDriver()
                .findElement(AppiumBy.xpath("//*[contains(@text,'" + menu + "')]"))
                .click();

        Driver.getMobileDriver()
                .findElement(AppiumBy.xpath("//*[contains(@text,'" + screen + "')]"))
                .click();
    }

    public void clickRepeatAlarm() {
        Utils.waitForMobileVisibility(repeatAlarmOption);
        Driver.getMobileDriver().findElement(repeatAlarmOption).click();
    }

    public void clickCancel() {
        Utils.waitForMobileVisibility(cancelButton);
        Driver.getMobileDriver().findElement(cancelButton).click();
    }

    public void clickOk() {
        Utils.waitForMobileVisibility(okButton);
        Driver.getMobileDriver().findElement(okButton).click();
    }

    public void selectEveryFriday() {
        Utils.waitForMobileVisibility(everyFridayOption);
        Driver.getMobileDriver().findElement(everyFridayOption).click();
    }

    public boolean isDialogClosed() {
        return Driver.getMobileDriver().findElements(cancelButton).isEmpty();
    }

    public boolean isEveryFridaySelected() {
        return "true".equals(
                Driver.getMobileDriver().findElement(everyFridayOption).getAttribute("checked")
        );
    }
}