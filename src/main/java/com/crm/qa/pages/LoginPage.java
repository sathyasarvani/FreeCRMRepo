package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Objects or Page Factory or Object Repository
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo; 
	
	//Page objects initialization
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
		}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCrmLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String uname,String pwd) throws IOException {
		username.sendKeys(uname);
		password .sendKeys(pwd);
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",loginBtn);
		//loginBtn.click();
		return new HomePage();
	}
		
	}


