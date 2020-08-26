package com.maxsoft.webdrivermanager.driver.test;

import com.maxsoft.webdrivermanager.driver.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

/**
 * Project Name    : maxsoft-webdriver-manager
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 3/15/2020
 * Time            : 10:00 AM
 * Description     : This is an example of how to use maxsoft-webdrivermanager for chrome driver
 **/

public class ChromeDriverTest extends TestBase {

    // Holds the WebDriver instance
    public static WebDriver driver;

    // Initialize a driver instance of chrome browser
    @Before
    public void initializeDriver() {
        driver = DriverFactory.getDriver(BrowserType.CHROME);
        driver.manage().window().maximize();
    }

    @Test
    public void testChromeDriver() {
        testDriver(driver, BrowserType.CHROME);
    }

    // Close the chrome driver instance
    @After
    public void closeDriver() {
        driver.quit();
    }

}
