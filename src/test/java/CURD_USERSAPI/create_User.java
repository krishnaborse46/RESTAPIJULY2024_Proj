package CURD_USERSAPI;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class create_User {

	public static void main(String[] args) 
	{
		//Creating a Request using Post 
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		String reqBody="{\r\n"
				+ "    \"id\": 11,\r\n"
				+ "    \"name\": \"Leanne Graham\",\r\n"
				+ "    \"username\": \"Bret\",\r\n"
				+ "    \"email\": \"Sincere@april.biz\",\r\n"
				+ "    \"address\": {\r\n"
				+ "      \"street\": \"Kulas Light\",\r\n"
				+ "      \"suite\": \"Apt. 556\",\r\n"
				+ "      \"city\": \"Gwenborough\",\r\n"
				+ "      \"zipcode\": \"92998-3874\",\r\n"
				+ "      \"geo\": {\r\n"
				+ "        \"lat\": \"-37.3159\",\r\n"
				+ "        \"lng\": \"81.1496\"\r\n"
				+ "      }\r\n"
				+ "}\r\n"
				+ "}";
		
		given().header("Content-Type","application/json").body(reqBody).
		//contentType("Content-Type","application/json").body().
		when().log().all().post("/users").
		then().log().all().assertThat().statusCode(201).body("id",is(11));
		

	}

}
