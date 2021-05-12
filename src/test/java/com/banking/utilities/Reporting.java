package com.banking.utilities;

//Listener class used to generate extent reports

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.banking.testCases.BankingBaseClass;

public class Reporting extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
		
	public void onStart(ITestContext testContext) {
		
		String timeStamp = new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-"+timeStamp+".html";
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		htmlReporter.loadConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("Tester","Manoharan");
		
		htmlReporter.config().setDocumentTitle("BankingDemoV1 Test Project"); // Tile of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	public void onTestSuccess(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));			
	}
		
	public void onTestFailure(ITestResult tr) {
		
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));		
		String screenshotPath = System.getProperty("user.dir")+"\\screenshots\\"+tr.getName()+".png";
	
		File f = new File(screenshotPath);
		if(f.exists())	
			try {
				logger.fail("Screenshot is below: "+logger.addScreenCaptureFromPath(screenshotPath));				
			} catch (IOException e) {				
				e.printStackTrace();
			}
				
		//Alternative way for SS
		//This will capture ss here itself and store it in the same screenshots folder
		/*File screenshotfile = ((TakesScreenshot) BankingBaseClass.driver).getScreenshotAs(OutputType.FILE);		
		if(screenshotfile.exists())	
			try {
				logger.fail("Screenshot captured");
				FileUtils.copyFile(screenshotfile, new File(screenshotPath));
			} catch (IOException e) {				
				e.printStackTrace();
			}
		 */		
	}
	
	public void onTestSkipper(ITestResult tr) {		
		logger = extent.createTest((tr.getName()));
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));		
	}
	
	public void onFinish(ITestContext testContext) {
		extent.flush();		
	}
		
}
