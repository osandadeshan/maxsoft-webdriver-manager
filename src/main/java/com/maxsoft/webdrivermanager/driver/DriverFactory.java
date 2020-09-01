package com.maxsoft.webdrivermanager.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Project Name    : maxsoft-webdriver-manager
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 3/15/2020
 * Time            : 9:57 AM
 * Description     : This class will instantiate the browser instance. In your project, you can call WebDriver driver = DriverFactory.getDriver("chrome");
 **/

public class DriverFactory {

    public static final String CHROME = "chrome";
    public static final String HEADLESS_CHROME = "headless-chrome";
    public static final String FIREFOX = "firefox";
    public static final String HEADLESS_FIREFOX = "headless-firefox";
    public static final String IE = "ie";
    public static final String EDGE = "edge";
    public static final String SAFARI = "safari";
    private static final String WINDOW_WIDTH = "1440";
    private static final String WINDOW_HEIGHT = "900";
    private static final String WINDOW_SIZE = "--window-size=" + WINDOW_WIDTH + "x" + WINDOW_HEIGHT;

    public static WebDriver getDriver(String browserName) {
        if (browserName == null) {
            System.out.println("Browser name is null.\nInitializing a chrome driver instance.........");
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
        switch (browserName.toLowerCase()) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case HEADLESS_CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("start-maximized"); // open Browser in maximized mode
                chromeOptions.addArguments("disable-infobars"); // disabling info bars
                chromeOptions.addArguments("--disable-extensions"); // disabling extensions
                chromeOptions.addArguments("--disable-gpu"); // applicable to windows os only
                chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
                chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(chromeOptions);
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case HEADLESS_FIREFOX:
                FirefoxBinary firefoxBinary = new FirefoxBinary();
                firefoxBinary.addCommandLineOptions("--headless");
                firefoxBinary.addCommandLineOptions(WINDOW_SIZE);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary(firefoxBinary);
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(firefoxOptions);
            case IE:
                System.setProperty("webdriver.ie.driver", "./src/main/resources/IEDriverServer.exe");
                return new InternetExplorerDriver();
            case EDGE:
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case SAFARI:
                return new SafariDriver();
            default:
                System.out.println("Given browser name \"" + browserName + "\" is not supported!\nInitializing a chrome driver instance.........");
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }
    }

}