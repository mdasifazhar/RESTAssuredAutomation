package api.endpoints;

import static io.restassured.RestAssured.given;

import api.endpoints.base.Base;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class OrderEndPoints {
	
	public static Response getUser(String orderId) {
		Response response = given().accept(ContentType.JSON).pathParam("orderId", orderId).when()
				.get(Base.get_order);

		return response;
	}

}
