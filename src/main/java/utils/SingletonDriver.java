package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static io.github.bonigarcia.wdm.WebDriverManager.*;
import static utils.PropertyManager.getProperty;

public class SingletonDriver {
    private static SingletonDriver instanceSingletonDriver = null;
    private WebDriver webDriver;

    private SingletonDriver() {
        String browser = getProperty("browser.ver");
        switch (browser.toLowerCase()) {
            case "firefox" -> {
                firefoxdriver().setup();
                webDriver = new FirefoxDriver();
            }
            case "edge" -> {
                edgedriver().setup();
                webDriver = new EdgeDriver();
            }
            case "chrome" -> {
                chromedriver().setup();
                webDriver = new ChromeDriver();
            }
            default -> System.out.println("Driver is not supported");  //todo: logger will be used
        }
    }

    public static SingletonDriver getSingletonDriverInstance() {
        if (instanceSingletonDriver == null) {
            instanceSingletonDriver = new SingletonDriver();
            instanceSingletonDriver.getWebDriver().manage().deleteAllCookies();
            instanceSingletonDriver.getWebDriver().manage().window().maximize();
            instanceSingletonDriver.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return instanceSingletonDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public static void quitDriver() {
        if (instanceSingletonDriver != null) {
            instanceSingletonDriver.getWebDriver().close();
            instanceSingletonDriver.getWebDriver().quit();
            instanceSingletonDriver = null; // we destroy the driver object after quit operation
        }
    }
}