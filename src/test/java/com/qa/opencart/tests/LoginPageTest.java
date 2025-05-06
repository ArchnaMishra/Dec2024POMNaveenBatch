package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import static com.qa.opencart.constants.AppConstants.*;

@Feature("F 50 : Open cart : login feature")
@Epic("Epic 100: design page for open cart application")
@Story("US 101 : Implementing login page for open cart application")
public class LoginPageTest extends BaseTest {
	
	@Description("checking open cart login page title")
	@Severity(SeverityLevel.MINOR)
	@Owner("Archna Mishra")
	@Issue("Bug ID 234155")
	@Test(description = "checking login title")
	public void pageTitleTest()
	{
		String pageTitle= loginP.getLoginPageTitle();
		Assert.assertEquals(pageTitle, LOGIN_PAGE_TITLE);
	}
	
	@Description("checking open cart login page url")
	@Severity(SeverityLevel.MINOR)
	@Owner("Archna Mishra")
	@Test(description = "checking login page url")
	public void pageUrlTest()
	{
		String pageURL=loginP.getLoginPageUrl();
		Assert.assertTrue(pageURL.contains(LOGIN_PAGE_FRACTION_URL), "Page URL is incorrect");
	}
	
	@Description("checking open cart login page url")
	@Severity(SeverityLevel.BLOCKER)
	@Owner("Archna Mishra")
	@Test(priority = Short.MAX_VALUE)
	public void loginTest()
	{
	   accP= loginP.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	   Assert.assertEquals(accP.getAccPageTitle(), HOME_PAGE_TITLE);
	}

}
