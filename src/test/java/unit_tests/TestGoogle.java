package unit_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestGoogle extends BaseTest {
    public static final String BASE_URL = "https://www.google.com/";
    private WebElement searchField;

    @BeforeEach
    void beforeEach() {
        driver.get(BASE_URL);
        assertThat(driver.getTitle(), is("Google"));
        searchField = driver.findElement(By.name("q"));
    }

    @Test
    void googleTestPositive() {
        searchField.sendKeys("Java Automation lessons");
        searchField.submit();
        assertThat(driver.getTitle(), containsString("Java Automation lessons"));
    }

    @Test
    void googleTestNegative() {
        searchField.submit();
        assertThat(driver.getTitle(), is("Google"));
    }
}
