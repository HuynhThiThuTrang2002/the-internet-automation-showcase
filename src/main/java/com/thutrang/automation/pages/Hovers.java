package com.thutrang.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.thutrang.automation.base.BasePage;

public class Hovers extends BasePage {

	public Hovers(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	By linkHovers = By.cssSelector("a[href*='/hovers']");
	By userInfo = By.tagName("h5");
	
	@FindBy(css=".figure")
	List<WebElement> users;
	
	public void goToHovers() {
		clickEle(linkHovers);
	}
	
	public void hoverUserIcon(int index) {
		WebElement element = users.get(index);
		hoverEle(element);
	}
	
	public String getUserInfo(int index) {
		WebElement userFigure = users.get(index);
		WebElement info = wait.until(
				ExpectedConditions.visibilityOf(
						userFigure.findElement(userInfo)
				)
		);
		return info.getText();
	}
}
