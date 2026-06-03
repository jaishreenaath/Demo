package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base.Base;
import utilities.DriverFactory;
import utilities.DriverManger;

public class RegisterTest extends Base{
	
	WebDriver driver;
	
	@BeforeSuite
	@Parameters("browser")
	public void setUp(String browser) {
		
		initializeReport();
		
		DriverFactory.initializeDriver(browser);
		
		driver = DriverManger.getDriver();
	}
	
	@AfterSuite
	public void tearDown()
	{
		flushReport();
		
		DriverFactory.quitDriver();
	}
	
	@Test
	public void verifyUserRegisteration()
	{
		
		ExtentTest test = extent.createTest("Verify user registration");
	
		navigateToUrl("https://zayro.io/signup");
		
		waitForElementVisible(By.name("username")).sendKeys("jaishreenaatth");
		
		waitForMilliSeconds(5000);
		
		test.addScreenCaptureFromBase64String(takeScreenshot());
		
		test.pass("Registered successfully");
	}

}
