package com.thutrang.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thutrang.automation.base.BaseTest;
import com.thutrang.automation.pages.JavaScriptAlerts;

public class JavaScriptAlertsTest extends BaseTest{
	@Test
	public void JSAlertTest() {
		JavaScriptAlerts javaScriptAlert = new JavaScriptAlerts(driver);
		javaScriptAlert.gotoJavaScriptAlerts();
		
		javaScriptAlert.clickForJSAlert();
		javaScriptAlert.acceptAlert();
		Assert.assertEquals(javaScriptAlert.getResult(), "You successfully clicked an alert");
	}
	
	@Test
	public void JSConfirmCancelTest() {
		JavaScriptAlerts javaScriptAlert = new JavaScriptAlerts(driver);
		javaScriptAlert.gotoJavaScriptAlerts();
		
		javaScriptAlert.clickForJSConfirm();
		javaScriptAlert.dismissAlert();
		Assert.assertEquals(javaScriptAlert.getResult(), "You clicked: Cancel");
	}
	
	@Test
	public void JSConfirmAcceptTest() {
		JavaScriptAlerts javaScriptAlert = new JavaScriptAlerts(driver);
		javaScriptAlert.gotoJavaScriptAlerts();
		
		javaScriptAlert.clickForJSConfirm();
		javaScriptAlert.acceptAlert();
		Assert.assertEquals(javaScriptAlert.getResult(), "You clicked: Ok");
	}
	
	@Test
	public void JSPromptTest() {
		JavaScriptAlerts javaScriptAlert = new JavaScriptAlerts(driver);
		javaScriptAlert.gotoJavaScriptAlerts();
		
		javaScriptAlert.clickForJSPrompt();
		javaScriptAlert.enterAlertText("I am a JS prompt");
		javaScriptAlert.acceptAlert();
		Assert.assertEquals(javaScriptAlert.getResult(), "You entered: I am a JS prompt");
		
		javaScriptAlert.clickForJSPrompt();
		javaScriptAlert.dismissAlert();
		Assert.assertEquals(javaScriptAlert.getResult(), "You entered: null");
	}

}
