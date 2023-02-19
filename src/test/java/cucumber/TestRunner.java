package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        stepNotifications = true, //we can see status of each step
        monochrome = true, //makes console output much more readable
        features = "src/test/resources/feature",
        glue = "stepdefs",
        tags = "@ui",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/html/Report.html",
                "json:target/cucumber-reports/json/Report.json",
                "junit:target/cucumber-reports/xml/Report.xml"
        }
)
public class TestRunner {
}