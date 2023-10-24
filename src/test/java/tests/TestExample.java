package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestExample {
	static int STATUS_OK= 200;
	static int STATUS_NOT_OK= -1;

	@Test
	public void test_1() {
		Response res =get("https://reqres.in/api/users?page=2");
		System.out.println(res.getStatusCode());
		//System.out.println(res.getBody().asString());
		System.out.println(res.getTime());
		
		Assert.assertEquals(res.getStatusCode(),STATUS_OK);
	}
	
	@Test
	public void test_2() {
		baseURI ="https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(STATUS_OK)
		.body("data[1].id",equalTo(8)).log().all();
	}
}
