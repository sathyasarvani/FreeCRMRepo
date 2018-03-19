package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

import junit.framework.Assert;

public class HomePageTest extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contacts;
	DealsPage deals;
	TasksPage tasks;
	TestUtil testutil;
	
	public HomePageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		loginpage = new LoginPage();
		testutil = new TestUtil();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(6000);
	}
	
	@Test(priority=1)
	public void homePageTitleTest() {
		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO");
	}
	
	@Test(priority=2)
	public void userNameLabelTeast() {
		testutil.switchToFrame("mainpanel");
		boolean flag = homepage.verifyUserNameLabel();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void contactsLinkTest() throws IOException {
		testutil.switchToFrame("mainpanel");
		contacts = homepage.clickOnContactsLink();
	}
	
	@Test(enabled=false)
	public void dealsLinkTest() throws IOException {
		deals = homepage.clickOnDealsLink();
	}
	
	@Test(enabled = false)
	public void tasksLinkTest() throws IOException {
		tasks = homepage.clickOnTasksLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
