package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonActions;
import utils.PropertyManager;
import utils.SingletonDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static utils.StringUtils.*;

public class OpenCartStepDefs {
    private final WebDriver driver = SingletonDriver.getSingletonDriverInstance().getWebDriver();
    private final CommonActions commonActions = new CommonActions();

    @Given("register page is opened")
    public void registerPageIsOpened() {
        commonActions.navigateTo(PropertyManager.getProperty("opencart.register.url"));
        assertThat(driver.getTitle(), is("Register Account"));
    }

    @When("user entered the valid data")
    public void userEnteredTheValidData() {
        var firstName = driver.findElement(By.name("firstname"));
        var lastName = driver.findElement(By.name("lastname"));
        var email = driver.findElement(By.name("email"));
        var password = driver.findElement(By.name("password"));
        var subscribeRadioButton = driver.findElement(By.id("input-newsletter-yes"));
        var privacyPolicy = driver.findElement(By.name("agree"));
        var continueButton = driver.findElement(By.id("form-register"));

        commonActions.populateField(firstName, getRandomAlphanumeric(10));
        commonActions.populateField(lastName, getRandomAlphanumeric(10));
        commonActions.populateField(email, getRandomEmail(10));
        commonActions.populateField(password, getRandomNumeric(10));
        commonActions.scrollToWebElement(privacyPolicy);
        commonActions.clickOn(subscribeRadioButton);
        commonActions.clickOn(privacyPolicy);
        commonActions.clickOn(continueButton);
    }

    @Then("a new account is created")
    public void aNewAccountIsCreated() {
        //todo: implement
    }
}