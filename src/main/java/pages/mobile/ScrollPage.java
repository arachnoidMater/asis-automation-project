package pages.mobile;

import core.Driver;
import core.Utils;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ScrollPage {

    private final By webViewMenu = AppiumBy.xpath("//*[@text='WebView3']");
    private final By webViewContainer = AppiumBy.accessibilityId("Open Chrome");


    public void scrollToText(String text) {
        String uiScrollables = "new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"" + text + "\"))";

        Driver.getMobileDriver().findElement(AppiumBy.androidUIAutomator(uiScrollables));
    }

    public void clickWebView() {
        Utils.waitForMobileVisibility(webViewMenu);
        Driver.getMobileDriver().findElement(webViewMenu).click();
    }

    public boolean isDetailPageDisplayed() {
        Utils.waitForMobileVisibility(webViewContainer);
        return Driver.getMobileDriver().findElement(webViewContainer).isDisplayed();
    }
}