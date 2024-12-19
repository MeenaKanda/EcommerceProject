package com.qa.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ecommerce.constants.AppConstants;
import com.qa.ecommerce.utils.ElementUtil;

import io.qameta.allure.Step;

public class EcomLoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By logo = By.xpath("//img[@class='img-responsive']");
	private By continueBtn = By.linkText("Continue");
	private By PrivacyPol = By.linkText("Privacy Policy");
	private By transactions = By.linkText("Transactions");
	private By registerLink = By.linkText("Register");

	public EcomLoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	@Step(" .... getting the login page title....")
	public String getLoginPageTitle() {
		String title = eleUtil.waitForTitleAndFetch(AppConstants.DEFAULT_MEDIUM_TIME_OUT,
				AppConstants.LOGIN_PAGE_TITLE_VALUE);

		return title;
	}

	@Step(" .... getting the login page url....")
	public String getLoginPageUrl() {
		String url = eleUtil.waitForURLContainsAndFetch(AppConstants.DEFAULT_MEDIUM_TIME_OUT,
				AppConstants.LOGIN_PAGE_URL_FRACTION);
		return url;
	}
	
	@Step(" .... getting the forgot pwd link....")
	public boolean IsForgotPWDExist() {
		return eleUtil.waitForElementVisible(forgotPwdLink, AppConstants.DEFAULT_SHORT_TIME_OUT).isDisplayed();
	}
	
	@Step(" .... getting Logo of the page....")
	public String getLogoPage() {
		String logoPage = eleUtil.waitForElementVisible(logo, AppConstants.DEFAULT_SHORT_TIME_OUT).getAttribute("src");
		return logoPage;
	}
	
	@Step(" .... checking continue button exist....")
	public boolean IsContinueBtnExist() {
		return eleUtil.waitForElementVisible(continueBtn, AppConstants.DEFAULT_SHORT_TIME_OUT).isDisplayed();
	}
	
	@Step(" .... checking privacy policy exist....")
	public boolean IsPrivacyPolicyExist() {
		return eleUtil.waitForElementVisible(PrivacyPol ,AppConstants.DEFAULT_SHORT_TIME_OUT).isDisplayed();
	}
	
	@Step(" .... checking Transaction exist....")
	public boolean IsTransactionsExist() {
		return eleUtil.waitForElementVisible(transactions, AppConstants.DEFAULT_SHORT_TIME_OUT).isDisplayed();
	}
	
	@Step("login with username: {0} and password: {1}")
	public EcomAccountsPage doLogin(String emailId, String password) {
		eleUtil.waitForElementPresence(this.emailId, AppConstants.DEFAULT_SHORT_TIME_OUT).sendKeys(emailId);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doClick(loginBtn);
		return new EcomAccountsPage(driver);
				
	}
	
	@Step(" .... checking Login page navigate to Registeration page  ....")
	public EcomRegisterationPage navigateToRegPage() {
		eleUtil.doClick(registerLink);
		return new EcomRegisterationPage(driver);
	}

}
