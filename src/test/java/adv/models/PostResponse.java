package adv.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostResponse {
	//private propties 
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("userId")
	private int userId;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("body")
	private String body;

	
	//public getters and setterrs get right click to source -> click generate getter and setters
	@JsonProperty("id")
	public int getId() {
		return id;
	}
	
	@JsonProperty("id")
	public void setId(int id) {
		this.id = id;
	}

	@JsonProperty("userId")
	public int getUserId() {
		return userId;
	}

	@JsonProperty("userId")
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("body")
	public String getBody() {
		return body;
	}

	@JsonProperty("body")
	public void setBody(String body) {
		this.body = body;
	}
	
	
	

	


	
	

}
