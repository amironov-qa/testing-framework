package utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Waiter {
    private static final WebDriver driver = SingletonDriver.getSingletonDriverInstance().getWebDriver();
    private static final FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(NoSuchElementException.class);

    public static void waitUntilIsDisplayed(WebElement webElement) {
        System.out.println("Waiting until web element is displayed...");
        wait.until(ExpectedConditions.visibilityOf(webElement));
        System.out.println("Web element is displayed.");
    }

    public static void waitUntilElementIsClickable(WebElement webElement) {
        System.out.println("Waiting until web element is clickable...");
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        System.out.println("Web element is clickable.");
    }
}