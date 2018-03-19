package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contacts;
	TestUtil testutil;
	String sheetname = "contacts";

	public ContactsPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginpage = new LoginPage();
		testutil = new TestUtil();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame("mainpanel");
		contacts = homepage.clickOnContactsLink();
	}
	
//	@Test(priority =1)
//	public void verifyContactsPageLabel() {
//		Assert.assertTrue(contacts.verifycontactsLabel(),"Contacts label is missing");
//	}
//	
//	@Test(priority=2)
//	public void selectContactTest() {
//		contacts.selectContactByName("test1 test2");
//	}
//	
//	@Test(priority=3)
//	public void selectMultipleContactsTest() {
//		contacts.selectContactByName("test1 test2");
//		contacts.selectContactByName("Jack Henry");
//	}
	@DataProvider
	public Object[][] getCRMTestData() throws IOException {
		Object[][] data = TestUtil.getTestData(sheetname);
		return data;
	}
	
	@Test(priority=4,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String fname, String lname, String company) {
		homepage.clickOnNewContactLink();
		contacts.createNewContact(title, fname, lname, company);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
