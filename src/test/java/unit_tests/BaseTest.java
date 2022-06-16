package unit_tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.commons.annotation.Testable;
import org.openqa.selenium.chrome.ChromeDriver;

@Testable
public class BaseTest {
    public static final String CHROME_DRIVER_PATH = "src/main/resources/chromedriver.exe";
    public static ChromeDriver driver;

    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
    }

    @AfterAll
    static void afterAll() {
        driver.close();
        driver.quit();
    }
}
