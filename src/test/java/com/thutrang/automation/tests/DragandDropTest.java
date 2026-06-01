package com.thutrang.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thutrang.automation.base.BaseTest;
import com.thutrang.automation.pages.DragandDrop;

public class DragandDropTest extends BaseTest {
	@Test
	public void testDragAToDropB() {
		DragandDrop dND = new DragandDrop(driver);
		dND.goToDragandDrop();
		Assert.assertEquals(dND.getNameColumn1(), "A");
		dND.dragAndDropAtoB();
		Assert.assertEquals(dND.getNameColumn1(), "B");
	}
	
	@Test
	public void testDragBToDropA() {
		DragandDrop dND = new DragandDrop(driver);
		dND.goToDragandDrop();
		Assert.assertEquals(dND.getNameColumn2(), "B");
		dND.dragAndDropBtoA();
		Assert.assertEquals(dND.getNameColumn2(), "A");
	}

}
