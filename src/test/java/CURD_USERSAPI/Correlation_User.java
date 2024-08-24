package CURD_USERSAPI;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;


public class Correlation_User {

	public static void main(String[] args) 
	{
		//Creating a Request using Post 
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
				Response res=given().
				when().log().all().get("/users/5").//path paramater
				then().log().all().assertThat().statusCode(200).body("id",is(5)).extract().response();
				
				JsonPath jsonobj=res.jsonPath();
				
				int id=jsonobj.getInt("id");
				String name=jsonobj.getString("name");
				String address=jsonobj.getString("address");
				String uname=jsonobj.getString("username");
				String emailid=jsonobj.getString("email");
			 //   "email": "Lucio_Hettinger@annie.ca",


				System.out.println("Id "+id +"\n name" +name+ "\n address" +address+ "\n username "   +uname);
				
				//-----------Take the output of prev give and used o/p give username as input to next request using get
				given().param("username", uname).//getting uname for empid=5 as input 
				when().log().all().get("/users").//path paramater
				then().log().all().assertThat().statusCode(200).body("id",hasItem(id)).body("username", hasItem("Kamren"));//is() cannot be used as we are using /users in get
				
				
				
				//-----------Take the output of "email": "Lucio_Hettinger@annie.ca" using DELETE
				
				//del using id 
				
				given().//param("id", id).//getting uname for empid=5 as input 
				when().log().all().delete("/users/" +id).//path paramater
				then().log().all().assertThat().statusCode(200);//.body("id",hasItem(id)).body("username", hasItem("Kamren")).body("email", hasItem(emailid));//is() cannot be used as we are using /users in get
				

				

				
				
				
				
				
				
				
				
				
				

	}

}
