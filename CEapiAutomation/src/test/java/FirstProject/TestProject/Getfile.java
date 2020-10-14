package FirstProject.TestProject;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Getfile extends Uploadfile {
	@Test
	public void getfile() 
	{
		RestAssured.baseURI = "https://api.cloud-elements.com/elements/api-v2/files";
		RequestSpecification rs = RestAssured.given();

		rs.queryParam("path", filepath);
		rs.header("Authorization", "User g1OvXzyYeEyMYgM+it4uaUukh0UE6W6BQ6u9EOf/4oU=");
		rs.header("Authorization", "Organization bff1b3621582d31794b1b381c8369430");
		rs.header("Authorization", "Element tUUXERmunGJbbZzJUQEXflgVtgBbYzpCf++EiCyKTk4=");

		Response res = rs.request(Method.GET);
		res.prettyPrint();
		int getstatuscode = res.getStatusCode();
		System.out.println("Getfile status code " +getstatuscode);

		Assert.assertEquals(200,getstatuscode);

	}
}
