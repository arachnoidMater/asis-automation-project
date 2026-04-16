package core;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {

    private static final int TIMEOUT = 10;

    //web
    public static void waitForVisibility(By locator) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForClickability(By locator) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForInvisibility(By locator) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    //mobile
    public static void waitForMobileVisibility(By locator) {
        new WebDriverWait(Driver.getMobileDriver(), Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}