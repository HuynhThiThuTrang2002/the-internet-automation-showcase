package com.thutrang.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thutrang.automation.base.BaseTest;
import com.thutrang.automation.pages.FormAuthentication;

public class FormAuthenticationTest extends BaseTest {
	
	@Test
	public void testLoginSuccess() {
		FormAuthentication form = new FormAuthentication(driver);
		form.goToFormAuthentication();
		
		form.login("tomsmith", "SuperSecretPassword!");
		Assert.assertTrue(form.getMessageNoti().contains("You logged into a secure area!"));
	}
	
	@Test
	public void testLoginFailUsername() {
		FormAuthentication form = new FormAuthentication(driver);
		form.goToFormAuthentication();
		
		form.login("wrongUser", "SuperSecretPassword!");
		Assert.assertTrue(form.getMessageNoti().contains("Your username is invalid!"));
	}
	
	@Test
	public void testLoginFailPassword() {
		FormAuthentication form = new FormAuthentication(driver);
		form.goToFormAuthentication();
		
		form.login("tomsmith", "wrongPass");
		Assert.assertTrue(form.getMessageNoti().contains("Your password is invalid!"));
	}

}
