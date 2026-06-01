package com.thutrang.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thutrang.automation.base.BaseTest;
import com.thutrang.automation.pages.ShadowDOM;

public class ShadowDOMTest extends BaseTest {
	@Test
	public void testShadowDOM() {
		ShadowDOM shadow = new ShadowDOM(driver);
		shadow.goToShadowDOM();
		
		Assert.assertTrue(shadow.getShadowText().contains("Let's have some different text!"));
	}

}
