package com.thutrang.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thutrang.automation.base.BaseTest;
import com.thutrang.automation.pages.iFramePage;

public class IFrameTest extends BaseTest {
	@Test
	public void testTextAreaOnlyRead() {
		iFramePage iF = new iFramePage(driver);
		iF.goToIFrame();
		iF.closeWarning();
		iF.switchToTextArea();
		Assert.assertFalse(iF.isTextAreaEditable());
		iF.switchToDefault();
	}
	
	@Test
	public void testTextAreaContentInReadOnlyMode() {
		iFramePage iF = new iFramePage(driver);
		iF.goToIFrame();
		iF.closeWarning();
		iF.switchToTextArea();
		Assert.assertEquals(iF.getTextAreaContent(), "Your content goes here.");
		iF.switchToDefault();
	}

}
