package basics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Extract {

	public static void main(String[] args) {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
//extracting values form response 		
		Response res=given().//serlized response  to deserilzation is used 
				when().get("posts/1").
				then().log().all().statusCode(200).
				extract().response();

		JsonPath jsonObj=res.jsonPath();//retrun json path objject serized to parser  
		int id=jsonObj.getInt("id");
		int userId=jsonObj.getInt("userId");
		String title=jsonObj.getString("title");
		
		System.out.println(id+userId+title);
		
		System.out.println("Id="+id);
		

	}

}
