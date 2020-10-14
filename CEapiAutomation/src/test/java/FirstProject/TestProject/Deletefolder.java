package FirstProject.TestProject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Deletefolder extends CreateFolder{
  @Test
  public void deletefolder() 
  {
	    RestAssured.baseURI = "https://api.cloud-elements.com/elements/api-v2/folders";
		RequestSpecification rs = RestAssured.given();


		rs.queryParam("path", Id);
		rs.header("Authorization", "User g1OvXzyYeEyMYgM+it4uaUukh0UE6W6BQ6u9EOf/4oU=");
		rs.header("Authorization", "Organization bff1b3621582d31794b1b381c8369430");
		rs.header("Authorization", "Element D7CJKhwF4iEZX9Oe6lP5m6737+mbIsYqEql6g6rutrU=");

		

		Response res = rs.request(Method.DELETE);
		res.prettyPrint();

		int code = res.getStatusCode();
		System.out.println(code);

		Assert.assertEquals(200, code);
	
  }
}
