package com.thutrang.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.thutrang.automation.base.BasePage;

public class FormAuthentication extends BasePage {

	public FormAuthentication(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	By linkFormAuthentication = By.cssSelector("a[href*='/login']");
	By usernameEle = By.id("username");
	By passwordEle = By.id("password");
	By submit = By.cssSelector(".radius");
	By message = By.id("flash");
	By logoutBtn = By.cssSelector(".button");
	
	public void goToFormAuthentication() {
		clickEle(linkFormAuthentication);
	}
	
	public void returnFormAuthentication() {
		clickEle(logoutBtn);
	}
	
	public void login(String username, String password) {
		 clearEle(usernameEle);
		 sendKeyEle(usernameEle, username);
		 
		 clearEle(passwordEle);
		 sendKeyEle(passwordEle, password);
		 
		 clickEle(submit);
	}
	
	public String getMessageNoti() {
		return getTextEle(message).trim();
	}
	
	public void logout() {
		clickEle(logoutBtn);
	}
}
