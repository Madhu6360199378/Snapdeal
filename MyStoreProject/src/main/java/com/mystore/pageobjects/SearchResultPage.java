/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author 
 *
 */
public class SearchResultPage extends BaseClass {
	Action act=new Action();
	@FindBy(xpath="//*[@id=\"629787596130\"]/div[2]/a/picture/img")
	WebElement productresult;


public SearchResultPage() {
	PageFactory.initElements(driver, this);
}
public void isProductAvailable() {
	act.isDisplayed(driver,productresult);
}

public addtocartpage clickOnProduct() {
	act.click(driver,productresult);
	return new addtocartpage();
}
}
