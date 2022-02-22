package com.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;

public class LoginPage extends BaseTest {
	
	@FindBy(id = "user-name")
	WebElement usrName;
	
	@FindBy(id = "password")
	WebElement passwrd;

	@FindBy(id = "login-button")
	WebElement loginButton;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String getLoginPageTitle() {
		return driver.getTitle();	
	}
	
	public ProductsPage userLogin() {
		usrName.sendKeys(prop.getProperty("username"));
		passwrd.sendKeys(prop.getProperty("password"));
		loginButton.click();
		return new ProductsPage();	
	}
}
