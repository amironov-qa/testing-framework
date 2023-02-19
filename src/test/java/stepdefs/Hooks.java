package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static utils.SingletonDriver.quitDriver;

public class Hooks {
    @Before
    public static void beforeAll() {
    }
    @After("@ui")
    public static void afterAll() {
        quitDriver();
    }
}