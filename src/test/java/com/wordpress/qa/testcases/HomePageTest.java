package com.wordpress.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wordpress.qa.base.TestBase;
import com.wordpress.qa.pages.HomePage;
import com.wordpress.qa.pages.LoggedOutPage;
import com.wordpress.qa.pages.LoginPage;
import com.wordpress.qa.pages.PostPage;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	PostPage postPage;
	LoggedOutPage loggedOutPage;
	
	public HomePageTest()	{
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		postPage = new PostPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyTitle();
		Assert.assertEquals(homePageTitle, "Widgets ‹ Wordpress Demo Site at Demo.Center — WordPress","HomePage title not matched");
	}
	
	@Test(priority=2)
	public void verifyCorrectLoggedInUserTest() {
		String LoogedUser = homePage.loggedInUserName();
		Assert.assertEquals(LoogedUser, "admin","Logged in user is not as expected");
	}
	
	@Test(priority=3)
	public void verifyPostsButtonTest() {
		postPage = homePage.clickOnPostsLink();
		
	}
	
	@Test(priority=4)
	public void clickOnLogoutBtnTest() {
		loggedOutPage = homePage.clickOnLogoutLink();
		String LoggedOutSuccessMessage = loggedOutPage.verifyLoggedOutSuccessMessage();
		Assert.assertEquals(LoggedOutSuccessMessage, "You are now logged out.");
	}
		
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}