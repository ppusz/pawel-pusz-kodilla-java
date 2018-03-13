package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    private static final String XPATH_SELECT_BIRTHDAY_MONTH = "//div[contains(@class,\"_5k_5\")]//select[@name=\"birthday_month\"]";
    private static final String XPATH_SELECT_BIRTHDAY_DAY = "//div[contains(@class,\"_5k_5\")]//select[@name=\"birthday_day\"]";
    private static final String XPATH_SELECT_BIRTHDAY_YEAR = "//div[contains(@class,\"_5k_5\")]//select[@name=\"birthday_year\"]";

    public static void main(String[] args) {
        WebDriver webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get("https://www.facebook.com");

        while (!webDriver.findElement(By.xpath(XPATH_SELECT_BIRTHDAY_MONTH)).isDisplayed());

        Select selectDate = new Select(webDriver.findElement(By.xpath(XPATH_SELECT_BIRTHDAY_MONTH)));
        selectDate.selectByValue("10");

        selectDate = new Select(webDriver.findElement(By.xpath(XPATH_SELECT_BIRTHDAY_DAY)));
        selectDate.selectByValue("13");

        selectDate = new Select(webDriver.findElement(By.xpath(XPATH_SELECT_BIRTHDAY_YEAR)));
        selectDate.selectByValue("1989");
    }
}
