package adv.tests;

import static io.restassured.RestAssured.given;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import static org.hamcrest.Matchers.*;


import adv.models.PostRequest;
import io.restassured.RestAssured;

public class CreateNewPostTest {

	public static void main(String[] args) throws JsonProcessingException 
	{
		
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		PostRequest postrequest=new PostRequest(1,"foo","bar");//consstructor the value to the PostRequest class 
		
		JsonMapper objmapper=new JsonMapper();
		
		String reqBody="";
		
		//seriliza pojo to string
		
		reqBody=objmapper.writeValueAsString(postrequest);
		
		
		given().header("Content-type","application/json; charset=UTF-8").body(reqBody).
		when().log().all().post("posts").
		then().log().all().assertThat().statusCode(201).body("id",is(101));
		
		

	}

}
