package httpPost;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test; 

@Test(priority=1)
public class postMethod {
	
	public void getusers() {
		
		given()
			.header("x-api-key", "reqres-free-v1")
		   
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();
	}
	
//===============================HASHMAP=============================================	
	@Test(priority=2)
	public void createNewUser_hashmap() {
		
		
		//CREATE PAYLOAD in key:value pair
		HashMap data = new HashMap();
		data.put("name", "Ankit");
		data.put("job", "SDET");
		
		given()
		   .header("x-api-key", "reqres-free-v1")
		   .contentType("application/json")
		   .body(data)
		
		.when()
			.post("https://reqres.in/api/users")	
			
		.then()
			.statusCode(201)
			.body("name",equalTo("Ankit"))
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();	
	}
	
//==================================JSON Object==========================================
	
	@Test(priority=3)
	public void createNewUser_JsonobjLib() {
		
		//CREATE PAYLOAD in key:value pair
		JSONObject data = new JSONObject();
		data.put("name", "Himanshu");
		data.put("job", "QALead");
		
		given()
		   .header("x-api-key", "reqres-free-v1")
		   .contentType("application/json")
		   .body(data.toString())  //convert the data into string format as its a json.
		
		.when()
			.post("https://reqres.in/api/users")	
			
		.then()
			.statusCode(201)
			.body("name",equalTo("Himanshu"))
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();
	}
	
//===================================POJO=========================================
	
	@Test(priority=4)
	public void createNewUser_POJO() {
		
		pojo_DataCreation dataset = new pojo_DataCreation();
		dataset.setName("Scott");
		dataset.setJob("Manager");
		
		given()
		   .header("x-api-key", "reqres-free-v1")
		   .contentType("application/json")
		   .body(dataset)  //convert the data into string format as its a json.
		
		.when()
			.post("https://reqres.in/api/users")	
			
		.then()
			.statusCode(201)
			.body("name",equalTo("Scott"))
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();
	}
	
//================================External File============================================
	
	@Test(priority=4)
	public void createNewUser_ExtJsonFile() throws FileNotFoundException {
		
		File f = new File(".\\body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
		
		
		given()
		   .header("x-api-key", "reqres-free-v1")
		   .contentType("application/json")
		   .body(data.toString())  //convert the data into string format as its a json.
		
		.when()
			.post("https://reqres.in/api/users")	
			
		.then()
			.statusCode(201)
			.body("name",equalTo("morpheus"))
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();
	}
}
