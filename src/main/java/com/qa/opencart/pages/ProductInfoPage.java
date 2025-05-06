package com.qa.opencart.pages;

import static com.qa.opencart.constants.AppConstants.DEFAULT_TIMEOUT;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import comp.qa.oopencart.utils.ElementUtil;


public class ProductInfoPage{
	
	private WebDriver driver;
	private ElementUtil elUtil;
	private Map<String, Object> productDetailList;
	
	By productHeader = By.cssSelector("div#content h1");
	By productDetails=By.xpath("(//div[@id='content']//ul)[3]//li");	
	By productCostDetails=By.xpath("(//div[@id='content']//ul)[4]//li");
	
	public ProductInfoPage(WebDriver driver)
	{
		this.driver=driver;
		elUtil=new ElementUtil(driver);
	}
	
	public String getProductHeader()
	{
		String headerValue= elUtil.doGetText(productHeader);
		System.out.println("Header Value of product: "+ headerValue);
		return headerValue;
	}
	
	public void getProductCost() 
	{
		List<WebElement> productCostList = elUtil.waitForVisibilityOfAllElementsLocatedBy(productCostDetails, DEFAULT_TIMEOUT);
		String productCost=productCostList.get(0).getText().trim();
		productDetailList.put("Product Cost", productCost);
		String exTaxValue= productCostList.get(1).getText().split(":")[1].trim();
		productDetailList.put("ExTax Cost", exTaxValue);
	}
	
	/*
	 * Brand: Apple
	   Product Code: Product 17
	   Reward Points: 700
	   Availability: Out Of Stock
	 */
	public Map<String, Object> getProductDetails()
	{
		productDetailList=new TreeMap<String,Object>();
		getProductCost();
		List<WebElement> productInformationList = elUtil.waitForVisibilityOfAllElementsLocatedBy(productDetails, DEFAULT_TIMEOUT);
		List<String> keyValueList=List.of("Brand", "Product Code","Reward Points","Availability","Product Cost","ExTax Cost");
		for(WebElement e: productInformationList)
		{
			String key=e.getText().split(":")[0].trim();
			Object value=e.getText().split(":")[1].trim();
			
			productDetailList.put(key, value);
		}
		
		for(String s:keyValueList)
		{
			if(!productDetailList.containsKey(s))
			{
				productDetailList.put(s, " ");
			}
		}
				
		
		System.out.println(productDetailList);
		return productDetailList;
		
		
	}

}
