package com.crm.qa.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'User: sarvani rasamsetty')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsList;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsList; 
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksList; 
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	public HomePage() throws IOException{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
//		WebDriverWait wait = new WebDriverWait(driver, 15); 
//		wait.until(ExpectedConditions.titleContains("CRMPRO"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver.getTitle();
	}
	
	public boolean verifyUserNameLabel() {
		return userNameLabel.isDisplayed();
		
	}
	public ContactsPage clickOnContactsLink() throws IOException {
		contactsList.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() throws IOException {
		dealsList.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() throws IOException {
		dealsList.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsList).build().perform();
		newContactLink.click();
	}
	
}
