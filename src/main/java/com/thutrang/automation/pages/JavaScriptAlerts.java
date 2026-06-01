package com.thutrang.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.thutrang.automation.base.BasePage;

public class JavaScriptAlerts extends BasePage{
	
	public JavaScriptAlerts(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	By linkJavaScriptAlert = By.cssSelector("a[href*='/javascript_alerts']");
	By clickForJSAlertBtn = By.cssSelector("button[onclick*='jsAlert()']");
	By clickForJSConfirmBtn = By.cssSelector("button[onclick*='jsConfirm()']");
	By clickForJSPromptBtn = By.cssSelector("button[onclick*='jsPrompt()']");
	By result = By.id("result");
	
	public void gotoJavaScriptAlerts() {
		clickEle(linkJavaScriptAlert);
	}
	
	public void clickForJSAlert() {
		clickEle(clickForJSAlertBtn);
	}
	
	public void clickForJSConfirm() {
		clickEle(clickForJSConfirmBtn);
	}
	
	public void clickForJSPrompt() {
		clickEle(clickForJSPromptBtn);
	}
	
	public String getResult() {
		return getTextEle(result);
	}
}
