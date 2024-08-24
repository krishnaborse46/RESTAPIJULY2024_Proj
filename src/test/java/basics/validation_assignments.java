package basics;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.*;

import org.hamcrest.collection.HasItemInArray;

public class validation_assignments 
{
	public static void main(String[] args) {
 /*
  * //challanges using query param:
	/*	
		1.for post id 23: validate that userid is 3 and id=23
		2 check record count when tryiing to fetch post using query pparam//check size()
		3 fetch all thee post for user id 1 and chek number of records having Id  hint id hasSize()
		4 fetch all the post for user and validate id 1 2 9 10 and reord count 10  //hasitems-used for multiple values
		5 fetch all posts and validte record count feq id 1 52 99 100
		few userIds 1,2,9,10 and one title 
		*/
  
	RestAssured.baseURI="https://jsonplaceholder.typicode.com";
	
	//1.for post id 23: validate that userid is 3 and id=23
	//O/P- 
	/*
	[
	    {
	        "userId": 3,
	        "id": 23,
	        "title": "maxime id vitae nihil numquam",
	        "body": "veritatis unde neque eligendi\nquae quod architecto quo neque vitae\nest illo sit tempora doloremque fugit quod\net et vel beatae sequi ullam sed tenetur perspiciatis"
	    }
	]

	given().param("id", 23).
	when().log().all().get("posts").//posts?id=23
	then().log().all().assertThat().statusCode(200).body("userId",hasItem(3)).assertThat().statusCode(200).body("id",hasItem(23));
	then().log().all().assertThat().statusCode(200).body("userId",hasItem(3)).and().body("id",hasItem(23)); //second way use
		*/
	
	//check record count when trying to fetch posts using query param (?id=2)
	given().param("id", 2).
	when().log().all().get("posts").//post?id=2
	//then().log().all().assertThat().statusCode(200).body("size()",is(1));
	
	then().log().all().assertThat().statusCode(200).body("size",is(1)); //what size() or size  
	
	//3. fetch all the posts for userId 1 and check number of records having id 

//	(hint: hasSize())
	given().param("userId", 1).
	when().log().all().get("posts").
	then().log().all().assertThat().statusCode(200).and().body("id",hasSize(10));
	
	//4. fetch all posts for userId 1 and validate id 1, 2, 9, 10 and record count 10

	given().param("userId", 1).
	when().log().all().get("posts").
	then().log().all().assertThat().statusCode(200).and().body("size()",is(10)).and().body("id",hasItems(1,2,9,10));
	//5fetch all posts and validate record count, few ids 1, 52, 99, 100 few userIds 1, 2, 9, 10 and any one title and check title also
	
	given().
	when().log().all().get("posts").
	then().log().all().assertThat().statusCode(200).
	and().body("size()",is(100)).
	and().body("id",hasItems(1,52,99,100)).
	and().body("userId",hasItems(1,2,9,10)).
	//and().body("title",containsString("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
	and().body("title",hasItem("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
	
}
}
