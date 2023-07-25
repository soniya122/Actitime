package com.Actitime.GenericLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass 
{
	public WebDriver s;
	@BeforeSuite
	public void dataBaseConnection()
	{
		Reporter.log("Database Connected", true);
	}
	@BeforeClass
	public void launchBrowser()
	{
		s = new ChromeDriver();
		s.manage().window().maximize();
		s.get("https://demo.actitime.com");
		Reporter.log("Browser Launched Successfully", true);
	}
	@BeforeMethod
	public void login()
	{
		s.findElement(By.id("username")).sendKeys("admin");
		s.findElement(By.name("pwd")).sendKeys("manager");
		s.findElement(By.xpath("//div(.='Login ']")).click();
		Reporter.log("Login Done Successfully", true);
	}
	@AfterMethod
	public void logout()
	{
		s.findElement(By.id("logoutLink")).click();
		Reporter.log("Logout Successfully", true);
	}
	@AfterClass
	public void closeBrowser()
	{
		Reporter.log("browser is closed", true);
	}
	@AfterSuite
	public void dataBaseDisconnection()
	{
		Reporter.log("Database Disconnected", true);
	}
}
