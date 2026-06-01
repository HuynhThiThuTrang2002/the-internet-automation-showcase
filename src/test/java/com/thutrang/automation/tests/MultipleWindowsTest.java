package com.thutrang.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thutrang.automation.base.BaseTest;
import com.thutrang.automation.pages.MultipleWindows;

public class MultipleWindowsTest extends BaseTest {
	@Test
	public void testNewWindow() {
		MultipleWindows mtp = new MultipleWindows(driver);
		mtp.goToMultipleWindow();
		mtp.transferToNewWindow();
		mtp.switchToWindowByTitle("New Window");
		Assert.assertEquals(mtp.getMessage(), "New Window");
	}

}
