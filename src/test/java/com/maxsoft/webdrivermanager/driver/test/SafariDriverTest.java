package com.maxsoft.webdrivermanager.driver.test;

import com.maxsoft.webdrivermanager.driver.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Project Name    : maxsoft-webdriver-manager
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 3/15/2020
 * Time            : 10:33 AM
 * Description     : This is an example of how to use maxsoft-webdrivermanager for safari driver
 **/

public class SafariDriverTest extends TestBase {

    // Holds the WebDriver instance
    public static WebDriver driver;

    // Initialize a driver instance of safari browser
    @Before
    public void initializeDriver() {
        driver = DriverFactory.getDriver(DriverFactory.SAFARI);
        driver.manage().window().maximize();
    }

    @Test
    public void testSafariDriver() {
        testDriver(driver, DriverFactory.SAFARI);
    }

    // Close the safari driver instance
    @After
    public void closeDriver() {
        driver.quit();
    }
}
