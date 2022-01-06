
package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

import junit.framework.Assert;

/**
 * @author Madhu
 */
public class IndexPageTest extends BaseClass{
	IndexPage indexpage;
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
	driver.quit();	
	}

	@Test
	public void verifyLogo() {
		IndexPage indexpage=new IndexPage();
		boolean result=indexpage.ValidateLogo();
		Assert.assertTrue(result);
	}
	
}
