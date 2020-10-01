package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinition extends Utils {

	RequestSpecification res;
	ResponseSpecification resSpec;
	Response response;
	TestDataBuild data = new TestDataBuild();

	@Given("^Add Place Payload$")
	public void add_Place_Payload() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		

		resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		res = given().spec(requestSpecification()).body(data.addPlacePayLoad());
	}

	@When("^user calls \"([^\"]*)\" with POST http request$")
	public void user_calls_with_POST_http_request(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		response = res.when().post("/maps/api/place/add/json").then().assertThat().spec(resSpec).extract().response();
	}

	@Then("^the API call got success with status code (\\d+)$")
	public void the_API_call_got_success_with_status_code(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(response.statusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
		// Write code here that turns the phrase above into concrete actions
		String resp = response.asString();
		System.out.println(resp);
		JsonPath js = new JsonPath(resp);
		assertEquals(js.get(keyValue).toString(), expectedValue);
	}

}
