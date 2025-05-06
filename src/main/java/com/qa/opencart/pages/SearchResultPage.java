package com.qa.opencart.pages;

import static com.qa.opencart.constants.AppConstants.DEFAULT_TIMEOUT;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import comp.qa.oopencart.utils.ElementUtil;


public class SearchResultPage {
	
	private WebDriver driver;
	private ElementUtil elUtil;
	
	By searchProductList= By.cssSelector("div.product-thumb h4>a");
	
	public SearchResultPage(WebDriver driver)
	{
		this.driver=driver;
		elUtil=new ElementUtil(driver);
	}
	
	public List<String> getSearchProductList()
	{
		List<WebElement> searchList= elUtil.waitForVisibilityOfAllElementsLocatedBy(searchProductList, DEFAULT_TIMEOUT);
		List<String> searchElementsList = new ArrayList<String>();
		for(WebElement e: searchList)
		{
			String searchEleTitle=e.getText();
			searchElementsList.add(searchEleTitle);
		}
		
		return searchElementsList;
	}
	
	public int getSearchProductCount()
	{
		List<WebElement> searchList= elUtil.waitForVisibilityOfAllElementsLocatedBy(searchProductList, DEFAULT_TIMEOUT);
		System.out.println("Number of searched product is: "+ searchList.size());
		return searchList.size();
	}
	
	public ProductInfoPage doSelectResult(String selectText)
	{
		List<WebElement> searchList= elUtil.waitForVisibilityOfAllElementsLocatedBy(searchProductList, DEFAULT_TIMEOUT);
		//List<String> searchElementsList = new ArrayList<String>();
		for(WebElement e: searchList)
		{
			if(e.getText().equalsIgnoreCase(selectText))
			{
				e.click();	
				break;
			}
		}
		
		return new ProductInfoPage(driver);
	}

}
