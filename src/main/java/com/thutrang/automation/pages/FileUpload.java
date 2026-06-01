package com.thutrang.automation.pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.thutrang.automation.base.BasePage;

public class FileUpload extends BasePage{

	public FileUpload(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	By linkfileUpload = By.cssSelector("a[href*='/upload']");
	By chooseFileBtn = By.id("file-upload");
	By uploadBtn = By.id("file-submit");
	By nameFile = By.id("uploaded-files");
	
	public void goToFileUpload() {
		clickEle(linkfileUpload);
	}
	
	public void uploadFile(String name) {
		String projectPath = System.getProperty("user.dir");
		
		String filePath = projectPath + File.separator
				+ "test-data"
				+ File.separator
				+ name;
		
		sendKeyEle(chooseFileBtn, filePath);
	}
	
	public void clickUploadFileButton() {
		clickEle(uploadBtn);
	}
	
	public String getUploadFileName() {
		return getTextEle(nameFile);
	}
}
