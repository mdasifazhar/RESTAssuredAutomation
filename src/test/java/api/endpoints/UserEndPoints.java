package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/*
 * This is used for CRUD operation
 */
public class UserEndPoints {

	public static Response createUser(User payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(Routes.create_user);

		return response;
	}

	public static Response getUser(String userName) {
		Response response = given().accept(ContentType.JSON).pathParam("username", userName).when()
				.get(Routes.get_user);

		return response;
	}

	public static Response upateUser(String userName, User payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", userName).body(payload).when().put(Routes.update_user);

		return response;
	}

	public static Response deleteUser(String userName) {
		Response response = given().accept(ContentType.JSON).pathParam("username", userName).when()
				.get(Routes.delete_user);

		return response;
	}

}
