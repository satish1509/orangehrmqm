package com.qa.driverfactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	public static ThreadLocal<WebDriver> tdriver=
			new ThreadLocal<>(); //
	
	   //threads 
	   //threads -- flow of execution 
	
// tdriver== varaible  stpes defintioin 
	
	//synchronized 
	public WebDriver init_driver(String driver)
	{
		if(driver.equals("chrome"))
		{ 
			tdriver.set(new ChromeDriver());
		}
		else if(driver.equals("firefox"))
		{
			tdriver.set(new FirefoxDriver());
		}
		else
		{
			System.out.println("Browser not found");
		}
		
	getDriver().manage().deleteAllCookies();
	getDriver().manage().window().maximize();
	getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return getDriver();
	}
	
	public static synchronized WebDriver getDriver()
	{
		return tdriver.get();
	}

}
