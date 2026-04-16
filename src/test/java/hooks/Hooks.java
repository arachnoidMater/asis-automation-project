package hooks;

import core.BaseConfiguration;
import core.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("===== START: " + scenario.getName() + " =====");
        Driver.initDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                String platform = new BaseConfiguration().getProperty("platform");

                new File("target/screenshots").mkdirs();
                String fileName = scenario.getName().replaceAll(" ", "_") + ".png";

                if ("web".equalsIgnoreCase(platform) && Driver.getDriver() != null) {
                    TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();

                    byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", "Failure Screenshot");

                    File src = ts.getScreenshotAs(OutputType.FILE);
                    File dest = new File("target/screenshots/" + fileName);
                    FileUtils.copyFile(src, dest);

                } else if ("mobile".equalsIgnoreCase(platform) && Driver.getMobileDriver() != null) {
                    TakesScreenshot ts = (TakesScreenshot) Driver.getMobileDriver();

                    byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", "Failure Screenshot");

                    File src = ts.getScreenshotAs(OutputType.FILE);
                    File dest = new File("target/screenshots/" + fileName);
                    FileUtils.copyFile(src, dest);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Driver.quitDriver();
            System.out.println("===== END: " + scenario.getName() + " =====");
        }
    }
}