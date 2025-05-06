package com.qa.opencart.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;


public class LoginPage {

	// Global variables : Webdriver
	WebDriver driver;
	

	// By locators
	By emailInput = By.id("input-email");
	By passwordInput = By.id("input-password");
	By forgotPasswordLink = By.linkText("Forgotten Password");
	By loginButton = By.xpath("//input[@type='submit']");

	// constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Getting Login page title")
	// Methods/functions to cover
	public String getLoginPageTitle()
	{
		String pageTitle = driver.getTitle();
		System.out.println("Page title is " + pageTitle);
		return pageTitle;
	}
	
	@Step("Getting Login page URL")
	public String getLoginPageUrl()
	{
		String pageUrl = driver.getCurrentUrl();
		System.out.println("Page Current URL : "+ pageUrl);
		return pageUrl;
	}
	
	@Step("Login woth valid username : {0} and password : {1}")
	public AccountPage doLogin(String username, String password)
	{
		driver.findElement(emailInput).sendKeys(username);
		driver.findElement(passwordInput).sendKeys(password);
		driver.findElement(loginButton).click();
		return new AccountPage(driver); 		
	}

}
