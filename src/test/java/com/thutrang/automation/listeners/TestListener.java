package com.thutrang.automation.listeners;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.thutrang.automation.base.BaseTest;
import com.thutrang.automation.resources.ExtentReporterNG;

//public class TestListener implements ITestListener {
//    
//	@Override
//	public void onTestFailure(ITestResult result) {
//		System.out.println("Test FAILED: " + result.getName());
//		
//		Object currentClass = result.getInstance();
//		WebDriver driver = ((BaseTest) currentClass).getDriver();
//		
//		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		
//		try {
//			FileUtils.copyFile(src, new File("screenshots/" + result.getName() + ".png"));
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Override
//	public void onTestSuccess(ITestResult result) {
//		System.out.println("Test PASSED " + result.getName());
//	}
//
//}

public class TestListener extends BaseTest implements ITestListener {
	
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //Thread safe
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); //unique thread id(errorvalidationTest)->test
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}


