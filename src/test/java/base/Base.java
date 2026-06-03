package base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.DriverManger;

public class Base {
	
	public static ExtentSparkReporter spark;
	
	public static ExtentReports extent;
	
	public static void initializeReport()
	{
		spark = new ExtentSparkReporter("./Reports/Basic.html");
		
		extent = new ExtentReports();
		
		extent.attachReporter(spark);
		
		extent.setSystemInfo("Project Name", "Demo");
		
		extent.setSystemInfo("Tester", "Jaishreenaatth");
	}
	
	public static void flushReport()
	{
		extent.flush();
	}
	
	public static void navigateToUrl(String url)
	{
		DriverManger.getDriver().get(url);
	}
	
	public static void waitForMilliSeconds(int milliseconds)
	{
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
	public static WebElement getElementById(String id)
	{
		return DriverManger.getDriver().findElement(By.id(id));
	}
	
	public static WebElement getElementByName(String name)
	{
		return DriverManger.getDriver().findElement(By.name(name));
	}
	
	public static WebElement getElementByXpath(String xpath)
	{
		return DriverManger.getDriver().findElement(By.xpath(xpath));
	}
	
	public static void clickElement(WebElement ele)
	{
		ele.click();
	}
	
	public static String takeScreenshot()
	{
		TakesScreenshot tk = (TakesScreenshot)DriverManger.getDriver();
		
		return tk.getScreenshotAs(OutputType.BASE64);
	}
	
	public static void switchToWindow(int index)
	{
		Set<String> alltabs = DriverManger.getDriver().getWindowHandles();
		
		List<String> li = new ArrayList<String>(alltabs);
		
		DriverManger.getDriver().switchTo().window(li.get(index));
	}
	
	public static WebElement waitForElementVisible(By locator)
	{
		WebDriverWait wait = new WebDriverWait(DriverManger.getDriver(), Duration.ofSeconds(10));
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static WebElement waitForElementClickable(By locator)
	{
		WebDriverWait wait = new WebDriverWait(DriverManger.getDriver(), Duration.ofSeconds(10));
		
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static String getPageTitle() {
		
		return DriverManger.getDriver().getTitle();
		
	}
	
	public static String getCurrentUrl()
	{
	    return DriverManger.getDriver().getCurrentUrl();
	}
}
