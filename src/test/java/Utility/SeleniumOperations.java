package Utility;

import java.awt.Desktop.Action;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumOperations 
{
	public static WebDriver driver=null;
	//browser launch
	public static void browserLaunch(Object[] inputparameters)
	{
		String strBrowserName=(String) inputparameters[0];
		String webDriverExePath=(String) inputparameters[1];
		
		if(strBrowserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", webDriverExePath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else
			if(strBrowserName.equalsIgnoreCase("FF"))
			{
				System.setProperty("webdriver.gecko.driver", webDriverExePath);
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			}
	}
	//open app
	public static void openApplication(Object[] inputparameters)
	{
		String strURL=(String) inputparameters[0];
		driver.get(strURL);
	}
	//click method
	public static  void clickOnElement(Object[] inputparameters)
	{
		String element = (String) inputparameters[0];
		driver.findElement(By.xpath(element)).click();
	}
	//move to element
	public static void moveToElement(Object[] inputparameters)
	{
		String element=(String) inputparameters[0];
	    Actions act=new Actions(driver);
		WebElement log=driver.findElement(By.xpath(element));
		act.moveToElement(log).build().perform();
	}
	//send keys
	
		public static void sendKeys(Object[] inputparameters)
		{
			String xpath=(String) inputparameters[0];
			String key=(String) inputparameters[1];
			driver.findElement(By.xpath(xpath)).sendKeys(key);
		}
	

}
