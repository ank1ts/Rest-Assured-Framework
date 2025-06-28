package httpPost;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class path_query_param {

	@Test(priority=1)
	public void test_path_query_param() {
		
		//https://reqres.in/api/users?page=2&id=5
		given()
			.pathParam("mypath", "users")
			.queryParam("page", 2)
			.queryParam("id", 5)
		    .header("x-api-key", "reqres-free-v1")
	
		
		.when()
			.get("https://reqres.in/api/{mypath}")	
			
		.then()
			.statusCode(200)
			.log().all();
		
	}
}
