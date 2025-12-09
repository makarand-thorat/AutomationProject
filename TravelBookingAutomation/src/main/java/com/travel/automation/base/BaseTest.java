package com.travel.automation.base;

import com.travel.automation.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Hardcode ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        // Chrome options
        ChromeOptions options = new ChromeOptions();
        if (ConfigReader.getProperty("headless").equalsIgnoreCase("true")) {
            options.addArguments("--headless");
        }

        // Initialize WebDriver
        driver = new ChromeDriver(options);

        // Maximize window
        driver.manage().window().maximize();

        // Open base URL from config.properties
        driver.get(ConfigReader.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
