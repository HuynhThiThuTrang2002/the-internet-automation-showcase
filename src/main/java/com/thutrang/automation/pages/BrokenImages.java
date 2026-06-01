package com.thutrang.automation.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.thutrang.automation.base.BasePage;
import com.thutrang.automation.utils.HttpHelper;

public class BrokenImages extends BasePage {

	public BrokenImages(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	By linkBrokenImages = By.cssSelector("a[href*='/broken_images']");
	
	@FindBy(css = ".example img")
	private List<WebElement> allImages;
	
	public void goToBrokenImages() {
		clickEle(linkBrokenImages);
	}
	
	public List<String> getBrokenImages(){
		List<String> brokenImages = new ArrayList<>();
		for(WebElement image : allImages) {
			String imageSrc = image.getAttribute("src");
			
			if(imageSrc == null || imageSrc.isEmpty()) {
				brokenImages.add("EMPTY SRC");
				continue;
			}
			
			if(HttpHelper.isBrokenLink(imageSrc)) {
				brokenImages.add(imageSrc);
			}
		}
		
		return brokenImages;
	}
}
