package com.maxsoft.webdrivermanager.driver.test;

import org.junit.Assert;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Project Name    : maxsoft-webdriver-manager
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 3/15/2020
 * Time            : 12:16 PM
 * Description     :
 **/

public class TestBase {

    public void testDriver(WebDriver driver, String browserName){
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String runningBrowserName = cap.getBrowserName().toLowerCase();
        Assert.assertEquals(browserName, runningBrowserName);

        driver.get("http://automationpractice.com/");
        Assert.assertEquals("My Store", driver.getTitle());
    }
}
