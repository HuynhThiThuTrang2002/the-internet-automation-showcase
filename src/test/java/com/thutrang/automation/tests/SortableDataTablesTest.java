package com.thutrang.automation.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.thutrang.automation.base.BaseTest;
import com.thutrang.automation.pages.SortableDataTables;

public class SortableDataTablesTest extends BaseTest {
	@Test
	public void testSortColumn() {
		SortableDataTables sDT = new SortableDataTables(driver);
		sDT.goToTable();
		Assert.assertEquals(sDT.getActualSortedList(), sDT.getExpectedSortedList());
	}
	
	@Test(dataProvider="getData1")
	public void testGetEmailByLastName(String lastName, String email) {
		SortableDataTables sDT = new SortableDataTables(driver);
		sDT.goToTable();
		Assert.assertEquals(sDT.getEmailByLastName(lastName), email);
	}
	
	@DataProvider
	public Object[][] getData1(){
		return new Object[][] {
			{"Smith", "jsmith@gmail.com"},
			{"Bach", "fbach@yahoo.com"},
			{"Doe", "jdoe@hotmail.com"},
			{"Conway", "tconway@earthlink.net"}
		};
	}
	
	@Test(dataProvider="getData2")
	public void testRowActions(String action, String url) {
		SortableDataTables sDT = new SortableDataTables(driver);
		sDT.goToTable();
		sDT.clickActions("Jason", action);
		Assert.assertEquals(sDT.getURLPage(), url);
	}
	
	@DataProvider
	public Object[][] getData2(){
		return new Object[][] {
			{"edit", "https://the-internet.herokuapp.com/tables#edit"},
			{"delete", "https://the-internet.herokuapp.com/tables#delete"}
		};
	}

}
