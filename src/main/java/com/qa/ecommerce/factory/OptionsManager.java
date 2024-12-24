package com.qa.ecommerce.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	private WebDriver driver;
	private Properties prop;
	
	public OptionsManager(Properties prop) {
		this.prop = prop;
	}
	
	@SuppressWarnings("serial")
	public ChromeOptions getChromeOption() 
	{
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		System.out.println("**********Running ChromeOOPtions ***********");
		
		/* *************************************** */
//		if(Boolean.parseBoolean(prop.getProperty("remote"))) 
//		{
//			co.setCapability("browserVersion", prop.getProperty("browserversion"));
//			co.setCapability("selenoid:options", new HashMap<String, Object>() {
//				{
//			        /* How to set session timeout */
//			        //put("enableVideo", true);
//			        put("enableVNC", true);

//			}});
			
//		}
	
		if (Boolean.parseBoolean(prop.getProperty("remote"))) {
			co.setCapability("browserName", "chrome");
			co.setBrowserVersion(prop.getProperty("browserversion").trim());

			Map<String, Object> selenoidOptions = new HashMap<>();
			selenoidOptions.put("screenResolution", "1280x1024x24");
			selenoidOptions.put("enableVNC", true);
			selenoidOptions.put("name", prop.getProperty("testcasename"));
			co.setCapability("selenoid:options", selenoidOptions);
		}

	
	
    
	if(Boolean.parseBoolean(prop.getProperty("headless"))) co.addArguments("--headless");
	if(Boolean.parseBoolean(prop.getProperty("incognito"))) co.addArguments("--incognito");

    return co;
		}	
		
		/* *************************************** */
		/* if(Boolean.parseBoolean(prop.getProperty("remote"))) {
			co.setBrowserVersion(prop.getProperty("browserversion"));
			co.setCapability("browser", "chrome");
			co.setCapability("enableVNC",true);
			System.out.println("*********end of chromeOptions********");
		
		if(Boolean.parseBoolean(prop.getProperty("headless"))) co.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) co.addArguments("--incognito");
		return co;		
		} */

	
	
	@SuppressWarnings("serial")
	public FirefoxOptions getFirefoxOption() {
		FirefoxOptions fo = new FirefoxOptions();
		
	/*	if(Boolean.parseBoolean(prop.getProperty("remote"))){
		
	//			fo.setCapability("browserVersion", prop.getProperty("browserversion"));
	//			fo.setCapability("selenoid:options", new HashMap<String, Object>() {
	//				{
	//			        /* How to set session timeout */
	//			        //put("enableVideo", true);
	//			        put("enableVNC", true);

	//			}});
				
	//		}
			
			
			
			/*		fo.setBrowserVersion(prop.getProperty("browserversion"));
			fo.setCapability("browser", "firefox");
			fo.setCapability("enableVNC", true);
			*/
		
		if (Boolean.parseBoolean(prop.getProperty("remote"))) {
			fo.setCapability("browserName", "firefox");
			fo.setBrowserVersion(prop.getProperty("browserversion").trim());

			Map<String, Object> selenoidOptions = new HashMap<>();
			selenoidOptions.put("screenResolution", "1280x1024x24");
			selenoidOptions.put("enableVNC", true);
			selenoidOptions.put("name", prop.getProperty("testcasename"));
			fo.setCapability("selenoid:options", selenoidOptions);
		}
		
		if(Boolean.parseBoolean(prop.getProperty("headless"))) fo.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) fo.addArguments("--incognito");
		return fo;		
	}

	public EdgeOptions getEdgeOption() {
		EdgeOptions eo = new EdgeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) eo.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) eo.addArguments("--incognito");
		return eo;		
	}
}

