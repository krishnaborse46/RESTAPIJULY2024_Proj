package CURD_USERSAPI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Put_User3 {

	public static void main(String[] args) 
	{
		//Creating a Request using Post 
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		String reqBody="{\r\n"
				+ "    \"id\": 12,\r\n"
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
		
		
//---------------------------------------------------------------------------------------------		
		//import is required 
	    JSONObject data1 = new JSONObject();
	    data1.put("Name", "Krish");
	    data1.put("Rollno", 7);
		//First JSONObject
	    JSONObject data11 = new JSONObject();
	    
	  //QAExperts
	  		RestAssured
	          .given()
	          .contentType(ContentType.JSON)
	          .body(data11.toString())
	          .log().all()

	          .when()
	          .post("https://dummy.restapiexample.com/api/v1/create")

	          .then()
	          .assertThat().statusCode(200).log().all();
	  	//---------------------------------------------------------------------------------------------	
	  		//Complex Request Body or nested Request Body.
	  	//First JSONObject
	  	    JSONObject data = new JSONObject();
	  	 
	  	    data.put("profile_image", "test.png");
	  	         
	  	    //Second JSONObject
	  	    JSONObject detail = new JSONObject();
	  	 
	  	    detail.put("updated_message", "Details of New Resource");
	  	    detail.put("employee_age", "30");
	  	 
	  	    data.put("employee_details", detail); //adding detilas into emp 
	  	 
	  	    data.put("employee_name", "MapTest");
	  	    data.put("employee_salary", "11111");
	  	     
	  	    RestAssured
	  	        .given()
	  	               .contentType(ContentType.JSON)
	  	               .body(data.toString())
	  	               .log().all()
	  	                 
	  	        .when()
	  	              .post("http://dummy.restapiexample.com/api/v1/create")
	  	                 
	  	        .then()
	  	               .assertThat().statusCode(200)
	  	               .body("data.employee_name", equalTo("MapTest"))
	  	               .body("data.employee_details.employee_age", equalTo("30"))
	  	               .body("data.employee_details.updated_message", equalTo("Details of New Resource"))
	  	               .body("data.employee_salary", equalTo("11111")).body("data.profile_image", equalTo("test.png"))
	  	                .body("message", equalTo("Successfully! Record has been added."))
	  	                .log().all();
	  		
	 
	   

	}

}
