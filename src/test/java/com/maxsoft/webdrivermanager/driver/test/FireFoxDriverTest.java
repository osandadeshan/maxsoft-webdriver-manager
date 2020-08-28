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
 * Time            : 10:13 AM
 * Description     : This is an example of how to use maxsoft-webdrivermanager for firefox driver
 **/

public class FireFoxDriverTest extends TestBase {

    // Holds the WebDriver instance
    public static WebDriver driver;

    // Initialize a driver instance of firefox browser
    @Before
    public void initializeDriver() {
        driver = DriverFactory.getDriver(DriverFactory.FIREFOX);
        driver.manage().window().maximize();
    }

    @Test
    public void testFireFoxDriver() {
        testDriver(driver, DriverFactory.FIREFOX);
    }

    // Close the firefox driver instance
    @After
    public void closeDriver() {
        driver.quit();
    }

}
