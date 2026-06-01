package com.thutrang.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.thutrang.automation.base.BasePage;

public class DynamicControls extends BasePage {

	public DynamicControls(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	By linkDynamicControls = By.cssSelector("a[href*='/dynamic_controls']");
	By checkbox = By.id("checkbox");
	By swapCheckboxBtn = By.cssSelector("button[onclick='swapCheckbox()']");
	By messageCheckbox = By.id("message");
	By inputText = By.cssSelector("input[type='text']");
	By swapInputBtn = By.cssSelector("button[onclick='swapInput()']");
	
	public void goToDynamicControls() {
		clickEle(linkDynamicControls);
	}
	
	public boolean isCheckboxDisplayed() {
		return !driver.findElements(checkbox).isEmpty()
				&& driver.findElement(checkbox).isDisplayed();
	}
	
	public void clickSwapCheckbox() {
		clickEle(swapCheckboxBtn);
	}
	
	public void waitCheckboxDisappear() {
		waitForElementInvisible(checkbox);
	}
	
	public String getMessage() {
		return getTextEle(messageCheckbox);
	}
	
	public boolean isTextInputEnable() {
		return isInputEnable(inputText);
	}
	
	public void clickSwapInput() {
		clickEle(swapInputBtn);
	}
	
	public void waitInputEnable() {
		waitForElementEnabled(inputText);
	}
	
}
