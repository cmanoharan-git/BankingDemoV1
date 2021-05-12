package com.banking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.banking.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BankingBaseClass {
	
	ReadConfig readconfig = new ReadConfig();

	public String loginUrl = readconfig.getAppURL();
	public String username = readconfig.getUsername();
	
	public String password = "nabEmyp";
	public static WebDriver driver = null;
	public static Logger logger;
	
	@BeforeClass
	@Parameters("browserName")	
	public void setUp(String browserName) {
				
		if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		//There is a conflict in using WebDriverManager with some maven dependancy
		//System.setProperty("webdriver.gecko.driver", "C:\\My Local Docs\\Selenium Jars1\\geckodriver.exe");
			
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		logger = Logger.getLogger("BankingDemoV1");
		PropertyConfigurator.configure("Log4j.properties");	
		
		driver.get(loginUrl);
		logger.info("URL is opened");			
	}
	
	@AfterClass
	public void tearDown() {
		//driver.close();
	}
		
	public void captureScreen(WebDriver driver, String tname) throws IOException {		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
	}
	
	public String genRandomEmailId( ) {		
		String generatedstring1 = RandomStringUtils.randomAlphabetic(8);
		return generatedstring1;
	}

	public static String randomNum() {		
		String generatedString2 = RandomStringUtils.random(4);
		return generatedString2;
	}
	
}

