package com.thutrang.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.thutrang.automation.base.BaseTest;
import com.thutrang.automation.pages.Inputs;

public class InputTest extends BaseTest{
	
	@Test
	public void testInputRejectText() {
		Inputs input = new Inputs(driver);
		input.goToInputs();
		
		//inputNotEnterText
		input.enterValue("abcxyz");
		Assert.assertTrue(input.getValue().isEmpty());
	}
	
	@Test
	public void testInputAcceptNumber() {
		Inputs input = new Inputs(driver);
		input.goToInputs();
		
		//inputOnlyEnterNumber
		input.enterValue("123456");
		Assert.assertEquals(input.getValue(), "123456");
	}
	
	@Test
	public void testInputException() {
		Inputs input = new Inputs(driver);
		input.goToInputs();
		
		//inputException:"e"
		input.enterValue("1e2");
		Assert.assertEquals(input.getValue(), "1e2");
	}

}
