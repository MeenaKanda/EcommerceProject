package com.qa.ecommerce.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.ecommerce.constants.AppConstants;
import com.qa.ecommerce.utils.ElementUtil;



public class EcomAccountsPage {
	
	private WebDriver driver;
	ElementUtil eleUtil ;

	private By logout = By.linkText("Logout");
	private By accHeaders = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	private By footerAdminInfo = By.xpath("(//footer/div[@class='container']//p");
	private By footerLinks = By.xpath("//footer/div[@class='container']//li");
	private By NavBarLinks = By.cssSelector("#column-right a");
	
	

	public EcomAccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	
		
	}
	
	public String  getAccPageTitle() {
			String title = eleUtil.waitForTitleContainsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT, AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
			System.out.println("Acc page title is : " + title);
			return title;
		}
		
		public String getAccPageURL() {
			String url = eleUtil.waitForURLContainsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT, AppConstants.ACCOUNTS_PAGE_URL_FRACTION);
			System.out.println("Acc pager url : " + url);
			return url;
		}
		
		public boolean isLogoutLinkExist() {
			return eleUtil.waitForElementVisible(logout, AppConstants.DEFAULT_MEDIUM_TIME_OUT).isDisplayed();
		}
		
		public boolean isSearchExist() {
			return eleUtil.waitForElementVisible(search, AppConstants.DEFAULT_MEDIUM_TIME_OUT).isDisplayed();
		}
		
		public List<String> getAccountsHeadersList() {
			List<WebElement> accHeadersList = eleUtil.waitForElementsVisible(accHeaders, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
			List<String> accHeadersValList = new ArrayList<String>();
			
			for(WebElement e : accHeadersList) {
				String text = e.getText();
				accHeadersValList.add(text);
			}
			return accHeadersValList;
		}
		
		public String getFooterAdminInfo() {
	//		eleUtil.waitForElementVisible(footerAdminInfo, AppConstants.DEFAULT_SHORT_TIME_OUT).getText();
			String footerText = eleUtil.doElementGetText(footerAdminInfo);
			return footerText;
		}
		
		public int getFooterLinksCount() {
			List<WebElement> ffLinks = eleUtil.getElements(footerLinks);
			int ffCount = ffLinks.size();
			System.out.println(ffCount);
			return ffCount;
			
        }
		public int getRightNavigationBarCount() {
			List<WebElement> NavLinks = eleUtil.getElements(NavBarLinks);
			int NavCount = NavLinks.size();
			System.out.println(NavCount);
			return NavCount;
		}
		
		public List<String> getRightNavigationBarList() {
			List<String> NavList = new ArrayList<String>();
			List<WebElement> NavLinks = eleUtil.getElements(NavBarLinks);
			for(WebElement e : NavLinks) {
				String text = e.getText();
				System.out.println(text);
				NavList.add(text);
			}
			System.out.println(NavList);
			return NavList;
		}
		
		public EcomSearchPage performSearch(String searchKey) {
			if(isSearchExist()) {
				eleUtil.doSendKeys(search, searchKey);
				eleUtil.doClick(searchIcon);
				return new EcomSearchPage(driver);
				
			}
			else {
				System.out.println("Search field is not present on the page  .........");
				return null;
			}
		}
		
		
		
		
}
