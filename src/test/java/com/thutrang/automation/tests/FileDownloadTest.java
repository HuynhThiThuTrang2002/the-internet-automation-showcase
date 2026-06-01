package com.thutrang.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thutrang.automation.base.BaseTest;
import com.thutrang.automation.pages.FileDownload;

public class FileDownloadTest extends BaseTest {
	@Test
	public void testFileDownload() {
		FileDownload fileDl = new FileDownload(driver);
		fileDl.goToFileDownload();
		fileDl.clickDownloadFile();
		Assert.assertTrue(fileDl.waitForDownloadFile("some-file.txt"));
	}

}
