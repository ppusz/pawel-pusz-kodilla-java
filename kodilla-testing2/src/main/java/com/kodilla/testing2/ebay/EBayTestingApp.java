package com.kodilla.testing2.ebay;

import com.kodilla.testing2.google.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBayTestingApp {

    private final static String SEARCHFIELD_ID = "gh-ac";
    private final static String SEARCHFIELD_NAME = "_nkw";
    private final static String EBAY_PAGE_ADRESS = "https://www.ebay.com";
    private final static String SEARCH_TERM = "Laptop";

    public static void main(String[] args) {
        WebDriver driverFirefox = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driverFirefox.get(EBAY_PAGE_ADRESS);
        WebElement searchFieldFirefox = driverFirefox.findElement(By.id(SEARCHFIELD_ID));
        searchFieldFirefox.sendKeys(SEARCH_TERM);
        searchFieldFirefox.submit();

        WebDriver driverChrome = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverChrome.get(EBAY_PAGE_ADRESS);
        WebElement searchFieldChrome = driverChrome.findElement(By.name(SEARCHFIELD_NAME));
        searchFieldChrome.sendKeys(SEARCH_TERM);
        searchFieldChrome.submit();
    }
}
