package com.thutrang.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thutrang.automation.base.BaseTest;
import com.thutrang.automation.pages.DynamicLoading;

public class DynamicLoadingTest extends BaseTest {
	@Test
	public void testElementHidden() {
		DynamicLoading dynamicLoading = new DynamicLoading(driver);
		dynamicLoading.goToDynamicLoading();
		dynamicLoading.gotoExample1();
		dynamicLoading.clickStart();
		Assert.assertEquals(dynamicLoading.getText(), "Hello World!");
	}
	
	@Test
	public void testElementRendered() {
		DynamicLoading dynamicLoading = new DynamicLoading(driver);
		dynamicLoading.goToDynamicLoading();
		dynamicLoading.gotoExample2();
		dynamicLoading.clickStart();
		Assert.assertEquals(dynamicLoading.getText(), "Hello World!");
	}

}
