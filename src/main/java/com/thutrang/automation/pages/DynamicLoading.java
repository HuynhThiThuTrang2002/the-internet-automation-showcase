package com.thutrang.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.thutrang.automation.base.BasePage;

public class DynamicLoading extends BasePage {

	public DynamicLoading(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	By linkDynamicLoading = By.cssSelector("a[href*='/dynamic_loading']");
	By linkElementHidden = By.cssSelector("a[href*='/dynamic_loading/1']");
	By linkElementRendered = By.cssSelector("a[href*='/dynamic_loading/2']");
	By startBtn = By.cssSelector("div[id='start'] button");
	By finishMessage = By.id("finish");
	
	public void goToDynamicLoading() {
		clickEle(linkDynamicLoading);
	}
	
	public void gotoExample1() {
		clickEle(linkElementHidden);
	}
	
	public void gotoExample2() {
		clickEle(linkElementRendered);
	}
	
	public void clickStart() {
		clickEle(startBtn);
	}
	
	public String getText() {
		return getTextEle(finishMessage);
	}

}
