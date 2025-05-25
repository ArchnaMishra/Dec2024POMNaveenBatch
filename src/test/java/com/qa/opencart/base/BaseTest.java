package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.SearchResultPage;

public class BaseTest {
	
	DriverFactory df=new DriverFactory();
	public Properties prop;
	
	protected LoginPage loginP;
	protected AccountPage accP;
	protected SearchResultPage searchResultP;
	protected ProductInfoPage productInfoP;
	
	public WebDriver driver;
	
	@Parameters({"browser", "browserversion", "testname"})
	@BeforeTest
	public void setUp(String browserName, String browserVersion, String testname)
	{ 
		prop=df.getProperties();
		if(browserName!=null)
		{
			prop.setProperty("browser", browserName);
			prop.setProperty("browserversion", browserVersion);
			prop.setProperty("testname", testname);
		}
		
		driver= df.initDriver(prop);
		
		
		
		loginP= new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	

}
