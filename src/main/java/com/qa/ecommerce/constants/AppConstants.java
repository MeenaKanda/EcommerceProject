package com.qa.ecommerce.constants;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AppConstants {

	
	public static final int DEFAULT_MEDIUM_TIME_OUT = 10;
	public static final int DEFAULT_SHORT_TIME_OUT = 5;
	public static final int DEFAULT_LONG_TIME_OUT = 20;
	
	public static final String LOGIN_PAGE_TITLE_VALUE = "Account Login";
	public static final String LOGIN_PAGE_URL_FRACTION = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";
	
	public static final String ACCOUNTS_PAGE_TITLE_VALUE = "My Account";
	public static final String ACCOUNTS_PAGE_URL_FRACTION = "route=account/account";
	
	public static final String HOME_PAGE_TITLE_VALUE = "Your Store";
	public static final String HOME_PAGE_URL_FRACTION = "route=common/home";
	
	public static final String HOME_PAGE_REGISTER = "Register";
	public static final String[] HOME_PAGE_CURRENCY_LIST = {"€ Euro","£ Pound Sterling","$ US Dollar"};
	public static final String LOGIN_PAGE_SRC_VALUE = "https://naveenautomationlabs.com/opencart/image/catalog/opencart-logo.png";
	
	public static final List<String> EXPECTED_ACCOUNTS_PAGE_HEADERS_LIST = Arrays.asList("My Account" , "My Orders", 
                                                                                             "My Affiliate Account", "Newsletter");
    public static final String USER_REG_SUCCESS_MESSG = "Your Account Has Been Created";
	public static final String ACCOUNTS_PAGE_ADMIN_VALUE = "Powered By OpenCart naveenopencart © 2024";
	public static final int ACCOUNTS_PAGE_FOOTER_COUNTS = 15;
	public static final int ACCOUNT_PAGE_NAVBAR_COUNTS = 13;
	public static final List<String> ACCOUNTS_PAGE_NAV_LIST =Arrays.asList("My Account", "Edit Account", "Password", "Address Book", "Wish List", "Order History", "Downloads", "Recurring payments", "Reward Points", "Returns", "Transactions", "Newsletter", "Logout");
	public static final int SEARCH_PAGE_DROPDOWN_COUNT = 5;
	public static final String PRODUCT_INFO_PAGE_HEADER_VALUE = "MacBook Air";
	public static final String CHECKOUT_PAGE_URL_FRACTION = "route=checkout/cart";
	public static final String CHECKOUT_PAGE_TITLE_VALUE = "Shopping Cart";
	public static final int CHECKOUT_PAGE_HEADER_COUNT = 6;
	public static final List<String> CHECKOUT_PAGE_HEADER_LIST_VALUE = Arrays.asList("Image","Product Name","Model","Quantity","Unit Price","Total");
	public static final String REGISTER_SHEET_NAME = "register";
	
			
	
	
	
	
	
			
	
	
	
}
