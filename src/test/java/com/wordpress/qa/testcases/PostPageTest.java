package com.wordpress.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wordpress.qa.base.TestBase;
import com.wordpress.qa.pages.HomePage;
import com.wordpress.qa.pages.LoginPage;
import com.wordpress.qa.pages.NewPostPage;
import com.wordpress.qa.pages.PostPage;

public class PostPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	PostPage postPage;
	NewPostPage newPostPage;
	
	public PostPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		postPage = homePage.clickOnPostsLink();
	}
	
	@Test(priority=1)
	public void verifyIfOnPostsPageTest() {
		Assert.assertTrue(postPage.verifyIfOnPostsPage());
	}
	
	@Test(priority=2)
	public void clickOnAddNewTest() {
		newPostPage = postPage.clickOnAddNewBtn();
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
