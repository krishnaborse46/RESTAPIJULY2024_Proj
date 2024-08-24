package basics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

public class CreatingNewpost {

	public static void main(String[] args) {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		//json in string format 
		String reqBody="{\r\n"
				+ "    \"title\": \"foo\",\r\n"
				+ "    \"body\": \"bar\",\r\n"
				+ "    \"userId\": 1\r\n"
				+ "}";
		given().header("Content-type","application/json").body(reqBody).
		when().log().all().post("/posts").
		then().log().all().assertThat().statusCode(201).body("id", is(101));

	}

}
