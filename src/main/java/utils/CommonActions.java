package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static utils.Waiter.waitUntilElementIsClickable;
import static utils.Waiter.waitUntilIsDisplayed;

public class CommonActions { //todo: each method will be "wrapped" with logger
    private final WebDriver driver = SingletonDriver.getSingletonDriverInstance().getWebDriver();

    public void navigateTo(String url) {
        System.out.println("User navigates to " + url + "...");
        driver.navigate().to(url);
        System.out.println("User navigated to " + url + ".");
    }

    public void populateField(WebElement webElement, String text) {
        System.out.println("User populates field with \"" + text + "\"...");
        waitUntilIsDisplayed(webElement);
        webElement.clear();
        webElement.sendKeys(text);
        System.out.println("User populated field with \"" + text + "\".");
    }

    public void clickOn(WebElement webElement) {
        System.out.println("User clicks on web element...");
        waitUntilElementIsClickable(webElement);
        webElement.click();
        System.out.println("User clicked on web element.");
    }

    public void scrollToWebElement(WebElement webElement) {
        System.out.println("User scrolls \"" + driver.getTitle() + "\" page until web element is displayed...");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        waitUntilIsDisplayed(webElement);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("User scrolled \"" + driver.getTitle() + "\" page until web element was displayed.");
    }

    public void doubleClick(WebElement webElement) {
        waitUntilElementIsClickable(webElement);
        Actions actions = new Actions(driver);
        actions.doubleClick().perform();
    }

    public void dragAndDrop(WebElement source, WebElement target) {
        waitUntilElementIsClickable(source);
        waitUntilIsDisplayed(target);
        Actions actions = new Actions(driver);
        actions.clickAndHold(source).moveToElement(target).release().build().perform();
    }
}