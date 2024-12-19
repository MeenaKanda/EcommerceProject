package com.qa.ecommerce.tests;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.ecommerce.base.BaseTest;
import com.qa.ecommerce.constants.AppConstants;


public class EcomProductInfoPageTest extends BaseTest {
	
	@BeforeClass
	public void doSelectProductInfoTest() {
//		accPage = loginPage.doLogin("auto_Test@gmail.com", "Test123+");
//		searchPage= accPage.performSearch("Macbook");
//		proInfoPage = searchPage.doSelectProduct("Macbook Air");
		
		accPage = loginPage.doLogin("auto_Test@gmail.com", "Test123+");
	}
	
/*	@Test
	public void productHeaderTest() {
		String actHeader = proInfoPage.getProductHeader();
		Assert.assertEquals(actHeader, AppConstants.PRODUCT_INFO_PAGE_HEADER_VALUE);
	}
	
	@Test
	public void productImageCountTest() {
		int actCount = proInfoPage.getProductImageCount();
		Assert.assertEquals(actCount, 4);
		
	}*/
	
	 @DataProvider
	    public Object[][] getProductImagesTestData() {
	    	return new Object[][] {
	    		{"Macbook", "MacBook Pro", 4},
	    		{"iMac", "iMac",3},
	    		{"Apple", "Apple Cinema 30\"", 6},
	    		{"Samsung", "Samsung SyncMaster 941BW", 1},
	    		};
	    }
	
	 @Test(dataProvider = "getProductImagesTestData")
	 public void productImagesCountTest(String searchKey, String productName, int imagesCount) {
		searchPage =  accPage.performSearch(searchKey);
		proInfoPage = searchPage.doSelectProduct(productName);
		int actImagesCount = proInfoPage.getProductImageCount();
		Assert.assertEquals(actImagesCount, imagesCount);
	 }
	 
	 @DataProvider
	 public Object[][] getProductDescriptionTestData() {
	    	return new Object[][] {
	    		{"Macbook", "MacBook Pro", 10}
	    	};
	 }
	
	 @Test(dataProvider = "getProductDescriptionTestData")
	 public void descriptionCountTest(String searchKey, String productName, int descriptionCount) {
		 searchPage = accPage.performSearch(searchKey);
		 proInfoPage = searchPage.doSelectProduct(productName);
		 int actDesCount = proInfoPage.getDescriptionCount();
		 Assert.assertEquals(actDesCount, descriptionCount);
	 }

	 @DataProvider
	 public Object[][] getProductTestData(){
		return new Object[][]{
				 {"MacBook", "MacBook Pro"},
				 {"MacBook", "MacBook Air"},
				 {"Samsung", "Samsung Galaxy Tab 10.1"},
				 {"Samsung", "Samsung SyncMaster 941BW"},
				 {"iMac", "iMac"},
				 {"phone", "iPhone"}
	 };
	 }
	 
	 @Test(dataProvider = "getProductTestData")
	 public void addToCartTest(String searchKey, String productName) {
		 searchPage = accPage.performSearch(searchKey);
		 proInfoPage = searchPage.doSelectProduct(productName);
		 proInfoPage.enterProductQuantity(2);
		 String actCartMesg =  proInfoPage.addProductToCart();
		 //Success: You have added MacBook Pro to your shopping cart!
	//	 softAssert.assertTrue(actCartMesg.contains("Success"));
	//	 softAssert.assertTrue(actCartMesg.contains(productName));
		 softAssert.assertTrue(actCartMesg.indexOf("Success")>=0);
		 softAssert.assertTrue(actCartMesg.indexOf(productName)>=0);
		 
		 softAssert.assertEquals(actCartMesg,"Success: You have added " + productName + " to your shopping cart!");
		 softAssert.assertAll(); 
}
	 
	 @Test
	 public void productInfoTest() {
		 searchPage = accPage.performSearch("MacBook");
         proInfoPage = searchPage.doSelectProduct("MacBook Pro");
		 Map<String, String> actProductInfoMap = proInfoPage.getProductInfo();
		 softAssert.assertEquals(actProductInfoMap.get("Brand"), "Apple");
		 softAssert.assertEquals(actProductInfoMap.get("Product Code"), "Product 18");
		 softAssert.assertEquals(actProductInfoMap.get("productName"), "MacBook Pro");
		 softAssert.assertEquals(actProductInfoMap.get("productprice"), "$2,000.00");
		 
		 softAssert.assertAll();
	 }
	 
	 @Test(priority = 1)
	 public void selectShoppingCartTest() {
	////	 accPage = loginPage.doLogin("auto_Test@gmail.com", "Test123+");
	//	searchPage= accPage.performSearch("Macbook");
	//	proInfoPage = searchPage.doSelectProduct("Macbook Pro");
		checkoutPage = proInfoPage.doSelectShoppingCart();
		 
	 }
	 
	 @Test(priority =2)
	 public void checkOutTitleTest() {
		String actTitle = checkoutPage.getCheckOutTitle();
		Assert.assertTrue(actTitle.contains(AppConstants.CHECKOUT_PAGE_TITLE_VALUE));
	 }
	 
	 @Test(priority =3)
	 public void checkOutUrlTest() {
		 String actUrl = checkoutPage.getCheckOutUrl();
		 Assert.assertTrue(actUrl.contains(AppConstants.CHECKOUT_PAGE_URL_FRACTION));
	 }
	
	 
	 @Test(priority =4)
	 public void shoppingCartTableHeaderCountTest() {
		 int actCount = checkoutPage.getShoppingCartTableHeaderCount();
		 Assert.assertEquals(actCount, AppConstants.CHECKOUT_PAGE_HEADER_COUNT);
	 }
	 
	 @Test(priority =5)
	 public void shoppingCartTableHeaderValueTest() {
		 List<String> actList = checkoutPage.getShoppingCartTableHeaderText();
		 Assert.assertEquals(actList, AppConstants.CHECKOUT_PAGE_HEADER_LIST_VALUE);
	 }
	 
	 
}