package Selenium.SeleniumAutomation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class InvalidAccess extends BaseClass{
  @Test
  public void invalidgit() throws InterruptedException, IOException 
  {
	  driver.get("http://my.cloudelements.io/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"hs-eu-decline-button\"]")));

		driver.findElement(By.xpath("//*[@id=\"hs-eu-decline-button\"]")).click();   //decline cookies
		Thread.sleep(10000);
		
		//Signin with Git
		driver.findElement(By.xpath("//*[text()='Sign in with GitHub']")).click();   
		driver.findElement(By.id("login_field")).sendKeys("anusha2.vemula@gmail.com");
		driver.findElement(By.id("password")).sendKeys("****");
		driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[3]/input[12]")).click();
		Thread.sleep(15000); 
		if(driver.findElement(By.xpath("//*[@id=\"js-flash-container\"]/div/div")).isDisplayed()) 
		{
		System.out.println("negative test is passed");	
		}
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("C://Users//avemula//Documents//Anusha//error.PNG");
		FileUtils.copyFile(SrcFile, DestFile);
  }
}
