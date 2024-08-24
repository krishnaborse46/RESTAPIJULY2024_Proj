package basics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

public class Creating_put {

	public static void main(String[] args) {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		//json in string format 
		String reqBody="{\r\n"
				+ "    \"title\": \"foo1\",\r\n"
				+ "    \"body\": \"bar\",\r\n"
				+ "    \"userId\": 1\r\n"
				+ "}";
		given().header("Content-type","application/json").body(reqBody).
		when().log().all().put("/posts/25").
		then().log().all().assertThat().statusCode(200).body("id", is(25));

	}

}
