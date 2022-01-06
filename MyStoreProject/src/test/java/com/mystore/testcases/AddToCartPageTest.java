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
import com.mystore.pageobjects.addtocartpage;

import junit.framework.Assert;

/**
 * @author Madhu
 *
 */
public class AddToCartPageTest extends BaseClass{
	IndexPage index;
	SearchResultPage SearchResultPage;
	addtocartpage addtocartpage;
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	void tearDown() {
	driver.quit();	
	}
	@Test
	public void addToCartTest() {
		index=new IndexPage();
		SearchResultPage = index.SearchProduct("shoes");
		addtocartpage= SearchResultPage.clickOnProduct();
		addtocartpage.ClickOnAddTocart();
		boolean result=addtocartpage.ValidateAddToCart();
		Assert.assertTrue(result);
	}
}
