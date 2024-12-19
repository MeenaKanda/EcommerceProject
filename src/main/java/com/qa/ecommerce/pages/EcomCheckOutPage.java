package com.qa.ecommerce.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ecommerce.constants.AppConstants;
import com.qa.ecommerce.utils.ElementUtil;

public class EcomCheckOutPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By tableCount = By.cssSelector(".table-responsive thead tr td");
	
	public EcomCheckOutPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getCheckOutTitle() {
		String title = eleUtil.waitForTitleContainsAndFetch(AppConstants.DEFAULT_MEDIUM_TIME_OUT, AppConstants.CHECKOUT_PAGE_TITLE_VALUE);
	    System.out.println("Check Out page title is ::::" + title);
	    return title;
	}
	
	
	public String getCheckOutUrl() {
		String url = eleUtil.waitForURLContainsAndFetch(AppConstants.DEFAULT_MEDIUM_TIME_OUT, AppConstants.CHECKOUT_PAGE_URL_FRACTION);
	    System.out.println("Check Out page title is ::::" + url);
	    return url;
	}
	
	public int getShoppingCartTableHeaderCount() {
		int headerCount = eleUtil.getTotalElementsCount(tableCount);
		System.out.println("header count :::" + headerCount);
		return headerCount;
	}
	
	public List<String> getShoppingCartTableHeaderText() {
		List<String> eleList = eleUtil.getElementsTextList(tableCount);
		System.out.println(eleList);
		return eleList;
	}
	
}
