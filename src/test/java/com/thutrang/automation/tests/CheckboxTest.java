package com.thutrang.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thutrang.automation.base.BaseTest;
import com.thutrang.automation.pages.Checkboxes;

public class CheckboxTest extends BaseTest {
	@Test
	public void testCheckbox() {
		Checkboxes checkbox = new Checkboxes(driver);
		checkbox.goToCheckboxes();
		//checkbox1
		checkbox.setCheckboxByIndex(0, true);
		Assert.assertTrue(checkbox.isCheckboxSelectedByIndex(0));
		//checkbox2
		checkbox.setCheckboxByIndex(1, false);
		Assert.assertFalse(checkbox.isCheckboxSelectedByIndex(1));
	}

}
