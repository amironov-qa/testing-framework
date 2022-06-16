package stepdefs;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Driver;

public class Hooks {

    private static final Logger logger = Logger.getLogger(Hooks.class);

    @BeforeAll
    public static void beforeAll() {
        logger.info("TESTING STARTED");
    }

    @AfterAll
    public static void afterAll() {
        logger.info("TESTING ENDED");
        Driver.quit();
    }
}
