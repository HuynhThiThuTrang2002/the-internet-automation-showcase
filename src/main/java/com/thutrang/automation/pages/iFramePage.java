package com.thutrang.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.thutrang.automation.base.BasePage;

public class iFramePage extends BasePage {

	public iFramePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	By linkFrames = By.cssSelector("a[href*='/frames']");
	By linkIFrame = By.cssSelector("a[href*='/iframe']");
	By closeWarningBtn = By.cssSelector("div[aria-label='Close']");
	By frameTextArea = By.id("mce_0_ifr");
	By textArea = By.id("tinymce");
	By textContent = By.tagName("p");
	
	public void goToIFrame() {
		clickEle(linkFrames);
		clickEle(linkIFrame);
	}
	
	public void closeWarning() {
		if(!isEmptyEle(closeWarningBtn)) {
			clickEle(closeWarningBtn);
		}
	}
	
	public void switchToTextArea() {
		switchToFrame(frameTextArea);
	}
	
	public boolean isTextAreaEditable() {
		return Boolean.parseBoolean(getAttributeEle(textArea, "contenteditable"));
	}
	
	public String getTextAreaContent() {
		return getTextEle(textContent);
	}

}
