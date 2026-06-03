package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	 public static void initializeDriver(String br)
	 {
		 if (DriverManger.getDriver()== null) 
		 {
			 
			 if (br.equalsIgnoreCase("chrome"))
			 {
				 WebDriverManager.chromedriver().setup();
				 
				 ChromeOptions c = new ChromeOptions();
				 
				 c.addArguments("--start-maximized");
				 
				 WebDriver driver = new ChromeDriver(c);
				 
				 DriverManger.setDriver(driver);
				
			 }
			 else if(br.equalsIgnoreCase("firefox"))
			 {
				 WebDriverManager.firefoxdriver().setup();
				 
				 FirefoxOptions f = new FirefoxOptions();
				 
				 f.addArguments("--start-maximized");
				 
				 WebDriver driver = new FirefoxDriver(f);
				 
				 DriverManger.setDriver(driver);
			 }
			 
			DriverManger.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
			DriverManger.getDriver().manage().deleteAllCookies();
		}
	 }
	 
	 public static void quitDriver()
	 {
		 if (DriverManger.getDriver()!=null) 
		 {
			DriverManger.getDriver().quit();
			
			DriverManger.removeDriver();
			
			
		 }
		 
	 }

}
