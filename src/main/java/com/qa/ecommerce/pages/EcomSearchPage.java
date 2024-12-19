package com.qa.ecommerce.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.ecommerce.constants.AppConstants;
import com.qa.ecommerce.utils.ElementUtil;

public class EcomSearchPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private By searchProductResults = By.cssSelector("div#content div.product-layout");
	private By addCartLink = By.xpath("(//button[@type='button' and contains(@onclick,'cart')]//span)[position() =1]");
//	private By sort = By.xpath("//label[@class='input-group-addon' and contains(@for,'sort')]");
	private By sort = By.xpath("//label[text()='Sort By:']");
	private By show = By.xpath("//label[text()='Show:']");
	private By showSelect = By.id("input-limit");
	private By proItem = By.linkText("MacBook Air");
	
	public EcomSearchPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public int getSearchProductCount() {
		int productCount = eleUtil.waitForElementsVisible(searchProductResults, AppConstants.DEFAULT_MEDIUM_TIME_OUT)
				.size();
		System.out.println("Product Count is  :::::" + productCount);
		return productCount;
	}

	public boolean IsAddCartExist() {
		boolean flag = eleUtil.getElement(addCartLink).isDisplayed();
		return flag;
	}

	public boolean IsSortExist() {
		return eleUtil.getElement(sort).isDisplayed();
	}

	public boolean IsShowExist() {
		return eleUtil.getElement(show).isDisplayed();
	}

	public int getShowDropDownCount() {
		Select select = new Select(eleUtil.getElement(showSelect));
		List<WebElement> eleList = select.getOptions();
		int ddCount = eleList.size();
		System.out.println(ddCount);
		return ddCount;
	}

	public void selectShowDropDownList(int ddNum) {
		Select select = new Select(eleUtil.getElement(showSelect));
		List<WebElement> eleList = select.getOptions();
		System.out.println(eleList);
		for (WebElement e : eleList) {
			String count = e.getText();
			System.out.println(count);
			if (Integer.valueOf(count) == ddNum) {
				e.click();
				break;
			}
		}

	}
	
	public EcomProductInfoPage doSelectProduct(String product) {
		By prod = By.linkText(product);
		eleUtil.waitForElementVisible(prod,AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
		return new EcomProductInfoPage(driver);
	}
}
