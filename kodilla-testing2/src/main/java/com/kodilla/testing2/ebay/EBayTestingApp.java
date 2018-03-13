package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBayTestingApp {

    private final static String SEARCHFIELD_ID = "gh-ac";
    private final static String SEARCHFIELD_NAME = "_nkw";
    private final static String EBAY_PAGE_ADRESS = "https://www.ebay.com";
    private final static String SEARCH_TERM = "Laptop";

    public static void main(String[] args) {
        WebDriver webDriver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        webDriver.get(EBAY_PAGE_ADRESS);
        WebElement searchField = webDriver.findElement(By.id(SEARCHFIELD_ID));
        searchField.sendKeys(SEARCH_TERM);
        searchField.submit();

        webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get(EBAY_PAGE_ADRESS);
        searchField = webDriver.findElement(By.name(SEARCHFIELD_NAME));
        searchField.sendKeys(SEARCH_TERM);
        searchField.submit();
    }
}
