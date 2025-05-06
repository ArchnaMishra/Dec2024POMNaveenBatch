package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class SearchTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetup()
	{
		accP= loginP.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void searchTest()
	{
		searchResultP =accP.doSearch("macbook");
		Assert.assertEquals(searchResultP.getSearchProductCount(), 3);
	}

}
