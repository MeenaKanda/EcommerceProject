package com.qa.ecommerce.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.ecommerce.factory.DriverFactory;
import com.qa.ecommerce.pages.EcomAccountsPage;
import com.qa.ecommerce.pages.EcomCheckOutPage;
import com.qa.ecommerce.pages.EcomHomePage;
import com.qa.ecommerce.pages.EcomLoginPage;
import com.qa.ecommerce.pages.EcomProductInfoPage;
import com.qa.ecommerce.pages.EcomRegisterationPage;
import com.qa.ecommerce.pages.EcomSearchPage;
import com.qa.ecommerce.tests.EcomCheckOutPageTest;
import com.qa.ecommerce.tests.EcomHomePageTest;
import com.qa.ecommerce.tests.EcomLoginPageTest;
import com.qa.ecommerce.utils.ElementUtil;



public class BaseTest {
	
	protected WebDriver driver;
	protected DriverFactory dr;
	protected EcomLoginPage loginPage;
	protected EcomHomePage homePage;
	protected EcomRegisterationPage regPage;
	protected EcomAccountsPage accPage;
	protected ElementUtil eleUtil;
	protected EcomSearchPage searchPage;
	protected EcomProductInfoPage proInfoPage;
	protected EcomCheckOutPage checkoutPage;
	protected Properties prop;
	
	protected SoftAssert softAssert;
	
	
	
	@BeforeTest
	
	public void setup() {
		dr = new DriverFactory();
		prop = dr.initProp();
		driver = dr.initDriver(prop);
//		homePage = new EcomHomePage(driver);
		loginPage = new EcomLoginPage(driver);
		eleUtil = new ElementUtil(driver);
		
		softAssert = new SoftAssert();

	}
	
	@AfterTest
	public void close() {
		driver.quit();

	}	

}
