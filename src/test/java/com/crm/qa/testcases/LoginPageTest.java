package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase{
	
    LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest() throws IOException{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException{
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title , "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test(priority=2)
	public void crmLogoTest() {
		boolean flag = loginpage.validateCrmLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() throws IOException, InterruptedException {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println(homepage.verifyHomePageTitle());
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
