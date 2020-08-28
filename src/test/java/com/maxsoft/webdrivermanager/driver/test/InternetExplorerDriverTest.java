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
 * Time            : 10:31 AM
 * Description     : This is an example of how to use maxsoft-webdrivermanager for internet explorer driver
 **/

public class InternetExplorerDriverTest extends TestBase {

    // Holds the WebDriver instance
    public static WebDriver driver;

    // Initialize a driver instance of internet explorer browser
    @Before
    public void initializeDriver() {
        driver = DriverFactory.getDriver(DriverFactory.IE);
        driver.manage().window().maximize();
    }

    @Test
    public void testInternetExplorerDriver() {
        testDriver(driver, BrowserType.IE);
    }

    // Close the internet explorer driver instance
    @After
    public void closeDriver() {
        driver.quit();
    }

}
