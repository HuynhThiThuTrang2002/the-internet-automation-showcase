package com.thutrang.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.thutrang.automation.base.BasePage;

public class MultipleWindows extends BasePage {

	public MultipleWindows(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	By linkMultiple = By.cssSelector("a[href*='/windows']");
	By clickHere = By.cssSelector("a[target='_blank']");
	By textMessage = By.tagName("h3");
	
	public void goToMultipleWindow() {
		clickEle(linkMultiple);
	}
	
	public void transferToNewWindow() {
		clickEle(clickHere);
	}
	
	public String getMessage() {
		return getTextEle(textMessage);
	}

}
