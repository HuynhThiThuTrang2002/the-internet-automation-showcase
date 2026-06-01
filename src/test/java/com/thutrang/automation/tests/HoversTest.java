package com.thutrang.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thutrang.automation.base.BaseTest;
import com.thutrang.automation.pages.Hovers;

public class HoversTest extends BaseTest{
	@Test
	public void testHoverUser1() {
		Hovers hover = new Hovers(driver);
		hover.goToHovers();
		hover.hoverUserIcon(0);
		Assert.assertEquals(hover.getUserInfo(0), "name: user1");
	}
	
	@Test
	public void testHoverUser2() {
		Hovers hover = new Hovers(driver);
		hover.goToHovers();
		hover.hoverUserIcon(1);
		Assert.assertEquals(hover.getUserInfo(1), "name: user2");
	}
	
	@Test
	public void testHoverUser3() {
		Hovers hover = new Hovers(driver);
		hover.goToHovers();
		hover.hoverUserIcon(2);
		Assert.assertEquals(hover.getUserInfo(2), "name: user3");
	}

}
