package com.thutrang.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thutrang.automation.base.BaseTest;
import com.thutrang.automation.pages.DynamicControls;

public class DynamicControlsTest extends BaseTest {
	@Test
	public void testRemoveCheckbox() {
		DynamicControls dynamicControls = new DynamicControls(driver);
		dynamicControls.goToDynamicControls();
		Assert.assertTrue(dynamicControls.isCheckboxDisplayed());
		dynamicControls.clickSwapCheckbox();
		Assert.assertEquals(dynamicControls.getMessage(), "It's gone!");
		Assert.assertFalse(dynamicControls.isCheckboxDisplayed());
	}
	
	@Test
	public void testAddCheckbox() {
		DynamicControls dynamicControls = new DynamicControls(driver);
		dynamicControls.goToDynamicControls();
		Assert.assertTrue(dynamicControls.isCheckboxDisplayed());
		dynamicControls.clickSwapCheckbox();
		dynamicControls.waitCheckboxDisappear();
		Assert.assertFalse(dynamicControls.isCheckboxDisplayed());
		dynamicControls.clickSwapCheckbox();
		Assert.assertEquals(dynamicControls.getMessage(), "It's back!");
		Assert.assertTrue(dynamicControls.isCheckboxDisplayed());
		
	}
	
	@Test
	public void testInputEnable() {
		DynamicControls dynamicControls = new DynamicControls(driver);
		dynamicControls.goToDynamicControls();
		Assert.assertFalse(dynamicControls.isTextInputEnable());
		dynamicControls.clickSwapInput();
		Assert.assertEquals(dynamicControls.getMessage(), "It's enabled!");
		Assert.assertTrue(dynamicControls.isTextInputEnable());
	}
	
	@Test
	public void testInputDisable() {
		DynamicControls dynamicControls = new DynamicControls(driver);
		dynamicControls.goToDynamicControls();
		Assert.assertFalse(dynamicControls.isTextInputEnable());
		dynamicControls.clickSwapInput();
		dynamicControls.waitInputEnable();
		Assert.assertTrue(dynamicControls.isTextInputEnable());
		dynamicControls.clickSwapInput();
		Assert.assertEquals(dynamicControls.getMessage(), "It's disabled!");
		Assert.assertFalse(dynamicControls.isTextInputEnable());
	}

}
