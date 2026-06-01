package com.thutrang.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.thutrang.automation.base.BasePage;

public class Inputs extends BasePage {

	public Inputs(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	By linkInputs = By.cssSelector("a[href*='/inputs']");
	By inputEle = By.cssSelector("input[type*='number']");
	
	public void goToInputs() {
		clickEle(linkInputs);
	}
	
	public void enterValue(String value) {
		clearEle(inputEle);
		sendKeyEle(inputEle, value); 
	}
	
	public String getValue() {
		return waitForElementVisible(inputEle).getAttribute("value");
	}
}
