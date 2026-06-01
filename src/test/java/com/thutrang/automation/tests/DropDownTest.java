package com.thutrang.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thutrang.automation.base.BaseTest;
import com.thutrang.automation.pages.Dropdown;

public class DropDownTest extends BaseTest {
	
	@Test
	public void testSelectedDropdown() {
		Dropdown dropdown = new Dropdown(driver);
		dropdown.goToDropdown();
		
		dropdown.selectByText("Option 1");
		Assert.assertEquals(dropdown.getSelectedOption(), "Option 1");
		
		dropdown.selectByIndex(2);
		Assert.assertEquals(dropdown.getSelectedOption(), "Option 2");
	}

}
