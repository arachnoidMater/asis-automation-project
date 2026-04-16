package core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;
import java.time.Duration;

public class Driver {

    private static WebDriver driver;
    private static AndroidDriver mobileDriver;
    private static BaseConfiguration config = new BaseConfiguration();

    public static void initDriver() {

        String platform = config.getProperty("platform");

        try {
            if (platform.equalsIgnoreCase("web")) {

                if (driver == null) {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(
                            Duration.ofSeconds(Long.parseLong(config.getProperty("implicit.wait")))
                    );
                    driver.get(config.getProperty("web.url"));
                }

            } else if (platform.equalsIgnoreCase("mobile")) {

                if (mobileDriver == null) {

                    UiAutomator2Options options = new UiAutomator2Options();

                    options.setDeviceName(config.getProperty("device.name"));
                    options.setPlatformName(config.getProperty("platform.name"));
                    options.setAutomationName(config.getProperty("automation.name"));
                    options.setApp(System.getProperty("user.dir") + "/" + config.getProperty("app.path"));

                    mobileDriver = new AndroidDriver(
                            new URL(config.getProperty("appium.url")),
                            options
                    );

                    mobileDriver.manage().timeouts().implicitlyWait(
                            Duration.ofSeconds(Long.parseLong(config.getProperty("implicit.wait")))
                    );
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Driver başlatılamadı: " + e.getMessage());
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static AndroidDriver getMobileDriver() {
        return mobileDriver;
    }

    public static void quitDriver() {

        try {
            if (driver != null) {
                driver.quit();
                driver = null;
            }

            if (mobileDriver != null) {
                mobileDriver.quit();
                mobileDriver = null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}