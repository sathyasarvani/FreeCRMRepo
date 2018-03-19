package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement companyName;
	
//	@FindBy(xpath="//input[@name='title']")
//	WebElement titleEle;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement saveBtn;
	
	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifycontactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title,String fname, String lname,String cmpname) {
		Select titleValue = new Select(driver.findElement(By.name("title")));
		titleValue.selectByVisibleText(title);
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		companyName.sendKeys(cmpname);
		saveBtn.click();
	}

}
