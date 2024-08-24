package CURD_USERSAPI;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;


public class Extract_User2 {

	public static void main(String[] args) 
	{
		//Creating a Request using Post 
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
				Response res=given().
				when().log().all().get("/users/1").//path paramater
				then().log().all().assertThat().statusCode(200).body("id",is(1)).extract().response();
				
				JsonPath jsonobj=res.jsonPath();
				
				int id=jsonobj.getInt("id");
				String name=jsonobj.getString("name");
				String address=jsonobj.getString("address");

				System.out.println("Id "+id +"\n name \n address " +id+name +address);
				
							

	}

}
