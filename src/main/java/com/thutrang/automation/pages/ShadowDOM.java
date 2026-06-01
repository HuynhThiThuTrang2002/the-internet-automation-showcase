package com.thutrang.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.thutrang.automation.base.BasePage;

public class ShadowDOM extends BasePage {

	public ShadowDOM(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	By linkShadowDOM = By.cssSelector("a[href*='/shadowdom']");
	By shadowHost = By.cssSelector("my-paragraph:nth-of-type(2)");
	By paragraph = By.cssSelector("p");
	
	public void goToShadowDOM() {
		clickEle(linkShadowDOM);
	}
	
	public String getShadowText() {
		return getShadowElement(shadowHost, paragraph).getText().trim();
	}
	

}
