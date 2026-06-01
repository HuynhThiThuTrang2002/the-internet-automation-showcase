package com.thutrang.automation.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thutrang.automation.base.BaseTest;
import com.thutrang.automation.pages.BrokenImages;

public class BrokenImagesTest extends BaseTest {
	
	@Test
	public void testCountBrokenImages() {
		BrokenImages brokenImages = new BrokenImages(driver);
		brokenImages.goToBrokenImages();
		
		List<String> brokenList = brokenImages.getBrokenImages();
		System.out.println("Broken Images: ");
		for(String image : brokenList) {
			System.out.println(image);
		}
		
		Assert.assertEquals(brokenList.size(), 2);
	}

}
