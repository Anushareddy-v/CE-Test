package FirstProject.TestProject;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class CreateFolder {
	public String Id=null;     //passing folder ID as Null to call this value in another Class
	@Test
	public void createfolder() 
	{
		// Passing the Endpoint
		RestAssured.baseURI = "https://api.cloud-elements.com/elements/api-v2/folders";
		RequestSpecification rs = RestAssured.given();
		
		//Passing the payload
		JSONObject obj = new JSONObject();
		obj.put("path", "/APIAutomation008");

		//Authorization & headers
		rs.header("Content-Type","application/json"); 
		rs.header("Authorization", "User g1OvXzyYeEyMYgM+it4uaUukh0UE6W6BQ6u9EOf/4oU=");
		rs.header("Authorization", "Organization bff1b3621582d31794b1b381c8369430");
		rs.header("Authorization", "Element tUUXERmunGJbbZzJUQEXflgVtgBbYzpCf++EiCyKTk4=");
		
		//Passing payload as Json and Request Json specification
		rs.body(obj.toJSONString());
		Response res = rs.request(Method.POST);
		res.prettyPrint();
		
		//extracting folder ID from response
		Id = res.then().extract().path("id");
		int code = res.getStatusCode();
		System.out.println("Create folder status code " +code);
		Assert.assertEquals(200, code);

	}
}
