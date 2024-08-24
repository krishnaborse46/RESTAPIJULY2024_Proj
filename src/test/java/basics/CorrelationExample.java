package basics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
//Correlation sharing output of one request as input to others
public class CorrelationExample {

	public static void main(String[] args) {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		Response res=given().
				when().get("posts/92").
				then().statusCode(200).
				extract().response();

		JsonPath jsonObj=res.jsonPath();
		int varuserId=jsonObj.getInt("userId");
		
		
		System.out.println("capture user id "+ varuserId);//getting user is from extact and passing to next request 
	//	--------------------------------
		given().queryParam("userId", varuserId).//varuserId is the input for the this posts
		when().get("posts").
		then().log().all().statusCode(200);
		

	}

}
