package api.endpoints;

//url https://petstore.swagger.io/#/user/getUserByName
//get request(get) https://petstore.swagger.io/v2/user/{username}
//update use(put)  https://petstore.swagger.io/v2/user/{username}
//delete user(delete)  https://petstore.swagger.io/v2/user/{username}
public class Routes {

	public Routes() {
	}
	
	public static String baseurl="https://petstore.swagger.io/v2";
	
	//user model
	public static String get_url=baseurl+"/user/{username}";
	public static String post_url=baseurl+"/user";
	public static String update_url=baseurl+"/user/{username}";
	public static String delete_url=baseurl+"/user/{username}";
	
	//store model
       //here we can cretate store model urls
	//we can also add these models inside the Routes.properties file or we can invoke eg.Userendpoint2
}