package stepdefs;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import utils.Driver;

public class Hooks {
    @BeforeAll
    public static void beforeAll() {
    }
    @AfterAll
    public static void afterAll() {
        Driver.quit();
    }
}
