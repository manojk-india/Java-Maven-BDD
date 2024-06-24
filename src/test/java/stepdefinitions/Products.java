package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.*;

public class Products {
    private Response response;
    private RequestSpecification httpRequest;

    @Given("I have the base URL of the API")
    public void i_have_the_base_url_of_the_api() {
        /*RestAssured.baseURI = System.getenv("FLASK_API_URL");
        if (RestAssured.baseURI == null) {
            throw new IllegalStateException("FLASK_API_URL environment variable not set");
        }*/
        RestAssured.baseURI="http://host.docker.internal:5000";
    }

    @When("I send a POST request to the {string} endpoint with the body {string}")
    public void i_send_a_post_request_to_the_items_endpoint_with_the_body(String endpoint, String body) {
        httpRequest = RestAssured.given();
        httpRequest.body(body);
        response = httpRequest.post(endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }
}
