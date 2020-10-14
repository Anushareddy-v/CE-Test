package FirstProject.TestProject;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Uploadfile extends CreateFolder
{
	public String filepath=null;
	@Test
	public void updatefile() 
	{

		RestAssured.baseURI = "https://api.cloud-elements.com/elements/api-v2/files";
		RequestSpecification rs = RestAssured.given();

		rs.header("Authorization", "User g1OvXzyYeEyMYgM+it4uaUukh0UE6W6BQ6u9EOf/4oU=");
		rs.header("Authorization", "Organization bff1b3621582d31794b1b381c8369430");
		rs.header("Authorization", "Element tUUXERmunGJbbZzJUQEXflgVtgBbYzpCf++EiCyKTk4=");
		rs.queryParam("path", "/APIAutomation006/Testfile_API - Copy");
		
		// uploading the file into the folder
		rs.queryParam("folderId", Id);
		File file = new File("C://Users//avemula//Documents//Anusha//Testfile_API - Copy.txt");
		rs.given().multiPart(file).when().post("/APIAutomation006/Testfile_API - Copy");


		Response res = rs.request(Method.POST);
		res.prettyPrint();
		filepath = res.then().extract().path("path");
		int statuscode = res.getStatusCode();
		System.out.println("File upload status code " +statuscode);
		Assert.assertEquals(200, statuscode);
	}

}
