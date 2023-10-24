package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAndPostExamples {
	
	@Test
	public void testGet() {
		baseURI ="https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200)
		.body("data.first_name",hasItems("Michael","Lindsay"));
		
	}
	
	@Test
	public void testPost() {
//		Map<String, Object> req= new HashMap<String,Object>();
//		req.put("name", "morpheus");
//		req.put("job", "leader");
//		System.out.println(req);
		JSONObject jsonReq= new JSONObject();
		jsonReq.put("name", "Asif");
		jsonReq.put("job", "developer");
		System.out.println(jsonReq.toJSONString());
		baseURI ="https://reqres.in/api";
		given()
		.header("ContentType","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(jsonReq.toJSONString())
		.when()
		.post("/users")
		.then().statusCode(201).log().all();
	}

}
