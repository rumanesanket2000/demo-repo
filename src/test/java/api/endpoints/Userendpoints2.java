package api.endpoints;
import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Userendpoints2 {

  // here we have to add implementations for create, read , update , delete endpoint
    
	//method getUrl created for getting urls from properties file
	static ResourceBundle getUrl(){
		ResourceBundle routes=ResourceBundle.getBundle("routes");  //load the properties file
		return routes;
	}
	
	
	public static Response createUser(User payload)
	{
		Response re=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(getUrl().getString("post_url"));
		
		return re;
	}
	
	public static Response readUser(String userName)
	{
		Response re=given()
				.pathParam("username", userName)
		.when()
		.get(getUrl().getString("get_url"));
		
		return re;
	}
	
	public static Response updateUser(User payload,String userName)
	{
		Response re=given()
		.pathParam("username", userName)
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.put(getUrl().getString("update_url"));
		
		return re;
	}
	
	public static Response deleteUser(String userName)
	{
		Response re=given()
				.pathParam("username", userName)
		.when()
		.delete(getUrl().getString("delete_url"));
		
		return re;
	}
}
