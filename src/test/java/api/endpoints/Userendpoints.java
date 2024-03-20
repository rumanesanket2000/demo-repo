package api.endpoints;
import static io.restassured.RestAssured.*;


import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Userendpoints {

  // here we have to add implementations for create, read , update , delete endpoint
    
	public static Response createUser(User payload)
	{
		Response re=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.post_url);
		
		return re;
	}
	
	public static Response readUser(String userName)
	{
		Response re=given()
				.pathParam("username", userName)
		.when()
		.get(Routes.get_url);
		
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
		.put(Routes.update_url);
		
		return re;
	}
	
	public static Response deleteUser(String userName)
	{
		Response re=given()
				.pathParam("username", userName)
		.when()
		.delete(Routes.delete_url);
		
		return re;
	}
}
