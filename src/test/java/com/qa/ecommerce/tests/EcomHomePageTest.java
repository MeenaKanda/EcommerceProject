package com.qa.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.BaseTest;
import com.qa.ecommerce.pages.EcomHomePage;
import com.qa.ecommerce.pages.EcomRegisterationPage;

public class EcomHomePageTest extends BaseTest{
	
	
	@BeforeTest
	public void enterRegPage() {
		homePage = new EcomHomePage(driver);	}

	@Test
	public void HomePageUrlTest() {
		
          String actHpUrl =  homePage.getHomePageUrl(); 
          Assert.assertEquals(actHpUrl, "https://naveenautomationlabs.com/opencart/index.php?route=common/home");

	}
	
	@Test
	public void HomePageTitleTest() {
		String actTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actTitle, "Your Store");
	}
	
	@Test
	public void CurrencyDropDownTest() {
		boolean flag = homePage.CurrencyDropDownCount();
		Assert.assertEquals(flag, true);
	}
	
	@Test
	public void MyAccountDropDownTest() {
		boolean flag = homePage.IsMyAccountDropDownExist();
		Assert.assertEquals(flag, true);
	}
	
	@Test
	public void SelectRegistrationPageTest() {
		
	   regPage = homePage.SelectRegPage();
	   Assert.assertTrue(regPage.IsRegisterExist());
	}
			

}
