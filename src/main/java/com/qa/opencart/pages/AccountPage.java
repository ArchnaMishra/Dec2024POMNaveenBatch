package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import comp.qa.oopencart.utils.ElementUtil;
import static com.qa.opencart.constants.AppConstants.*;


public class AccountPage {
	
	private WebDriver driver;
	private ElementUtil elUtil;
	
	
	By pageHeader=By.cssSelector("div#content h2");
	By searchInput =By.cssSelector("div#search>input");
	By searchButton = By.cssSelector("div#search button");
	
	
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		elUtil=new ElementUtil(driver);
	}

	// Methods/functions to cover
		public String getAccPageTitle()
		{
			String pageTitle = driver.getTitle();
			System.out.println("Page title is : " + pageTitle);
			return pageTitle;
		}
		
		public String getAccPageUrl()
		{
			String pageUrl = driver.getCurrentUrl();
			System.out.println("Page Current URL : "+ pageUrl);
			return pageUrl;
		}
		
		public List<String> getPageHeaders()
		{
			List<WebElement> pageHeaders= elUtil.waitForVisibilityOfAllElementsLocatedBy(pageHeader, 5);
			List<String> headerElements=new ArrayList<String>();
			String eleValue;
			
			for(WebElement e: pageHeaders)
			{
				eleValue=e.getText();
				headerElements.add(eleValue);
			}
			
			System.out.println("Headers in Home Page: " + headerElements);
			return headerElements;
		}
		
		public SearchResultPage doSearch(String searchText)
		{
			//driver.findElement(searchInput).sendKeys(searchText);
			elUtil.waitForSendKeys(searchInput, searchText, DEFAULT_TIMEOUT);
			driver.findElement(searchButton).click();
			return new SearchResultPage(driver);
		}
		
}
