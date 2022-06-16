package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Driver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static utils.StringUtils.*;

public class OpenCartStepDefs {
    public static final String REGISTER_PAGE_PATH = "https://demo.opencart.com/index.php?route=account/register";
    private final ChromeDriver driver = Driver.getInstance();

    @Given("register page is opened")
    public void registerPageIsOpened() {
        driver.get(REGISTER_PAGE_PATH);
        assertThat(driver.getTitle(), is("Register Account"));
    }

    @When("user entered the valid data")
    public void userEnteredTheValidData() {
        var firstName = driver.findElement(By.name("firstname"));
        var lastName = driver.findElement(By.name("lastname"));
        var email = driver.findElement(By.name("email"));
        var password = driver.findElement(By.name("password"));
        var subscribeRadioButton = driver.findElement(By.xpath("//*[@id=\"input-newsletter-yes\"]"));
        var privacyPolicy = driver.findElement(By.name("agree"));
        var continueButton = driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/div/button"));

        firstName.sendKeys(getRandomAlphanumeric((10)));
        lastName.sendKeys(getRandomAlphanumeric(10));
        email.sendKeys(getRandomEmail(10));
        password.sendKeys(getRandomNumeric(10));
        subscribeRadioButton.click();
        privacyPolicy.click();
        continueButton.click();
    }

    @Then("a new account is created")
    public void aNewAccountIsCreated() {
    }
}
