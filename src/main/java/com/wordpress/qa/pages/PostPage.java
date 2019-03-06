package com.wordpress.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wordpress.qa.base.TestBase;

public class PostPage extends TestBase{
	
	NewPostPage newPostPage;
	
	@FindBy(xpath="//div[@class=\"wrap\"]/h1[@class=\"wp-heading-inline\"]")
	WebElement postsText;
	
	@FindBy(xpath="//div[@class=\"wrap\"]//a[text()=\"Add New\"]")
	WebElement addNewBtn;
	
	public PostPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyIfOnPostsPage() {
		return postsText.isDisplayed();
	}
	
	public NewPostPage clickOnAddNewBtn() {
		addNewBtn.click();
		return new NewPostPage();
	}
	

}
