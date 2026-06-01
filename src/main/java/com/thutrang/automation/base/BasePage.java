package com.thutrang.automation.base;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	public WebElement waitForElementVisible(By element) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public boolean waitForElementInvisible(By element) {
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
	}
	
	public WebElement waitForElementToBeClickable(By element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public Alert waitForAlert() {
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public boolean waitForElementEnabled(By element) {
	    return wait.until(driver ->
	        driver.findElement(element).isEnabled());
	}
	
	public void clickEle(By element) {
		waitForElementToBeClickable(element).click();
	}
	
	public void clearEle(By element) {
		waitForElementVisible(element).clear();
	}
	
	public void sendKeyEle(By element, String text) {
		waitForElementVisible(element).sendKeys(text);
	}
	
	public void clearAndSendKey(By element, String text) {
		WebElement ele = waitForElementVisible(element);
		ele.clear();
		ele.sendKeys(text);
	}
	
	public String getTextEle(By element) {
		return waitForElementVisible(element).getText();
	}
	
	public boolean isInputEnable(By element) {
		return getWebElement(element).isEnabled();
	}
	
	public WebElement getWebElement(By element) {
		return driver.findElement(element);
	}
	
	public void acceptAlert() {
		waitForAlert().accept();
	}
	
	public void dismissAlert() {
		waitForAlert().dismiss();
	}
	
	public void enterAlertText(String text) {
		waitForAlert().sendKeys(text);
	}
	
	public void hoverEle(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void dragAndDropEle(By source, By target) {
		WebElement sourceEle = waitForElementVisible(source);
		WebElement targetEle = waitForElementVisible(target);
		Actions action = new Actions(driver);
		action.clickAndHold(sourceEle).moveToElement(targetEle).release().perform();
	}
	
	public void switchToWindowByTitle(String expectedTitle) {
		wait.until(driver -> driver.getWindowHandles().size() > 1);
		for(String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);
			
			// if (driver.getCurrentUrl().contains(expectedUrl))
			if(driver.getTitle().contains(expectedTitle)) {
				break;
			}
		}
	}
	
	public void switchToFrame(By element) {
		driver.switchTo().frame(waitForElementVisible(element));
	}
	
	public void switchToDefault() {
		driver.switchTo().defaultContent();
	}
	
	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}
	
	public String getAttributeEle(By element, String name) {
		return waitForElementVisible(element).getAttribute(name);
	}
	
	public boolean isEmptyEle(By element) {
		return driver.findElements(element).isEmpty();
	}
	
	public String getURLPage() {
		return driver.getCurrentUrl();
	}
	
	public SearchContext getShadowRoot(By shadowHost) {
		WebElement host = waitForElementVisible(shadowHost);
		return host.getShadowRoot();
	}
	
	public WebElement getShadowElement(By shadowHost, By elementInsideShadow) {
		return getShadowRoot(shadowHost).findElement(elementInsideShadow);
	}

}
