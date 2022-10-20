package com.nopCommerceV2.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(name="Email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(name="Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement btnLogout;
	
	public void setEmail(String mail) {
		txtEmail.clear();
		txtEmail.sendKeys(mail);
	}
	
	public void setPassword(String pswd) {
		txtPassword.clear();
		txtPassword.sendKeys(pswd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		btnLogout.click();
	}
	
}
