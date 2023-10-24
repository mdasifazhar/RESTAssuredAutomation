package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteExample {

	@Test
	public void testPut() {

		JSONObject jsonReq = new JSONObject();
		jsonReq.put("name", "Tanwir");
		jsonReq.put("job", "PLM Consultant");
		System.out.println(jsonReq.toJSONString());
		baseURI = "https://reqres.in/api";
		given().header("ContentType", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(jsonReq.toJSONString()).when().put("/users/2").then().statusCode(200).log().all();
	}

	@Test
	public void testPatch() {

		JSONObject jsonReq = new JSONObject();
		jsonReq.put("name", "Tanwir Fatima");
		System.out.println(jsonReq.toJSONString());
		baseURI = "https://reqres.in/api";
		given().header("ContentType", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(jsonReq.toJSONString()).when().put("/users/2").then().statusCode(200).log().all();
	}
	
	@Test
	public void testDelete() {
		baseURI = "https://reqres.in/api";
		when().delete("/users/2").then().statusCode(204).log().all();
	}
}
