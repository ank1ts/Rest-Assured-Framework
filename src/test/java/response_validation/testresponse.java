package response_validation;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class testresponse {
	
	public void getHeaderValue() {
		
		 Response res = given()
			.header("x-api-key", "reqres-free-v1")
		   
		.when()
			.get("https://www.google.com/");
		 
		 //use res.getHeader method, which will return a string.
		 String Header_Value1 = res.getHeader("Content-Type");
		 System.out.println("Content-Type =="+Header_Value1);
		 
		 String Header_Value2 = res.getHeader("Content-Encoding");
		 System.out.println("Content-Encoding =="+Header_Value2);
	}
	

}
