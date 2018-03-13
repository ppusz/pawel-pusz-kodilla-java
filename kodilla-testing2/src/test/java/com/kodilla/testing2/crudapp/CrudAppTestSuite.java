package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class CrudAppTestSuite {

    private final static String BASE_URL = "https://ppusz.github.io/";
    private WebDriver webDriver;
    private Random generator;

    @Before
    public void initTests() {
        webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get(BASE_URL);
        generator = new Random();
    }

    @After
    public void cleanUpAfterTest() {
        webDriver.close();
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action,\"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action,\"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action,\"createTask\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = webDriver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = webDriver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = webDriver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        webDriver.navigate().refresh();

        while (!webDriver.findElement(By.xpath("//select[1]")).isDisplayed());

        webDriver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard = theForm.findElement(By.xpath(".//button[contains(@class,\"card-creation\")]"));
                    buttonCreateCard.click();
                });
        Thread.sleep(5000);
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        driverTrello.findElement(By.id("user")).sendKeys("pawepusz");
        driverTrello.findElement(By.id("password")).sendKeys("haslo123");
        driverTrello.findElement(By.id("login")).submit();

        Thread.sleep(2000);

        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//span[@title=\"Kodilla Application\"]")).size() > 0)
                .forEach(aHref -> aHref.click());

        Thread.sleep(2000);

        result = driverTrello.findElements(By.xpath("//span")).stream()
                .filter(theSpan -> theSpan.getText().equals(taskName))
                .collect(Collectors.toList())
                .size() > 0;

        driverTrello.close();

        return result;
    }

    private void removeTaskFromCrudApp(String taskName) throws InterruptedException {
        webDriver.switchTo().alert().dismiss();

        webDriver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(form ->
                        form.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(form ->
                    form.findElements(By.xpath(".//button")).stream()
                            .filter(button -> button.getText().equals("Delete"))
                            .forEach(WebElement::click));

        Thread.sleep(1000);
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));
        removeTaskFromCrudApp(taskName);
    }
}
