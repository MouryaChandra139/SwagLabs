package com.qa.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseTest;

public class CustomizedDriverMethods extends BaseTest {

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public String convertDateFormat(String dateValue,String source,String destination) {		
		Date date = null;
		try {
			date = new SimpleDateFormat(source).parse(dateValue);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new SimpleDateFormat(destination).format(date);
	}

	public void clickBtnWithIndex(List<WebElement> elementOneList, List<WebElement> elementTwoList, String value) {
		for(int index =0; index<elementTwoList.size(); index++) {
			if((elementTwoList.get(index).getText()).equals(value)){
				elementOneList.get(index).click();
				break;
			}
		}
	}


	public boolean getAvailability(List<WebElement> elementList, String name) {
		boolean available = false;
		for(int index = 0;index<elementList.size();index++) {
			if((elementList.get(index).getText()).equals(name)) {
				available = true;
				break;
			}
		}
		return available;
	}

	public String getCurrentDate() {		
		Date date = new Date();
		return dateFormat.format(date);		 
	}

	public String getFutureDate(int count) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, count);
		Date futureDateTime = calendar.getTime();
		return dateFormat.format(futureDateTime);
	}	

	public void clickBtnWithRandomIndex(List<WebElement> elementList) {
		Random random = new Random();
		int index =  random.nextInt(elementList.size());
		elementList.get(index).click();
	}
	
	public String getValueWithRandomIndex(List<WebElement> elementList) {
		Random random = new Random();
		int index =  random.nextInt(elementList.size());
		return elementList.get(index).getText();
	}

	public static int getRandomInt(int min ,int max) {
		Random random = new Random();  
		return random.nextInt(max- min)+min;
	}

	public static String getRandomString(int length) {
		return RandomStringUtils.randomAlphabetic(length).toLowerCase();
	}

	public String getSubString(WebElement element, int index) {
		String value = element.getText();
		return value.substring(index,value.length());
	}

	public String getStringWithIndex(List<WebElement> elementOneList, List<WebElement> elementTwoList, String value) {
		String returnValue = "";
		for(int index =0; index<elementTwoList.size(); index++) {
			if((elementTwoList.get(index).getText()).equals(value)){
				returnValue = elementOneList.get(index).getText();
				break;
			}
		} 
		return returnValue;
	}

	public void inputCheckInDate(WebElement element, String date) {		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.getElementsByName('checkIn')[0].removeAttribute('readonly');");
		jse.executeScript("document.getElementsByName('checkIn')[0].setAttribute('value','date')");
		inputTextFields(element,date);
	}

	public void inputCheckOutDate(WebElement element,String date) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.getElementsByName('checkOut')[0].removeAttribute('readonly');");
		inputTextFields(element,date);
	}


	public void inputTextFields(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public void selectDate(List<WebElement> dateValuesList,WebElement nextBtn, String date) {
		if(dateValuesList.get(dateIndex(dateValuesList,date)).getAttribute("class").contains("disabled")){
			nextBtn.click();
		}	
		dateValuesList.get(dateIndex(dateValuesList,date)).click();
	}

	public int dateIndex(List<WebElement> dateValuesList, String date) {
		int value = 0;
		for(int index =0; index <dateValuesList.size();index++) {
			if(dateValuesList.get(index).getText().equals(date)) {
				value = index;
				break;
			}
		}
		return value;
	}

	public void ScrollAndClickButton(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
		element.click();
	}


	public void selectCheckBox(WebElement element) {
		if(!element.isSelected()) {
			element.click();
		}
	}

	public void unSelectCheckBox(WebElement element) {
		if(element.isSelected()) {
			element.click();
		}
	}

	public void selectComboByValue(WebElement element,String comboValue) {
		Select combo = new Select(element);
		combo.selectByValue(comboValue);
	}

	public void selectComboByVisibleText(WebElement element,String textValue) {
		Select combo = new Select(element);
		combo.selectByVisibleText(textValue);
	}

	public void selectDropdown(List<WebElement> elementList, String option) {
		for(int index = 0 ; index < elementList.size();index++) {
			if(elementList.get(index).getText().contains(option)) {
				elementList.get(index).click();
				break;
			} 
		}
	}

	public void selectDropdownWithMatchedValue(List<WebElement> elementList,String type) {	
		for(int index = 0 ; index < elementList.size();index++) {
			if(elementList.get(index).getText().equals(type)) {
				elementList.get(index).click();
				break;
			} 
		}
	}

	public void selectRadioButton(List<WebElement> elementList, String radioValue) {
		for( int index =0; index<elementList.size();index++) {
			WebElement radioBtn = elementList.get(index);
			if((radioBtn.getAttribute("value")).equalsIgnoreCase(radioValue)) {
				radioBtn.click();
				break;
			}
		}
	}

	public void sleepAndWait(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
