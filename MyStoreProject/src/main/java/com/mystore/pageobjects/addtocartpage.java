/**
 * 
 */
package com.mystore.pageobjects;

import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.dockerjava.api.model.Driver;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author 
 *
 */
public class addtocartpage extends BaseClass{
	Action act=new Action();
	@FindBy(xpath="//*[@id=\"add-cart-button-id\"]/span")
	WebElement addtocartbutton;
	@FindBy(xpath="//i[@class='sd-icon sd-icon-checkmark']")
	WebElement message;
	public addtocartpage() {
		PageFactory.initElements(driver, this);
	}
		
	public void ClickOnAddTocart() {
		Set<String> window=driver.getWindowHandles();
		Iterator<String> itr=window.iterator();
		String parentwindow=itr.next();
		System.out.println(parentwindow);
	String childwindow=itr.next();
	driver.switchTo().window(childwindow);
		act.click(driver, addtocartbutton);
	}
	public boolean ValidateAddToCart() {
		 return act.isDisplayed(driver, message);
	}
	
}
