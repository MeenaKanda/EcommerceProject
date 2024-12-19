package com.qa.ecommerce.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.qa.ecommerce.constants.AppConstants;
import com.qa.ecommerce.utils.ElementUtil;

public class EcomHomePage {
	
	private ElementUtil eleUtil ;
	

	private WebDriver driver;
	By CurrencyList = By.xpath("//form[@id='form-currency']//li");
	By Account =  By.xpath("//a[@title='My Account']");
	By AccDropDown = By.xpath("//a[@title='My Account']/following-sibling::ul//a");
	By Register = By.linkText("Register");
	
	

	public EcomHomePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getHomePageTitle() {
//		String title = driver.getTitle();
		String title = eleUtil.waitForTitleAndFetch(AppConstants.DEFAULT_MEDIUM_TIME_OUT, AppConstants.HOME_PAGE_TITLE_VALUE);
		return title;
	}
	
	public String getHomePageUrl() {
//		String currentUrl = driver.getCurrentUrl();
		String currentUrl = eleUtil.waitForURLContainsAndFetch(AppConstants.DEFAULT_MEDIUM_TIME_OUT, AppConstants.HOME_PAGE_URL_FRACTION);
		return currentUrl;
	}
	
	
	
	@SuppressWarnings("unlikely-arg-type")
	public boolean CurrencyDropDownCount() {
//		List<WebElement> currList = driver.findElements(CurrencyList);
		List<WebElement> currList = eleUtil.waitForElementsVisible(CurrencyList, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
		System.out.println(currList);
		System.out.println("Currency Drop Down Counts = " + currList.size());
//		if(currList.retainAll(Arrays.asList("€ Euro","£ Pound Sterling","$ US Dollar"))) {
		if(currList.retainAll(Arrays.asList(AppConstants.HOME_PAGE_CURRENCY_LIST))) {
			for(WebElement e : currList) {
				String  currency = e.getText();
				System.out.println(currency);
			}
			return true;
			}
		return false;
	}
	
	public boolean IsMyAccountDropDownExist() {
//		return driver.findElement(Account).isDisplayed();
		return eleUtil.doElementIsDisplayed(Account);
	}
	
	
	
	public EcomRegisterationPage SelectRegisterPage() {
//		List<WebElement> AccDDList = driver.findElements(AccDropDown);
		List<WebElement> AccDDList = eleUtil.waitForElementsVisible(AccDropDown, AppConstants.DEFAULT_SHORT_TIME_OUT);
				if(AccDDList.size()>0) {
			for(WebElement e : AccDDList) 
				if(e.getText().equals(AppConstants.HOME_PAGE_REGISTER)) {
					e.click();
					return new EcomRegisterationPage(driver);
				}
			}
				return null;
		}
		

	
	public EcomRegisterationPage  SelectRegPage() {
		
		Actions act = new Actions(driver);
//		act.moveToElement(driver.findElement(Account)).click().build().perform();
//		act.moveToElement(driver.findElement(Register)).click().build().perform();
		act.moveToElement(eleUtil.waitForElementVisible(Account, AppConstants.DEFAULT_SHORT_TIME_OUT)).click().build().perform();
		act.moveToElement(eleUtil.waitForElementVisible(Register, AppConstants.DEFAULT_SHORT_TIME_OUT)).click().build().perform();
		return new EcomRegisterationPage(driver);

	}	


}
