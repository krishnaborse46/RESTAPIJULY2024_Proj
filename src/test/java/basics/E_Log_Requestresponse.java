package basics;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class E_Log_Requestresponse {

	public static void main(String[] args) {

		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		given().  //query parameter 
		when().get("posts?id=1").  //
		then().log().all().statusCode(200); 
		
		given().param("id",1) . //using param query parameter 
		when().get("posts").  //
		then().log().all().statusCode(200); //log only responsed 
		
		
		//Log repsonse and request 
				given().  //path parameter 
				when().log().all().get("posts/1").
				then().log().all().statusCode(200);
				
				given().  //path parameter 
				when().log().all().get("posts/1").
				then().log().all().statusCode(200);//try hhtps staus cde sc.
				
				
				//query pparam challange 
				
				
				//1.fetch all post for user id=1
				given().param("userid",1) . //using param query parameter 
				when().get("posts").  //id=1 is imp we missed it 
				then().log().all().statusCode(200);
				
			
				//2.fetch all posts for check 1 (invaliid key query parameter )
				given().param("KRI",1). //using param query parameter 
				when().get("posts").  //id=1 is imp we missed it 
				then().log().all().statusCode(200);//check securti it should giv 404
				
				
				//3 non existing id eg 102: 200 with empty array
				
				given().param("userid",102) . //using param query parameter 
				when().get("posts").  //id=1 is imp we missed it 
				then().log().all().statusCode(200);
				
				//4 invalid resouce name post: 404 not found 
		
	}

}

