package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Userendpoints2;
import api.payload.User;
import io.restassured.response.Response;

public class Usertest3 {
	int userid;
    Faker faker;
	User userpayload;
	Logger logger;
	
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
	
	logger=LogManager.getLogger(this.getClass());
	logger.info("Debugging......................");
	}
	
	@Test(priority=1)
	void testCreateuser() {
		logger.info("creating user...................");
		Response re=Userendpoints2.createUser(userpayload);
		re.then().log().all();
		Assert.assertEquals(re.getStatusCode(), 200);
		//userid=re.jsonPath().getInt("id");
		logger.info("user created...................");
	}
	
	@Test(priority=2)
	void testreaduser() {
		logger.info("reading user...................");
		Response re=Userendpoints2.readUser(this.userpayload.getUsername());
		re.then().log().all();
		Assert.assertEquals(re.getStatusCode(), 200);
	}
	

	@Test(priority=3)
	void testupdateuser() {
		logger.info("updating user...................");
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		Response re=Userendpoints2.updateUser(userpayload,this.userpayload.getUsername());
		re.then().log().all();
		Assert.assertEquals(re.getStatusCode(), 200);
		logger.info("updated user...................");
	}
	
	@Test(priority=4)
	void testdeleteuser() {
		Response re=Userendpoints2.deleteUser(this.userpayload.getUsername());
		re.then().log().all();
		Assert.assertEquals(re.getStatusCode(), 200);
		logger.info("user deleted...................");
	}
}
