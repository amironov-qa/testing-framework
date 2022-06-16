import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestOpenCart extends BaseTest {
    public static final String BASE_URL = "https://demo.opencart.com/";

    @Test
    void openCartSearchFieldTest() {
        driver.get(BASE_URL);
        assertThat(driver.getTitle(), is("Your Store"));

        var searchField = driver.findElement(By.name("search"));
        searchField.sendKeys("Iphone");
        var submitButton = driver.findElement(By.xpath("//*[@id=\"search\"]/button"));
        submitButton.click();
        assertThat(driver.getTitle(), is("500 - INTERNAL ERROR"));
    }

    @Test
    void openCartRegisterPageTest() {
        driver.get("https://demo.opencart.com/index.php?route=account/register");
        assertThat(driver.getTitle(), is("Register Account"));

        var firstName = driver.findElement(By.name("firstname"));
        var lastName = driver.findElement(By.name("lastname"));
        var email = driver.findElement(By.name("email"));
        var password = driver.findElement(By.name("password"));
        var subscribeRadioButton = driver.findElement(By.xpath("//*[@id=\"input-newsletter-yes\"]"));
        var privacyPolicy = driver.findElement(By.name("agree"));
        var continueButton = driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/div/button"));


        firstName.sendKeys("Alex");
        lastName.sendKeys("Mironov");
        email.sendKeys("a.mironov@gmail.com");
        password.sendKeys("123456789");
        subscribeRadioButton.click();
        privacyPolicy.click();
        continueButton.click();
    }
}
