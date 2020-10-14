package FirstProject.TestProject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class DeleteFile extends Uploadfile{
	@Test
	public void deletefile() 
	{
		RestAssured.baseURI = "https://api.cloud-elements.com/elements/api-v2/files";
		RequestSpecification rs = RestAssured.given();


		rs.queryParam("path", filepath);
		rs.header("Authorization", "User g1OvXzyYeEyMYgM+it4uaUukh0UE6W6BQ6u9EOf/4oU=");
		rs.header("Authorization", "Organization bff1b3621582d31794b1b381c8369430");
		rs.header("Authorization", "Element D7CJKhwF4iEZX9Oe6lP5m6737+mbIsYqEql6g6rutrU=");

		

		Response res = rs.request(Method.DELETE);
		String reqsponsebody = res.getBody().asString();
		System.out.println(reqsponsebody);

		int code = res.getStatusCode();
		System.out.println(code);

		Assert.assertEquals(code, 200);
	}
}
