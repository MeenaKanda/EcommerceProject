package com.qa.ecommerce.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.openqa.selenium.net.PortProber;

import java.util.Properties;

import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.ecommerce.exception.FrameworkException;
import com.qa.ecommerce.utils.ElementUtil;



public class DriverFactory {
	
	public WebDriver driver;
	ElementUtil eleUtil;
	public Properties prop; 
	public OptionsManager optionManager;
	public static String highlight;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public WebDriver initDriver(Properties prop) {
		optionManager= new OptionsManager(prop);
		highlight = prop.getProperty("highlight").trim();
		
		String browserName = prop.getProperty("browser").toLowerCase().trim();
//		String browserName = System.getProperty("browser");  //pass browser from maven command line
		System.out.println("Browser name ::::" + browserName);
		
		//chrome:
				if(browserName.equalsIgnoreCase("chrome")) {
					if(Boolean.parseBoolean(prop.getProperty("remote"))) {
						//run on remote/grid:
						init_remoteDriver("chrome");
					}
					else {
						tlDriver.set(new ChromeDriver(optionManager.getChromeOption()));  //initialize with new chromeDriver
					}
				    }
				
				//firefox:
					else if(browserName.equalsIgnoreCase("firefox")) {
					    if(Boolean.parseBoolean(prop.getProperty("remote"))) {
					    	//run on remote/grid:
					    	System.out.println("INSIDE Init Remote Driver"); 
					    	init_remoteDriver("firefox");
					    }
					    else {
						tlDriver.set(new FirefoxDriver(optionManager.getFirefoxOption()));  //here driver is thread local driver.
					}
					}
					
				
				//edge:
					else if(browserName.equalsIgnoreCase("edge")) {
						if(Boolean.parseBoolean(prop.getProperty("remote"))) {
							//run on remote/grid:
							init_remoteDriver("edge");
						}
						else {
						tlDriver.set(new EdgeDriver(optionManager.getEdgeOption()));
						}
					}
				
				//safari:	
					else if(browserName.equalsIgnoreCase("safari")) {  
						tlDriver.set(new SafariDriver());
					}
				
					else {
						System.out.println("plz pass the right browser name ...... " + browserName);
						throw new FrameworkException("NO BROWSER FOUND EXCEPTION...");
					}
					
				
		
/*		if(browserName.equalsIgnoreCase("chrome")) {
		//	 driver = new ChromeDriver(optionManager.getChromeOption());
		tlDriver.set(new ChromeDriver(optionManager.getChromeOption()));	 
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
		//	driver = new FirefoxDriver(optionManager.getFirefoxOption());
			tlDriver.set(new FirefoxDriver(optionManager.getFirefoxOption()));
		}
		else if (browserName.equalsIgnoreCase("edge")) {
		//	driver = new EdgeDriver(optionManager.getEdgeOption());
			tlDriver.set(new EdgeDriver(optionManager.getEdgeOption()));
		}
		
		else {
			System.out.println("Please pass valid browser name ");
			throw new FrameworkException("NO BROWSER FOUND EXCEPTION...");
		}
		*/
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
//		getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
//		getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		getDriver().get(prop.getProperty("url"));
		return getDriver();
		

		
	}
	
	/**
	 * get the local thread copy of the driver
	 * @return 
	 */
	public synchronized static WebDriver getDriver() { //synchronized-> so every thread get their own individual copy. so no deadlock condition.
		return tlDriver.get();
	}
	
	
	/**
	 * this method is reading the properties from the .properties file
	 * @return
	 */
	
     public Properties initProp() {
		
		prop = new Properties();
	 	FileInputStream ip = null;
		
		String envName = System.getProperty("env");  //read the environment variable with the help of System class  //this env we can pass from command line terminal mvn clean install -Denv ="stage" //or send env from ecllpse
		System.out.println("Running test cases on Env: " + envName);
		
		try {
		if(envName == null) {
			System.out.println("no env is passed..... Running tests on QA env....");
			ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
		}
		
		else {
			switch (envName.toLowerCase().trim()) {
			case "qa":
			ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
				break;
			case "stage":
		    ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
				break;
			case "dev":
			ip = new FileInputStream("./src/test/resources/config/dev.config.properties");
				break;
			case "prod":
			ip = new FileInputStream("./src/test/resources/config/config.properties");
				break;
			default:
			{
				System.out.println("....Wrong env is passed ....No need to run the test cases....");
				throw new FrameworkException("WRONG ENV IS PASSED");
			//	break; //
			}
			}
		}
		}
		catch (FileNotFoundException e) {
			
		}
		
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
     
     
     /**
 	 * this method is called internally to initialize the driver with
 	 * RemoteWebDriver
 	 * 
 	 * @param browser
 	 */
 	
 	
	private void init_remoteDriver(String browser) {
 		System.out.println("Running tests on grid server::::" + browser);
 		try {
 		switch (browser.toLowerCase()) {
 		case "chrome":
			try {
				tlDriver.set(
 					new RemoteWebDriver(new URI(prop.getProperty("huburl")).toURL(), optionManager.getChromeOption()));
				
					} catch (URISyntaxException e) {
				e.printStackTrace();
			}
 				
 				break;
 		case "firefox":
 			try {
 				System.out.println("INSIDE firefox driver factory88888888888");
				tlDriver.set(	
						new RemoteWebDriver(new URI(prop.getProperty("huburl")).toURL(), optionManager.getFirefoxOption()));
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
 			break;
 		case "edge":
 			try {
				tlDriver.set(
						new RemoteWebDriver(new URI(prop.getProperty("huburl")).toURL(), optionManager.getEdgeOption()));
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
 			break;
 		default:
 			System.out.println("Plz pass the right browser for remote execution..." + browser);
 			throw new FrameworkException("NOREMOTEBROGWSEREXCEPTION");
 		}
 		
 	} catch (MalformedURLException e) {
 		e.printStackTrace();
 	}
}

 	

     
     
     
     
     
	
	   /**
		 * take screeshot
		 * @return 
		 */
		
		public static String getScreenshot() {
		File srcFile	= ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);  //covert driver into TakeScreenshot Interface.
		String path = System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";  //this is string path ,not a file
		File destination = new File(path);  //create a file and add path into file
		try {
//			FileHandler.copy(srcFile, destination);
			FileUtil.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
		
		
		}
		
		
		  @SuppressWarnings("deprecation")
		protected URL startStandaloneGrid() {
			    
			    try {
			      return new URL("http://localhost:4444/wd/hub");
			    } catch (Exception e) {
			      throw new RuntimeException(e);
			    }
			  }
		
}
