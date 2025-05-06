package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import static com.qa.opencart.constants.AppConstants.*;



public class AccountPageTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetup()
	{
		accP= loginP.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void pageTitleTest()
	{
		String pageTitle= accP.getAccPageTitle();
		Assert.assertEquals(pageTitle, HOME_PAGE_TITLE);
	}
	
	@Test
	public void pageUrlTest()
	{
		String pageURL=accP.getAccPageUrl();
		Assert.assertTrue(pageURL.contains(HOME_PAGE_FRACTION_URL), "Page URL is incorrect");
	}
	
	@Test
	public void hearderCountTest()
	{
		List<String> pageHeaders= accP.getPageHeaders();
		Assert.assertEquals(pageHeaders,expectedAccPageHeadersList);
	}

	
	
	
	

}
