package basics;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class E_Query_param {

	public static void main(String[] args) {

		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		given().  //query parameter 
		when().get("posts?id=1").  //id=1 is imp we missed it 
		then().log().all().statusCode(200); 
		
		given().param("id",1) . //using param query parameter 
		when().get("posts?id=1").  //id=1 is imp we missed it 
		then().log().all().statusCode(200); 
		
		//Log repsonse and request 
		given().  //path parameter 
		when().log().all().get("posts/1").
		then().log().all().statusCode(200); 
		
	}

}

