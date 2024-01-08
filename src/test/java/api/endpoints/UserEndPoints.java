package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints extends Routes{

	public static Response createUser(User payload) {
		
		Response res= given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(payload).
		when().
			post(post_url);
		
		return res;
	}
	
	public static Response readUser(String userName) {
		
		Response res= given().
			pathParam("username", userName).
		when().
			get(get_url);
		
		return res;
	}
	
	public static Response updateUser(User payload, String userName) {
		
		Response res= given().
			pathParam("username", userName).
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(payload).
		when().
			put(update_url);
		
		return res;
	}
	
	public static Response deleteUser(String userName) {
		
		Response res= given().
			pathParam("username", userName).
		when().
			delete(get_url);
		
		return res;
	}	
}