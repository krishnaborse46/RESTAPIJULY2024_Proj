package basics;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class H_validation_Examples {

	public static void main(String[] args) {

		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		/*given().  //query parameter 
		when().get("posts?id=1").  //id=1 is imp we missed it 
		then().log().all().statusCode(200); 
		
		
		//fail schnerio
		given().param("id",1) . //using param query parameter 
		when().get("posts").  //id=1 is imp we missed it 
		then().log().all().statusCode(201); 
		
		
		given().  //path parameter 
		when().log().all().get("posts/102").
		then().log().all().statusCode(200);
		*/
//validation Header
		/*given().
		when().get("posts/1").  //id=1 is imp we missed it 
		then().log().all().assertThat().contentType("application/json");
		
//multiple Asserts using and() is optional 	
		given().
		when().get("posts/1").  //id=1 is imp we missed it 
		then().log().all().assertThat().statusCode(200).and().contentType("application/json"); //multo assetion using and 
		//multi assertions without and
		given().
		when().get("posts/1").  //id=1 is imp we missed it 
		then().log().all().assertThat().statusCode(200).contentType("application/json");
		
		*/
		//validate id usiing hamcreast 
		
		when().get("posts/12").   
		then().log().all().assertThat().statusCode(200).body("id",is(12));
		
		//validate userid 
		when().get("posts/12").  
		then().log().all().assertThat().statusCode(200).body("userId",is(2));
		
		//Challange:fetch post with id 2 nd validate title should be ""
		when().get("posts/1").  
		then().log().all().assertThat().statusCode(200).body("title",is("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
		//
		
		///captial 
		String expTitle;
		expTitle="sunt aut facere repellat provident occaecati excepturi optio reprehenderit"; //check this
		String contains="facere",startsWith="sunt",endsWith="reprehenderit";
		when().get("posts/1").  
		then().log().all().//assertThat().statusCode(200).body("title",equalTo(expTitle));
		
		//assertThat().statusCode(200).body("title",equalToIgnoringCase(expTitle));
		//assertThat().statusCode(200).body("title",containsString(contains));
		//assertThat().statusCode(200).body("title",startsWith(startsWith));
		assertThat().statusCode(200).body("title",endsWith(endsWith));
		
		//Fetch record having ID =2 using query param 
		/*given().param("id", 2).
		when().get("posts").
		then().log().all().assertThat().statusCode(200).body("id",hasItem(2)); //is or contains
		*/
		
//challanges using query param:
	/*	
		1.for post id 23: validate that userid is 3 and id=23
		2 check record count when tryiing to fetch post using query pparam//check size()
		3 fetch all thee post for user id 1 and chek number of records having Id  hint id hasSize()
		4 fetch all the post for user and validate id 1 2 9 10 and reord count 10  //hasitems-used for multiple values
		5 fetch all posts and validte record count feq id 1 52 99 100
		few userIds 1,2,9,10 and one title 
		*/
	}

}

