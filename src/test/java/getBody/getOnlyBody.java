package getBody;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class getOnlyBody {
	
	@Test
	public void getBody_Info() {
		
		given()
			.header("x-api-key", "reqres-free-v1")
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
		.log().body();
		//log().body() will provide only body
		//log().all() will provide all headers and body
		//log().cookies() will provide all cookies
		//log().headers() will provide all headers
		
	}


}
