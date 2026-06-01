package com.thutrang.automation.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.thutrang.automation.driver.DriverManager;
import com.thutrang.automation.utils.ConfigReader;

public class BaseTest {
	
	public WebDriver driver;
	ConfigReader config = new ConfigReader();
	
//	public WebDriver initDriver() {
//		WebDriverManager.chromedriver().setup();
//		
//		String projectPath = System.getProperty("user.dir");
//		String downloadPath = projectPath + "/downloads";
//		
//		ChromeOptions options = new ChromeOptions();
//		
//		options.addArguments("--disable-infobars");
//		options.addArguments("--disable-notifications");
//		options.addArguments("--incognito");
//		
//		Map<String, Object> prefs = new HashMap<>();
//		
//		prefs.put("download.default_directory", downloadPath);
//		
//		prefs.put("download.prompt_for_download", false);
//		
//		options.setExperimentalOption("prefs", prefs);
//		
//		driver = new ChromeDriver(options);
//		
//		driver.manage().window().maximize();
//		
//		return driver;
//	}
	
	@BeforeMethod
	public void setUp() {
		driver = DriverManager.getDriver(config.get("browser"));
		driver.get(config.get("url"));
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public String getScreenshot(String testcaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testcaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testcaseName + ".png";
	}

}
