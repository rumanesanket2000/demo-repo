package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.Userendpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	User userpayload;

	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testpostuser(String userID, String userName,String fname,String lname,String useremail,String pwd,String ph) {
		
	 userpayload=new User();
	 userpayload.setId(Integer.parseInt(userID));
	 userpayload.setUsername(userName);
	 userpayload.setFirstName(fname);
	 userpayload.setLastName(lname);
	 userpayload.setEmail(useremail);
	 userpayload.setPassword(pwd);
	 userpayload.setPhone(ph);
	
	 
	 Response re=Userendpoints.createUser(userpayload);
		re.then().log().all();
		Assert.assertEquals(re.getStatusCode(), 200);
		
	}
	
	
//	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
//	public void deleteuser(String userName) {
//		Response re=Userendpoints.deleteUser(userName);
//		re.then().log().all();
//		Assert.assertEquals(re.getStatusCode(), 200);
//	}
	
	@Test(priority=2,dataProvider="UserId",dataProviderClass=DataProviders.class)
	public void deleteuser(String userName) {
		Response re=Userendpoints.deleteUser(userName);
		re.then().log().all();
		Assert.assertEquals(re.getStatusCode(), 200);
	}
}
