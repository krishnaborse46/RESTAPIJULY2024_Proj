package adv.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostRequest {
	
	//Used POJO genrat form json
	
	/*{ 
		  "userid":1,
		  "title":"foo",
			"body":"XYS"
		}*/
	
	// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
	// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
	/* ObjectMapper om = new ObjectMapper();
	Root root = om.readValue(myJsonString, Root.class); */
	
		 @JsonProperty("userid") 
		 int userid;
		 
		    @JsonProperty("title") 
		    String title;

		    @JsonProperty("body") 
		    String body;

		 
	    public PostRequest(int i, String string, String string2) 
	    {
				this.userid=i;
				this.title=string;
				this.body=string2;
			}
		@JsonProperty("userid") 
	    public int getUserid() 
	    { 
			 return this.userid; 
			 } 
	    public void setUserid(int userid) 
	    { 
			 this.userid = userid; 
			 } 
	    
	    @JsonProperty("title") 
	    public String getTitle() 
	    { 
			 return this.title; 
			 } 
	    public void setTitle(String title) 
	    { 
			 this.title = title; 
			 } 
	    @JsonProperty("body") 
	    public String getBody() 
	    { 
			 return this.body; 
			 } 
	    
	    public void setBody(String body) 
	    { 
			 this.body = body;
			 } 
	    
	}




