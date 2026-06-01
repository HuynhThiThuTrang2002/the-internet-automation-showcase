package com.thutrang.automation.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.thutrang.automation.base.BasePage;

public class SortableDataTables extends BasePage {

	public SortableDataTables(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	By linkDataTable = By.cssSelector("a[href*='/tables']");
	By lastNameHeader1 = By.xpath("//table[1]/thead/tr/th[1]");
	
	@FindBy(xpath = "//table[1]/tbody/tr/td[1]")
	private List<WebElement> lastNameCol;
	
	@FindBy(xpath = "//table[1]/tbody/tr/td[3]")
	private List<WebElement> emailCol;
	
	@FindBy(xpath = "//table[1]/tbody/tr/td[2]")
	private List<WebElement> firstNameCol;
	
	@FindBy(xpath = "//table[1]/tbody/tr/td[6]")
	private List<WebElement> actionCol;
	
	public void goToTable() {
		clickEle(linkDataTable);
	}
	
	public List<String> getExpectedSortedList(){
		List<String> sortCol = lastNameCol.stream().map(WebElement::getText).sorted().collect(Collectors.toList());
		
		return sortCol;
	}
	
	public List<String> getActualSortedList() {
		clickEle(lastNameHeader1);
		List<String> actualList = lastNameCol.stream()
				.map(WebElement::getText)
				.map(String::trim)
				.collect(Collectors.toList());
		return actualList;
	}
	
	public List<String> getLastNameList(){
		return lastNameCol.stream().map(WebElement::getText).map(String::trim).collect(Collectors.toList());
	}
	
	public List<String> getEmailList(){
		return emailCol.stream().map(WebElement::getText).map(String::trim).collect(Collectors.toList());
	}
	
	public List<String> getFirstNameList(){
		return firstNameCol.stream().map(WebElement::getText).map(String::trim).collect(Collectors.toList());
	}
	
	public String getEmailByLastName(String lastName) {
		for(int i = 0; i < lastNameCol.size(); i++) {
			if(lastNameCol.get(i).getText().equalsIgnoreCase(lastName)) {
				return emailCol.get(i).getText();
			}
		}
		return null;
	}
	
	public void clickActions(String firstName, String action) {
		for(int i = 0; i < firstNameCol.size(); i++) {
			if(firstNameCol.get(i).getText().equalsIgnoreCase(firstName)) {
				if(action.equalsIgnoreCase("edit")) {
					actionCol.get(i).findElement(By.xpath(".//a[1]")).click();
				}
				else {
					actionCol.get(i).findElement(By.xpath(".//a[2]")).click();
				}
				break;
			}
		}
	}

}
