package com.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseTest;

public class ProductsPage extends BaseTest{

	@FindBy(id = "react-burger-menu-btn")
	WebElement menuBtn;

	@FindBy(xpath = "//*[@id=\"about_sidebar_link\"]")
	WebElement aboutBtn;

	@FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
	WebElement header;

	@FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select")
	WebElement dropDown;
		
	@FindBy(xpath = "//*[contains(@name,'add-to-cart')]")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
	WebElement cartBtn;
		
	@FindBy(className = "inventory_item_name")
	WebElement productName;

	public ProductsPage() {
		PageFactory.initElements(driver, this);
	}

	public String getProductPageHeader() {
		return header.getText();
	}

	public AboutPage clickAboutButton() {
		menuBtn.click();
		aboutBtn.click();
		return new AboutPage();
	}
	
	public void sortInventoryData() {		
		Select sortDropDown = new Select(dropDown);
		sortDropDown.selectByValue("hilo");
	}
	
	public String getProductName() {
		return productName.getText();
	}

	public CartPage clickAddToCart() {
		addToCartBtn.click();
		cartBtn.click();
		return new CartPage();
	}

}
