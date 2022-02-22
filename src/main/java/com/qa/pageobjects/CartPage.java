package com.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;

public class CartPage extends BaseTest {
	
	@FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")	
	WebElement cartPageHeader;
	
	@FindBy(id = "checkout")
	WebElement checkoutBtn;
	
	@FindBy(className = "inventory_item_name")
	WebElement productName;
	
	@FindBy(className = "inventory_item_price")
	WebElement productPrice;
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getCartPageTitle() {
		return cartPageHeader.getText();
	}
	
	public String getCartItemName() {
		return productName.getText();		
	}
	
	public String getCartItemPrice() {
		return productPrice.getText();
	}
		
	public CheckOutPage clickCheckoutButton(){
		checkoutBtn.click();
		return new CheckOutPage();
	}
	
	
	
}
