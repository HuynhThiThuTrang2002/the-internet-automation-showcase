package com.thutrang.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.thutrang.automation.base.BasePage;

public class DragandDrop extends BasePage {

	public DragandDrop(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	By linkDragandDrop = By.cssSelector("a[href*='/drag_and_drop']");
	By column1 = By.id("column-a");
	By nameColumn1 = By.cssSelector("div[id='column-a'] header");
	By column2 = By.id("column-b");
	By nameColumn2 = By.cssSelector("div[id='column-b'] header");
	
	public void goToDragandDrop() {
		clickEle(linkDragandDrop);
	}
	
	public void dragAndDropAtoB() {
		dragAndDropEle(column1, column2);
	}
	
	public void dragAndDropBtoA() {
		dragAndDropEle(column2, column1);
	}
	
	public String getNameColumn1() {
		return getTextEle(nameColumn1);
	}
	
	public String getNameColumn2() {
		return getTextEle(nameColumn2);
	}

}
