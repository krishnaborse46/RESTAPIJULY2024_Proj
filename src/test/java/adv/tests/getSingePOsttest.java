package adv.tests;


import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import adv.models.Post;
import io.restassured.RestAssured;
//import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class getSingePOsttest {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {

		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		Response res=given().
				when().log().all().get("/posts?userId=1").///posts/1").//path paramater
				then().log().all().
				extract().response();
		
		Assert.assertEquals(res.getStatusCode(), 200);
		String exptitle="sunt aut facere repellat provident occaecati excepturi optio reprehenderit";
		
		//deserilized and validate fileds
		
		ObjectMapper mapper= new ObjectMapper(); //import jackson 
		String jsonres=res.asString();
		/*Post postobj=mapper.readValue(jsonres,Post.class);


	Assert.assertEquals(postobj.getId(), 1);
Assert.assertEquals(postobj.getUserId(), 1);
Assert.assertEquals(postobj.getTitle(),exptitle);
System.out.println(jsonres);*/
	
		
Post[] postobj=mapper.readValue(jsonres,Post[].class);
Assert.assertEquals(postobj[0].getId(), 1);
Assert.assertEquals(postobj[0].getUserId(), 1);
Assert.assertEquals(postobj[0].getTitle(),exptitle);

	
	System.out.println(postobj[0].getId());
	
	
	
	}

}
