package utilities;

import org.openqa.selenium.WebDriver;

public class DriverManger {
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	public static void setDriver(WebDriver driver)
	{
		tldriver.set(driver);
		
	}
	
	public static WebDriver getDriver()
	{
		return tldriver.get();
	}
	
	public static void removeDriver()
	{
		tldriver.remove();
	}
	
}
