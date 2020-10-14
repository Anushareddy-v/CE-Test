package Selenium.SeleniumAutomation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class InvallidinstanceName extends BaseClass {
  @Test
  public void invalidinstancename() throws InterruptedException, IOException 
  {
	//Open application
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
			
			//Go to elements and create instance
			driver.findElement(By.xpath("//*[@id=\"primary-nav-item-/elements\"]")).click();
			Thread.sleep(15000);
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.xpath("//*[@id=\"element-21-hover-card\"]/div/div[1]"));
			action.moveToElement(we).build().perform();

			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"element-21-hover-card\"]/div/div[1]/a")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[2]/div/div[1]/div/div/div/div[4]/button")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"chooser-list-container\"]/div/div[1]/div[2]/div/div/div/input")).click();
			driver.findElement(By.xpath("//*[@id=\"chooser-list-container\"]/div/div[1]/div[2]/div/div/div/input")).sendKeys("Google Drive");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"chooser-list-item-0\"]/div/span")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"provision-name-field\"]")).sendKeys("CE_Test");
			driver.findElement(By.xpath("//*[@id=\"createinstance-button\"]")).click();
			Thread.sleep(2000);
	  if(driver.findElement(By.xpath("//*[@id=\"a11y-status-message\"]")).isDisplayed())
	  {
		  System.out.println("Instance creation is failed");
	  }
	  TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("C://Users//avemula//Documents//Anusha//error.PNG");
		FileUtils.copyFile(SrcFile, DestFile);
  }
}
