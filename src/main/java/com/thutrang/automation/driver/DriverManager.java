package com.thutrang.automation.driver;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	public static WebDriver getDriver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			
			String projectPath = System.getProperty("user.dir");
			String downloadPath = projectPath + "/downloads";
			
			ChromeOptions options = new ChromeOptions();
			
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-notifications");
			options.addArguments("--incognito");
			
			Map<String, Object> prefs = new HashMap<>();
			
			prefs.put("download.default_directory", downloadPath);
			
			prefs.put("download.prompt_for_download", false);
			
			options.setExperimentalOption("prefs", prefs);
			
			return new ChromeDriver(options);
	    }

	    throw new RuntimeException("Browser not supported");
	}

}
