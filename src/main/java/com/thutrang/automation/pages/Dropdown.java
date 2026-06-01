package com.thutrang.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.thutrang.automation.base.BasePage;

public class Dropdown extends BasePage {

	public Dropdown(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	By linkDropdown = By.cssSelector("a[href*='/dropdown']");
	By dropdownLocator = By.id("dropdown");
	
	public void goToDropdown() {
		clickEle(linkDropdown);
	}
	
	public Select getDropdown() {
		waitForElementVisible(dropdownLocator);
		return new Select(driver.findElement(dropdownLocator));
	}
	
	public void selectByText(String text) {
		getDropdown().selectByVisibleText(text);
		
	}
	
	public void selectByIndex(int index) {
		getDropdown().selectByIndex(index);
	}
	
	public String getSelectedOption() {
		return getDropdown().getFirstSelectedOption().getText();
	}

}
