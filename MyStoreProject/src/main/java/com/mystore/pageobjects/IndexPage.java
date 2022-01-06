package com.mystore.pageobjects;

import javax.naming.directory.SearchResult;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	Action act=new Action();
	
	@FindBy(xpath="//input[@placeholder='Search products & brands']")
	WebElement searchproductbox;
	@FindBy(xpath="//span[@class='searchTextSpan']")
    WebElement searchbutton;
	@FindBy(xpath="//img[@class='notIeLogoHeader aspectRatioEqual sdHomepage cur-pointer']")
	WebElement Logo;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean ValidateLogo() {
		return act.isDisplayed(driver, Logo);
	}

	public String getMyTitle() {
		String MyTitle=driver.getTitle();
		return MyTitle;
	}
	
	public SearchResultPage SearchProduct(String productname) {
		act.type(searchproductbox, productname);
		act.click(driver, searchbutton);
		return new SearchResultPage();
	}
	
}
