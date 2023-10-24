package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {
	Faker faker;
	User payload;
	@BeforeClass
	public void setupData() {
		faker = new Faker();
		payload = new User();
		
		payload.setId(faker.idNumber().hashCode());
		payload.setUsername(faker.name().username());
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());
		payload.setPassword(faker.internet().password(5,10));
		payload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	
	@Test(priority = 1)
	public void testCreateUser() {
		Response res=UserEndPoints.createUser(payload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);	
	}
	
	@Test(priority = 2)
	public void testGetUserByName() {
		Response res=UserEndPoints.getUser(this.payload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void testUpdateUser() {
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());
		payload.setPassword(faker.internet().password(5,10));

		Response res= UserEndPoints.upateUser(this.payload.getUsername(), payload);
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(),200);
		
		Response updatedRes=UserEndPoints.getUser(this.payload.getUsername());
		updatedRes.then().log().all();
		Assert.assertEquals(updatedRes.getStatusCode(), 200);
		
	}
	@Test(priority = 4)
	public void testDeleteUser() {
		Response res=UserEndPoints.deleteUser(this.payload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(),200);
	}

}
