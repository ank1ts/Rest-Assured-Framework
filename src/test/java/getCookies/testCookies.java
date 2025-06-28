package getCookies;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class testCookies {
	
	@Test
	public void cookies() {
		
		given()
			.header("x-api-key", "reqres-free-v1")
		   
		.when()
			.get("https://www.google.com/")
		
		.then()
			.statusCode(200)
			//.cookie("AEC","AVh_V2gFCKka1CXyQbBJKH0-jpk-BfSaVHCZEq7QohPs_ipc8bUi1t55lA")
			//IF we pass AEC cookie value then this TC will always fail bcoz its a random value
			.cookie("AEC")
			.cookie("NID")
			.log().cookies();
	}
	
	@Test(priority=2)
	public void get_cookies_value() {
		
		Response res = given()
			.header("x-api-key", "reqres-free-v1")
		   
		.when()
			.get("https://www.google.com/");
		
		//store cookie value in a variable and print.
			String variable = res.getCookie("AEC");
			System.out.println(variable);
			
		//if we want to fetch all cookies using res.getcookies method
			Map<String, String> cookies_all = res.getCookies(); 
			
		//Now we have cookies, we need to get values of all cookies
			for(String k : cookies_all.keySet())
					{
					 String var_cookie = res.getCookie(k);
					 System.out.println(k+"  "+var_cookie);
					}			
	}
	
}
