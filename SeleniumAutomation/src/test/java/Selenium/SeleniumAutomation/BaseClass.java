package Selenium.SeleniumAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	static WebDriver driver;
	@BeforeMethod
	public void launchbrowser() 
	{
		System.setProperty("webdriver.chrome.driver","C://Users//avemula//Documents//Selenium//chromedriver_win32//chromedriver.exe");
		//WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}
	@AfterMethod
	public void closebrowser() 
	{
		driver.quit();
		
	}

}
