package com.travel.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver initializeDriver(String browser) {

        switch (browser.toLowerCase()) {
            case "chrome":
                // Set path to your chromedriver.exe
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

                ChromeOptions options = new ChromeOptions();
                if (ConfigReader.getProperty("headless").equalsIgnoreCase("true")) {
                    options.addArguments("--headless");
                }
                driver = new ChromeDriver(options);
                break;

            case "firefox":
                // Set path to your geckodriver.exe
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;

            case "edge":
                // Set path to your msedgedriver.exe
                System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
                driver = new EdgeDriver();
                break;

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        return driver;
    }
}