 package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDUserTest {
	
	@Test(priority=1,dataProvider = "Data",dataProviderClass=DataProviders.class)
	public void ddCreateUser(String userId,String userName,String fName, String lName,String email,String pass,String Phnone ) {
		User payload= new User();
		payload.setId(Integer.parseInt(userId));
		payload.setUsername(userName);
		payload.setFirstName(fName);
		payload.setLastName(lName);
		payload.setEmail(email);
		payload.setPassword(pass);
		payload.setPhone(Phnone);
		
		Response res=UserEndPoints.createUser(payload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(),200);
	}
	
	@Test(priority = 2,dataProvider = "UserNames",dataProviderClass = DataProviders.class)
	public void ddDeleteUser(String userName) {
		Response res= UserEndPoints.deleteUser(userName);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);

	}

}
