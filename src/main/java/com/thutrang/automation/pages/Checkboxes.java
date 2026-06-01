package com.thutrang.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.thutrang.automation.base.BasePage;

public class Checkboxes extends BasePage{
	
	
	public Checkboxes(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	//Checkboxes
	By linkCheckboxes = By.cssSelector("a[href='/checkboxes']");
	By checkboxList = By.cssSelector("#checkboxes input[type='checkbox']");
	
	public void goToCheckboxes() {
		clickEle(linkCheckboxes);
	}
	
	public List<WebElement> getAllCheckboxes(){
		return driver.findElements(checkboxList);
	}
	
	public void setCheckboxByIndex(int index, boolean expectedState) {
		WebElement checkbox = getAllCheckboxes().get(index);
		
		if(checkbox.isSelected() != expectedState) {
			checkbox.click();
		}
	}
	
	public boolean isCheckboxSelectedByIndex(int index) {
		return getAllCheckboxes().get(index).isSelected();
	}
}
