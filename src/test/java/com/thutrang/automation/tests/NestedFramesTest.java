package com.thutrang.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thutrang.automation.base.BaseTest;
import com.thutrang.automation.pages.NestedFrames;

public class NestedFramesTest extends BaseTest {
	@Test
	public void testNestedFrame() {
		NestedFrames ntF = new NestedFrames(driver);
		ntF.goToFrames();
		ntF.goToNestedFrames();
		ntF.switchToLeftFrame();
		Assert.assertEquals(ntF.getContent(), "LEFT");
		ntF.switchToMiddleFrame();
		Assert.assertEquals(ntF.getContent(), "MIDDLE");
		ntF.switchToRightFrame();
		Assert.assertEquals(ntF.getContent(), "RIGHT");
		ntF.switchToBottomFrame();
		Assert.assertEquals(ntF.getContent(), "BOTTOM");
	}

}
