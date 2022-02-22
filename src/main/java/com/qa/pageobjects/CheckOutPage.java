package com.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;

public class CheckOutPage extends BaseTest{
	
	@FindBy(id = "first-name")
	WebElement firstName;
	
	@FindBy(id = "last-name")
	WebElement lastName;
	
	@FindBy(id = "postal-code")
	WebElement postalCode;
	
	@FindBy(id = "continue")
	WebElement continueBtn;

	@FindBy(id = "finish")
	WebElement finishBtn;
	
	@FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
	WebElement orderConfirmation;
	
	@FindBy(className = "inventory_item_name")
	WebElement productName;
	
	public CheckOutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void userDetails() {
		firstName.sendKeys("Testuser");
		lastName.sendKeys("One");
		postalCode.sendKeys("523001");
		continueBtn.click();	
	}
	
	public String getCheckoutItemName() {
		return productName.getText();
	}
	
	public String orderConfirmation() {
		finishBtn.click();
		return orderConfirmation.getText();
	}
}
