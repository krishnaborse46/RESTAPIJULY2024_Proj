package basics;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class B_basics {

	public static void main(String[] args) {

		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		given().  //pre requested can be mentioned 
	
		when().get("posts/1").  //get resouce name post put del
		then().log().all();    //validations and assettions 
		//extact()//extract the respose 
		
		//given then extract are optional
		// when is mandatory 
		
		//sequence is fix given when then 
		
		
	}

}

