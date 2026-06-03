package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
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
	public void startSuite()
	{
	    initializeReport();
	}

	@BeforeClass
	@Parameters("browser")
	public void setUp(String browser)
	{
	    DriverFactory.initializeDriver(browser);

	    driver = DriverManger.getDriver();
	}

	@AfterClass
	public void tearDown()
	{
	    DriverFactory.quitDriver();
	}

	@AfterSuite
	public void endSuite()
	{
	    flushReport();
	}
	
	@Test
	public void verifyUserRegisterationTest()
	{
		
		ExtentTest test = extent.createTest("Verify user registration");
	
		navigateToUrl("https://zayro.io/signup");
		
		waitForElementVisible(By.name("username")).sendKeys("jaishreenaatth");
		
		waitForMilliSeconds(5000);
		
		test.addScreenCaptureFromBase64String(takeScreenshot());
		
		test.pass("Registered successfully");
	}

}
