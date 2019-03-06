package com.wordpress.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wordpress.qa.base.TestBase;

public class LoggedOutPage extends TestBase{
	
	@FindBy(xpath="//p[@class=\"message\"]")
	WebElement loggedOutSuccessMessage;
	
	
	public LoggedOutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyLoggedOutSuccessMessage() {
		return loggedOutSuccessMessage.getText();
	}
	
	

}
