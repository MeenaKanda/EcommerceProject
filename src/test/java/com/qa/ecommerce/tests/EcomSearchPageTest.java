package com.qa.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.BaseTest;
import com.qa.ecommerce.constants.AppConstants;

public class EcomSearchPageTest extends BaseTest{
	
	@BeforeClass
	public void loginTest() {
		accPage = loginPage.doLogin("auto-Test@gmail.com", "Test123+");
		searchPage = accPage.performSearch("macbook");	
	}
	
	@Test(priority = 1)
	public void serarchProductCountTest() {
		int actCount = searchPage.getSearchProductCount();
		Assert.assertTrue(actCount > 0);
	}
	
	@Test(priority = 2)
	public void addCartExistTest() {
		boolean addCart = searchPage.IsAddCartExist();
		Assert.assertTrue(addCart);
	}
	
	@Test(priority = 3)
	public void sortExistTest() {
		boolean sort = searchPage.IsSortExist();
		Assert.assertTrue(sort);
	}

	@Test(priority = 4)
	public void showExistTest() {
		boolean show = searchPage.IsShowExist();
		Assert.assertTrue(show);
	}
	
	@Test(priority = 5)
	public void showDDCountTest() {
		int actCount = searchPage.getShowDropDownCount();
		Assert.assertEquals(actCount, AppConstants.SEARCH_PAGE_DROPDOWN_COUNT);
	}
	
	@Test(priority = 6)
    public void selectDropDownTest() {
    	searchPage.selectShowDropDownList(25);
    }
	
	@Test(priority = 7)
	public void selectProductTest() {
		searchPage.doSelectProduct("MacBook Air");
	}

}
