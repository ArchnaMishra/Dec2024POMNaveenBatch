package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;

public class ProductInfoTest extends BaseTest {
	
	@BeforeClass
	public void productInfoSetup()
	{
		accP= loginP.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	/*
	 * Brand: Apple
	   Product Code: Product 17
	   Reward Points: 700
	   Availability: Out Of Stock
	 */
//	@DataProvider
//	public Object[][] getproductData() {
//        return new Object[][] {
//            {"Brand", "Apple"},
//            {"Product Code", "Product 17"},
//            {"Reward Points", "700"},
//            {"Availability", "Out Of Stock"}
//        };
//    } 
//	
//	@Test (dataProvider= "getproductData")
	public void productHeaderTest()
	{
		searchResultP = accP.doSearch("macbook");
		productInfoP = searchResultP.doSelectResult("Macbook Air");
		String actualHeader= productInfoP.getProductHeader();
		Assert.assertEquals(actualHeader, "MacBook Air");
	}
	
	
	
	@DataProvider
	public Object[][] getproductData() {
        return new Object[][] {
            {"macbook","Macbook Air" ,"Apple", "Product 17", "700","Out Of Stock", "$1,202.00", "$1,000.00"},
            {"iMac","iMac" ,"Apple", "Product 14", " ","Out Of Stock", "$122.00", "$100.00"},
            {"samsung","Samsung SyncMaster 941BW" ," ", "Product 6", " ","2-3 Days", "$242.00", "$200.00"}
        };
    } 
	
	/*
	 * Brand: Apple
	   Product Code: Product 17
	   Reward Points: 700
	   Availability: Out Of Stock
	 */
	@Test (dataProvider= "getproductData")
	public void getActualProductDetailsTest(String searchValue, String expectedProductListed, String expectedbrand, 
			                                String expectedProductCode, String expectedRewardPoints, 
			                                String expectedAvailability, String expectedCost, String expectedNoTaxCost  )
	{
//		searchResultP = accP.doSearch("macbook");
//		productInfoP = searchResultP.doSelectResult("Macbook Air");
//		Map<String, Object> actualProductDetailsList= productInfoP.getProductDetails();
//		SoftAssert softAssert=new SoftAssert();
//		softAssert.assertEquals(actualProductDetailsList.get("Brand"), "Apple");
//		softAssert.assertEquals(actualProductDetailsList.get("Product Code"), "Product 17");
//		softAssert.assertEquals(actualProductDetailsList.get("Reward Points"), "700");
//		softAssert.assertEquals(actualProductDetailsList.get("Availability"), "Out Of Stock");
//		
//		softAssert.assertAll();
		
		searchResultP = accP.doSearch(searchValue);
		productInfoP = searchResultP.doSelectResult(expectedProductListed);
		Map<String, Object> actualProductDetailsList= productInfoP.getProductDetails();
//		for(Map.Entry<String, Object> e :actualProductDetailsList.entrySet() )
//		{
//			if(e.getValue().equals(""))
//			{
//				e.setValue(" ");
//				System.out.println("Inside null loop");
//			}
//		}
		
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(actualProductDetailsList.get("Brand"), expectedbrand);
		softAssert.assertEquals(actualProductDetailsList.get("Product Code"), expectedProductCode);
		softAssert.assertEquals(actualProductDetailsList.get("Reward Points"), expectedRewardPoints);
		softAssert.assertEquals(actualProductDetailsList.get("Availability"), expectedAvailability);
		softAssert.assertEquals(actualProductDetailsList.get("Product Cost"), expectedCost);
		softAssert.assertEquals(actualProductDetailsList.get("ExTax Cost"), expectedNoTaxCost);
		
		softAssert.assertAll();

		
		
	}
	

}
