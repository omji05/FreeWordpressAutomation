package com.wordpress.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wordpress.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//div[text()='Posts']")
	WebElement postsLink;
	
	@FindBy(xpath="//a[@class=\"ab-item\"]//span[@class=\"display-name\"]")
	WebElement userLogged;
	
	//@FindBy(xpath="//a[@class="screen-reader-shortcut" and text()="Log Out"]")
	@FindBy(xpath="//li[@id=\"wp-admin-bar-logout\"]//a[text()=\"Log Out\"]")
	WebElement logoutLink;
	
	//various other Links on the page in the similar manner
	
	//constructor foe each page to initialize the WebPage elements
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle() {
		return driver.getTitle();
	}
	
	public String loggedInUserName() {
		return userLogged.getText();
	}
	public PostPage clickOnPostsLink() {
		postsLink.click();
		return new PostPage();
		
	}
	
	public LoggedOutPage clickOnLogoutLink() {
		Actions act = new Actions(driver);
		act.moveToElement(userLogged).build().perform();
		driver.findElement(By.xpath("//li[@id=\"wp-admin-bar-logout\"]//a[text()=\"Log Out\"]")).click();
		return new LoggedOutPage();
	}
	

}
