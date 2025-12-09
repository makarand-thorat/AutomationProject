package com.travel.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

    private WebDriver driver;

    // Locators
    private By departureCityDropdown = By.name("fromPort");
    private By destinationCityDropdown = By.name("toPort");
    private By findFlightsButton = By.cssSelector("input[type='submit']");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void selectDepartureCity(String city) {
        Select select = new Select(driver.findElement(departureCityDropdown));
        select.selectByVisibleText(city);
    }

    public void selectDestinationCity(String city) {
        Select select = new Select(driver.findElement(destinationCityDropdown));
        select.selectByVisibleText(city);
    }

    public void clickFindFlights() {
        driver.findElement(findFlightsButton).click();
    }

    // Convenience method for searching flight
    public void searchFlight(String from, String to) {
        selectDepartureCity(from);
        selectDestinationCity(to);
        clickFindFlights();
    }
}
