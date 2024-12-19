package com.qa.ecommerce.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.BaseTest;
import com.qa.ecommerce.constants.AppConstants;

public class EcomAccountPageTest extends BaseTest {

	@BeforeClass
	public void loginTest() {
		accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}

	@Test(priority = 1)
	public void accPageTitleTest() {
		String actTitle = accPage.getAccPageTitle();
		Assert.assertEquals(actTitle, AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
	}

	@Test(priority = 2)
	public void accPageUrlTest() {
		String actUrl = accPage.getAccPageURL();
		Assert.assertTrue(actUrl.contains(AppConstants.ACCOUNTS_PAGE_URL_FRACTION));
	}

	@Test(priority = 3)
	public void logoutExistTest() {
		boolean linkExist = accPage.isLogoutLinkExist();
		Assert.assertEquals(linkExist, true);
	}

	@Test(priority = 4)
	public void searchExistTest() {
		boolean serExist = accPage.isSearchExist();
		Assert.assertEquals(serExist, true);
	}

	@Test(priority = 5)
	public void accPageHeaderListTest() {
		List<String> actHeaderList = accPage.getAccountsHeadersList();
		Assert.assertEquals(actHeaderList, AppConstants.EXPECTED_ACCOUNTS_PAGE_HEADERS_LIST);
	}

/*	@Test(priority = 6)
	public void ffAdminInfoTest() {
		String actInfo = accPage.getFooterAdminInfo();
		Assert.assertEquals(actInfo, AppConstants.ACCOUNTS_PAGE_ADMIN_VALUE);
	}
*/
	@Test(priority = 7)
	public void ffLinkCountTest() {
		int actCount = accPage.getFooterLinksCount();
		Assert.assertEquals(actCount, AppConstants.ACCOUNTS_PAGE_FOOTER_COUNTS);
	}

	@Test(priority = 8)
	public void navBarCountTest() {
		int actCount = accPage.getRightNavigationBarCount();
		Assert.assertEquals(actCount, AppConstants.ACCOUNT_PAGE_NAVBAR_COUNTS);
	}

	@Test(priority = 9)
	public void navBarListTest() {
		List<String> eleList = accPage.getRightNavigationBarList();
		Assert.assertEquals(eleList, AppConstants.ACCOUNTS_PAGE_NAV_LIST);
	}

	@Test(priority = 10)   
	public void performSerachTest() {
       accPage.performSearch("Macbook");
	}
}