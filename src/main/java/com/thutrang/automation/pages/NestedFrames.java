package com.thutrang.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.thutrang.automation.base.BasePage;

public class NestedFrames extends BasePage {

	public NestedFrames(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	By linkFrames = By.cssSelector("a[href*='/frames']");
	By linkNestedFrames = By.cssSelector("a[href*='/nested_frames']");
	By frameTop = By.cssSelector("frame[name='frame-top']");
	By frameLeft = By.cssSelector("frame[name='frame-left']");
	By frameMiddle = By.cssSelector("frame[name='frame-middle']");
	By frameRight = By.cssSelector("frame[name='frame-right']");
	By content = By.tagName("body");
	By frameBottom = By.cssSelector("frame[name='frame-bottom']");
	
	public void goToFrames() {
		clickEle(linkFrames);
	}
	
	public void goToNestedFrames() {
		clickEle(linkNestedFrames);
	}
	
	public void switchToLeftFrame() {
		switchToFrame(frameTop);
		switchToFrame(frameLeft);
	}
	
	public void switchToMiddleFrame() {
		switchToParentFrame();
		switchToFrame(frameMiddle);
	}
	
	public void switchToRightFrame() {
		switchToParentFrame();
		switchToFrame(frameRight);
	}
	
	public void switchToBottomFrame() {
		switchToDefault();
		switchToFrame(frameBottom);
	}
	
	public String getContent() {
		return getTextEle(content);
	}

}
