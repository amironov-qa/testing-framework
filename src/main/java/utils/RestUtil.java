package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestUtil {

    static {
        RestAssured.baseURI = "http://localhost/";
        RestAssured.port = 3000;
    }

    public static Response getAllProducts() {
        return given()
                .log()
                .all()
                .get("/products")
                .then()
                .log()
                .body()
                .extract().response();
    }

    public static Response getProductById(String id) {
        return given()
                .log()
                .all()
                .get(String.format("/products/%s", id))
                .then()
                .log()
                .body()
                .extract().response();
    }

    public static Response saveProduct(String body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .log()
                .all()
                .post("/products")
                .then()
                .log()
                .body()
                .extract().response();
    }

    public static Response updateProduct(String body, String id) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .log()
                .all()
                .put(String.format("/products/%s", id))
                .then()
                .log()
                .body()
                .extract().response();
    }


    public static Response deleteProductById(String id) {
        return given()
                .log()
                .all()
                .delete(String.format("/products/%s", id))
                .then()
                .log()
                .body()
                .extract().response();
    }
}
