package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pageobjects.CartPage;
import com.qa.pageobjects.CheckOutPage;
import com.qa.pageobjects.LoginPage;
import com.qa.pageobjects.ProductsPage;
import com.qa.util.ListenerTest;

@Listeners(ListenerTest.class)
public class TestScenarioOne extends BaseTest{
	public static LoginPage loginPage;
	public static ProductsPage productPage;
	public static CartPage cartPage;
	public static CheckOutPage checkoutPage;

	public static String expectedLoginPageTitle = "Swag Labs";
	public static String expectedproductPageHeader = "PRODUCTS";
	public static String expectedAboutPageTitle = "Cross Browser Testing, Selenium Testing, Mobile Testing | Sauce Labs";
	public static String expectedCartPageHeader = "YOUR CART";
	public static String checkoutComplete = "CHECKOUT: COMPLETE!";
	public static String productName = "Sauce Labs Fleece Jacket";
	public static String productPrice = "$49.99";
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 0)
	public static void loginPageTitleCheck() {
		String loginPageTitle = loginPage.getLoginPageTitle();
		try {
			Assert.assertEquals(loginPageTitle,expectedLoginPageTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 1)
	public static void userLogin() {
		productPage = loginPage.userLogin();
		String productPageHeader = productPage.getProductPageHeader();
		try {
			Assert.assertEquals(productPageHeader,expectedproductPageHeader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2)
	public static void getAboutPage() {
		String aboutPageTitle = loginPage.userLogin().clickAboutButton().getAboutPageTitle();
		try {
			Assert.assertEquals(aboutPageTitle,expectedAboutPageTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 3)
	public static void aboutPageBackButton() {
		productPage = loginPage.userLogin().clickAboutButton().clickBrowserBackButton();
		String productPageHeader = productPage.getProductPageHeader();
		try {
			Assert.assertEquals(productPageHeader,expectedproductPageHeader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 4)
	public static void sortedDataconfirmation() {
		productPage = loginPage.userLogin();
		productPage.sortInventoryData();
		String highestPriceItem = productPage.getProductName();
		try {
			Assert.assertEquals(highestPriceItem,productName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 5)
	public static void itemAddtoCart() {
		productPage = loginPage.userLogin();
		productPage.sortInventoryData();
		cartPage = productPage.clickAddToCart();
		String cartPageHeader = cartPage.getCartPageTitle();
		try {
			Assert.assertEquals(cartPageHeader,expectedCartPageHeader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 6)
	public static void cartItemConfirmation() {
		productPage = loginPage.userLogin();
		productPage.sortInventoryData();
		String itemName = productPage.getProductName();
		cartPage = productPage.clickAddToCart();
		String cartItemName = cartPage.getCartItemName();
		try {
			Assert.assertEquals(cartItemName,itemName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 7)
	public static void itemPriceConfirmation() {
		productPage = loginPage.userLogin();
		productPage.sortInventoryData();
		cartPage = productPage.clickAddToCart();
		String itemPrice = cartPage.getCartItemPrice();		
		try {
			Assert.assertEquals(itemPrice,productPrice);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 8)
	public static void checkoutItemConfirmation() {
		productPage = loginPage.userLogin();
		productPage.sortInventoryData();
		String itemName = productPage.getProductName();
		cartPage = productPage.clickAddToCart();
		checkoutPage = cartPage.clickCheckoutButton();
		checkoutPage.userDetails();
		String checkoutItem = checkoutPage.getCheckoutItemName();
		try {
			Assert.assertEquals(checkoutItem,itemName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test(priority = 9)
	public static void oderPlaced() {
		productPage = loginPage.userLogin();
		productPage.sortInventoryData();
		cartPage = productPage.clickAddToCart();
		checkoutPage = cartPage.clickCheckoutButton();
		checkoutPage.userDetails();
		String orderConfirmation = checkoutPage.orderConfirmation();
		try {
			Assert.assertEquals(orderConfirmation,checkoutComplete);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
