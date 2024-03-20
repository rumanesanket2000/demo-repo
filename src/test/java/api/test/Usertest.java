package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Userendpoints;
import api.payload.User;
import io.restassured.response.Response;

public class Usertest {
	int userid;
    Faker faker;
	User userpayload;
	
	@BeforeClass
	public void setUpdata() {
		
	faker=new Faker();
	userpayload=new User();
	
	userpayload.setId(faker.idNumber().hashCode());
	userpayload.setUsername(faker.name().username());
	userpayload.setFirstName(faker.name().firstName());
	userpayload.setLastName(faker.name().lastName());
	userpayload.setEmail(faker.internet().safeEmailAddress());
	userpayload.setPassword(faker.internet().password(5,10));
	userpayload.setPhone(faker.phoneNumber().cellPhone());
	userpayload.setUserStatus(1);
	
	}
	
	@Test(priority=1)
	void testCreateuser() {
		Response re=Userendpoints.createUser(userpayload);
		re.then().log().all();
		Assert.assertEquals(re.getStatusCode(), 200);
		//userid=re.jsonPath().getInt("id");
	}
	
	@Test(priority=2)
	void testreaduser() {
		Response re=Userendpoints.readUser(this.userpayload.getUsername());
		re.then().log().all();
		Assert.assertEquals(re.getStatusCode(), 200);
	}
	

	@Test(priority=3)
	void testupdateuser() {
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		Response re=Userendpoints.updateUser(userpayload,this.userpayload.getUsername());
		re.then().log().all();
		Assert.assertEquals(re.getStatusCode(), 200);
	}
	
	@Test(priority=4)
	void testdeleteuser() {
		Response re=Userendpoints.deleteUser(this.userpayload.getUsername());
		re.then().log().all();
		Assert.assertEquals(re.getStatusCode(), 200);
	}
}
