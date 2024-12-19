package com.qa.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.ecommerce.base.BaseTest;
import com.qa.ecommerce.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic - 100: desigh login for open cart app")
@Story("US-Login: 101: design login page features for open cart application")

public class EcomLoginPageTest extends BaseTest{
	
	@Severity(SeverityLevel.TRIVIAL)
	@Description("...checking the title of the page.... tester:Meena")
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE_VALUE);
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Description("...checking the url of the page.... tester:Meena")
	@Test(priority = 2)
	public void loginPageUrlTest() {
		String actURl = loginPage.getLoginPageUrl();
		Assert.assertTrue(actURl.contains(AppConstants.LOGIN_PAGE_URL_FRACTION));
		
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("...checking forgot pwd link exist... tester:Meena")
	@Test(priority = 3)
	public void forgotPWDExistTest() {
		boolean pwd =loginPage.IsForgotPWDExist();
		Assert.assertTrue(pwd);
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("...checking logo of the application... tester:Meena")
	@Test(priority = 4)
	public void logoTest() {
		String actLogo =loginPage.getLogoPage();
		Assert.assertEquals(actLogo, AppConstants.LOGIN_PAGE_SRC_VALUE);
	}

	@Severity(SeverityLevel.NORMAL)
	@Description("...checking login continue button of the page.... tester:Meena")
	@Test(priority = 5)
	public void continueBTNExistTest() {
		boolean conBtn = loginPage.IsContinueBtnExist();
		Assert.assertTrue(conBtn);
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Description("...checking privacy policy of the page.... tester:Meena")
	@Test(priority = 6) 
	public void privacyPolicyExistTest() {
		boolean pp = loginPage.IsPrivacyPolicyExist();
		Assert.assertTrue(pp); 
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Description("...checking transaction of the page.... tester:Meena")
	@Test(priority = 7)
	public void transactionExistTest() {
		boolean trans = loginPage.IsTransactionsExist();
		Assert.assertTrue(trans);
	}

	@Severity(SeverityLevel.BLOCKER)
	@Description("...checking user is able to login to app with correct username and password")
	@Test(priority = 8)
	public void loginTest() {
		accPage =loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		boolean accP = accPage.isLogoutLinkExist();
		Assert.assertTrue(accP);
	}
 
}
   