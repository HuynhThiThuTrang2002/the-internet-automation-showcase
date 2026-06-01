package com.thutrang.automation.pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.thutrang.automation.base.BasePage;

public class FileDownload extends BasePage {

	public FileDownload(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	By linkFileDownload = By.cssSelector("a[href*='/download']");
	By downloadFile = By.linkText("some-file.txt");
	
	public void goToFileDownload() {
		clickEle(linkFileDownload);
	}
	
	public void clickDownloadFile() {
		clickEle(downloadFile);
	}
	
	public boolean waitForDownloadFile(String fileName) {
		String downloadPath = System.getProperty("user.dir") + "/downloads/";
		
		File file = new File(downloadPath + fileName);
		
		int timeout = 10;
		
		while(timeout > 0) {
			if(file.exists()) {
				return true;
			}
			
			try{
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			timeout--;
		}
		return false;
	}
	
//	public boolean isFileDownloaded(String fileName) {
//		String downloadPath = System.getProperty("user.dir") + "/downloads/";
//		
//		File folder = new File(downloadPath);
//		
//		File [] files = folder.listFiles();
//		
//		if(files != null) {
//			for(File file : files) {
//				if(file.getName().contains(fileName)) {
//					return true;
//				}
//			}
//		}
//		
//		return false;
//	}

}
