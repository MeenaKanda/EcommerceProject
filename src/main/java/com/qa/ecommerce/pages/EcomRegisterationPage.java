package com.qa.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ecommerce.constants.AppConstants;
import com.qa.ecommerce.utils.ElementUtil;



public class EcomRegisterationPage {

	private WebDriver driver;
	private By register = By.linkText("Register");
	
	private ElementUtil eleUtil;

	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");

	private By agreeCheckBox = By.name("agree");
	private By continueButton = By.xpath("//input[@value='Continue' and @type='submit']");

	private By subscribeYes = By.xpath("//label[normalize-space()='Yes']/input[@type='radio']");
	private By subscribeNo = By.xpath("//label[normalize-space()='No']/input[@type='radio']");

	private By registerSuccessMesg = By.xpath("//div[@id='content']/h1");

	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");

	public EcomRegisterationPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public boolean IsRegisterExist() {
	   return driver.findElement(register).isDisplayed();
	}
	
	public boolean doRegisterEcomPage(String firstName, String lastName, String email, String telephone, String password, String subscribe) {
		
/*		driver.findElement(this.firstName).sendKeys(firstName);
		
		driver.findElement(this.lastName).sendKeys(lastName);
		driver.findElement(this.email).sendKeys(email);
		driver.findElement(this.telephone).sendKeys(telephone);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.confirmpassword).sendKeys(password);
		
		if(subscribe.equalsIgnoreCase("yes")) {
			driver.findElement(subscribeYes).click();
		}
		else
			driver.findElement(subscribeNo).click();
		
		driver.findElement(agreeCheckBox).click();
		driver.findElement(continueButton).click();
		
		String successMes =  driver.findElement(registerSuccessMesg).getText();
		if(successMes.contains(AppConstants.USER_REG_SUCCESS_MESSG)) {
			eleUtil.doClick(logoutLink);
			eleUtil.doClick(registerLink);
			return true;
		}
		else {return false;}
	}
	*/
		eleUtil.waitForElementVisible(this.firstName, AppConstants.DEFAULT_SHORT_TIME_OUT).sendKeys(firstName);
		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.telephone, telephone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(this.confirmpassword, password);
		
		   if(subscribe.equalsIgnoreCase("yes")) {
			   eleUtil.doClick(subscribeYes);
		   }
		   else {
			   eleUtil.doClick(subscribeNo);
		   }
	   eleUtil.doActionsClick(agreeCheckBox);
	   eleUtil.doActionsClick(continueButton);
		   
	   String successMesg = eleUtil.waitForElementVisible(registerSuccessMesg, AppConstants.DEFAULT_MEDIUM_TIME_OUT).getText();
       System.out.println("user reg success messg : " + successMesg);
       
       
       if(successMesg.contains(AppConstants.USER_REG_SUCCESS_MESSG)) {
    	   eleUtil.doClick(logoutLink);
    	   eleUtil.doClick(registerLink);
    	   return true;
       }
       return false;
	
	}
	

}
