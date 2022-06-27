package stepdefs;

import cucumber.ScenarioContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static enums.Data.STATUS_CODE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static utils.RestUtil.*;

public class RestAssuredStepDefs {
    ScenarioContext scenarioContext = new ScenarioContext();

    @When("get all products request is sent")
    public void getAllProductsRequestIsSent() {
        Response response = getAllProducts();
        scenarioContext.saveData(STATUS_CODE, response.getStatusCode());
    }

    @Then("^status code is (.*)$")
    public void statusCodeIs(int expectedStatusCode) {
        int actualStatusCode = (int) scenarioContext.getData(STATUS_CODE);
        assertThat(actualStatusCode, is(expectedStatusCode));
    }

    @When("get product by id request is sent")
    public void getProductByIdRequestIsSent(String id) {
        Response response = getProductById(id);
        scenarioContext.saveData(STATUS_CODE, response.getStatusCode());
    }

    @When("create new product request is sent")
    public void createNewProductRequestIsSent() {
        String body = """
                {
                 "title": "Iphone 13 Pro",
                 "price": 4000
                }
                """;
        Response response = saveProduct(body);
        scenarioContext.saveData(STATUS_CODE, response.getStatusCode());
    }

    @When("product by id is updated")
    public void productByIdIsUpdated(String id) {
        String body = """
                {
                 "price": 3999
                }
                """;
        Response response = updateProduct(body, id);
        scenarioContext.saveData(STATUS_CODE, response.getStatusCode());
    }

    @When("product by id is deleted")
    public void productByIdIsDeleted(String id) {
        Response response = deleteProductById(id);
        scenarioContext.saveData(STATUS_CODE, response.getStatusCode());
    }
}
