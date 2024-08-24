package basics;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.Assert;

public class BaiscAuth {

	public static void main(String[] args) {

		//RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		String basicAuthHeader="Basic cG9zdG1hbjpwYXNzd29yZA==";//sendrequest in console will see in Request headers Authorization: Basic cG9zdG1hbjpwYXNzd29yZA==
		String url="https://postman-echo.com/basic-auth";
		
		//refere Authization folder basic auth 2 exaple
		
		Response res=given().
			header("authorization",basicAuthHeader).
		when()
			.get(url).  
		then().
			log().all().statusCode(200).extract().response();
		
		JsonPath jsonobj=res.jsonPath();
		Boolean authenticated=jsonobj.getBoolean("authenticated");//this is response values in output 

		System.out.println(authenticated);
		//authenticated.toString();
		Assert.assertEquals(true, authenticated);
		
	}

}

