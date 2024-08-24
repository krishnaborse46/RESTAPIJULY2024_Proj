package basics;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class D_basics_delete {

	public static void main(String[] args) {

		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		given().  //pre requested can be mentioned 
	
		//when().get("posts/1").  //get id=1
		//when().get("posts/12").  //get =12 
		//when().get("posts").  //all id 
		
		//when().get("posts/101"). //id 101
		
		//when().delete("posts/12").//deleted post id 12 
		//then().log().all().assertThat().statusCode(200) ;//delete 12 id 
		
		//6 delt 101 with status code 200
		
		when().delete("posts/101").//deleted post id 12 
		then().log().all().assertThat().statusCode(404) ;//delete 12 id 
		
		//7 ele with post id 12 404 invalid 
		when().delete("posts/12").//deleted post id 12 
		then().log().all().assertThat().statusCode(404) ;//delete 12 id 
		//then().log().all().assertThat().statusCode(200) ;   //validations and assettions 
		//then().log().all().assertThat().statusCode(201) ;   //validations and assettions 
		
		// to use query paramenter in rest 
	}

}

