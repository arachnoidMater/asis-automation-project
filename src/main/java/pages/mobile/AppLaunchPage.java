package pages.mobile;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import core.Driver;
import core.Utils;

public class AppLaunchPage {

    private final By title = AppiumBy.xpath("//*[@text='API Demos']");

    public String getTitleText() {
        Utils.waitForMobileVisibility(title);
        return Driver.getMobileDriver().findElement(title).getText();
    }
}