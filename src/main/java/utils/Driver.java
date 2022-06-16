package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.PropertyManager.getProperty;

public class Driver {

    public static ChromeDriver driver;
    public static WebDriverWait wait = null;
    private static final Logger logger = Logger.getLogger(Driver.class);

    public static ChromeDriver getInstance() {
        System.setProperty("webdriver.chrome.driver", getProperty("selenium.driver.path"));
        if (driver == null) {
            driver = new ChromeDriver();
            logger.info("Driver is initialized...");

            //Perform Basic Operations
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(15L));
        }
        return driver;
    }

    public static void quit() {
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null; // we destroy the driver object after quit operation
        }
    }
}
