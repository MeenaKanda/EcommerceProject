package com.qa.ecommerce.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.BaseTest;
import com.qa.ecommerce.constants.AppConstants;
import com.qa.ecommerce.utils.ExcelUtil;

public class EcomRegisterationPageTest extends BaseTest{
	
/*	@BeforeClass
	public void enterRegPage() {
		 regPage = homePage.SelectRegPage();
	}
	*/
	
	@BeforeClass
	public void navToRegPage() {
		regPage = loginPage.navigateToRegPage();
	}
	
	@Test
	public void RegisterExistTest() {
		boolean flag = regPage.IsRegisterExist();
		Assert.assertTrue(flag); 
	}
	
	public String getRandomEmail() {   
		Random random = new Random();
	//	String email="automation"+random.nextInt(1000)+"@gmail.com"; 
		String email = "ecomautomate"+System.currentTimeMillis()+"@gmail.com";
		return email;
	}
	
	@DataProvider
	public Object[][] getRegTestDate() {
		Object regDate[][] = ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
		return regDate;
	}
	
	
	@Test(dataProvider = "getRegTestDate")
	public void doRegisterTest(String firstname, String lastname, String email, String telephone, String password, String subscribe) {
	boolean reg = 	regPage.doRegisterEcomPage(firstname, lastname, getRandomEmail(), telephone, password, subscribe);
		Assert.assertEquals(reg, true);	
		
	}   
	
/*	@Test
	public void doRegisterTest() {
	boolean reg = 	regPage.doRegisterEcomPage("Meenakshi", "Kandaswamy", "auto-Test@gmail.com", "2468013579", "Test123+", "yes");
		Assert.assertEquals(reg, true);	
		
	}
*/
}
