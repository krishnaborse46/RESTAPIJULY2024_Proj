package tenug;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;


public class Read_User {

	public static void main(String[] args) 
	{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
				//1.get all Users 
				Response res=given().
				when().log().all().get("/post?id=1").//path paramater
				then().log().all().assertThat().statusCode(200).extract().response();
				
				
						
						JsonPath jsonObj=res.jsonPath();
						List<Integer> ids=jsonObj.getList("userId");
						List<String> title=jsonObj.getList("title");
						
						System.out.println(ids.get(0)+title.get(0));
						
						
	}
}
