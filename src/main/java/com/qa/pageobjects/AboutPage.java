package com.qa.pageobjects;

import com.qa.base.BaseTest;

public class AboutPage extends BaseTest {

	public String getAboutPageTitle() {
		return driver.getTitle();	
	}

	public ProductsPage clickBrowserBackButton() {
		driver.navigate().back();
		return new ProductsPage();
	}

}
