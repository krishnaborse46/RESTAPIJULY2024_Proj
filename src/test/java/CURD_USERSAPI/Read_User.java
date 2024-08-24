package CURD_USERSAPI;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Read_User {

	public static void main(String[] args) 
	{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
				//1.get all Users 
				given().
				when().log().all().get("/users/1").//path paramater
				then().log().all().assertThat().statusCode(200).body("id",is(1));
				
				//2. get user id 4 having phone no 493-170-9623 x156
				String phone="493-170-9623 x156";
				//Response res=given().queryParam("id", 4).
						Response res=given().queryParam("phone", phone).

						//Response res=given().param("id",4).//using parram 
						when().log().all().get("/users").
						then().log().all().assertThat().statusCode(200).body("phone",hasItem(phone)).extract().response();
						
						JsonPath jsonObj=res.jsonPath();
						int id=jsonObj.getInt("id");
						String uname=jsonObj.getString("username");
						
						
				// 3   "website": "ramiro.info" and id=3
						given().
						when().log().all().get("/users?id=3").// using query param in URL
						then().log().all().assertThat().statusCode(200).body("website",hasItem("ramiro.info")).
						and().body("id",hasItem(3));//check for id=3
						//then().log().all().assertThat().statusCode(200).body("website",containsString("ramiro.info"));//is not working 
	}
}
