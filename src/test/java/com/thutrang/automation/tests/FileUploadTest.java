package com.thutrang.automation.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.thutrang.automation.base.BaseTest;
import com.thutrang.automation.pages.FileUpload;

public class FileUploadTest extends BaseTest{
	@Test(dataProvider="getData")
	public void testUploadFile(String nameFile) {
		FileUpload fileUpload = new FileUpload(driver);
		fileUpload.goToFileUpload();
		fileUpload.uploadFile(nameFile);
		fileUpload.clickUploadFileButton();
		Assert.assertEquals(fileUpload.getUploadFileName(), nameFile);
	}
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][] {
			{"image3.png"},
			{"image4.png"}
		};
	}

}
