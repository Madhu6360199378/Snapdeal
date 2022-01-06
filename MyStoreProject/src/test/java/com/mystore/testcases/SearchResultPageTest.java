/**
 * 
 */
package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

import junit.framework.Assert;

/**
 * @author Admin
 *
 */
public class SearchResultPageTest extends BaseClass{
	IndexPage index;
	SearchResultPage SearchResultPage;
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();	
		}
	
	
	
	@Test
	public void productAvailabilityTest() {
		index=new IndexPage();
		 SearchResultPage = index.SearchProduct("shoes");
		SearchResultPage.clickOnProduct();
	}
	
}
