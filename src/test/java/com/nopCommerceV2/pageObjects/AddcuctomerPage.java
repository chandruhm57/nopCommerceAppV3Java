package com.nopCommerceV2.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddcuctomerPage {

	public WebDriver ldriver;
	
	public AddcuctomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Object Identification Methods
	By lnkCustomers_menu=By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkCustomers_menuitem=By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");	
	By btnAdd_customer=By.xpath("//a[@class='btn btn-primary']");
	By btnCustomerinfo=By.xpath("//div[@class='card-title']");
	By txtEmail=By.xpath("//input[@id='Email']");
	By txtPassword=By.xpath("//input[@id='Password']");
	By txtFirstname=By.xpath("//input[@id='FirstName']");	
	By txtLastname=By.xpath("//input[@id='LastName']");
	By rdMale_gender=By.xpath("//input[@id='Gender_Male']");
	By rdFemale_gender=By.xpath("//input[@id='Gender_Female']");
	By txtDOB=By.xpath("//input[@id='DateOfBirth']");
	By txtComapanyname=By.xpath("//input[@id='Company']");
	By rdTaxexmption=By.xpath("//input[@id='IsTaxExempt']");
	By drpNewsletter=By.xpath("//*[@id='customer-info']/div[2]/div[9]/div[2]/div/div[1]/div/div");
	////div[@class='input-group-append']//div[@role='listbox']
	By drpNewsletterlist=By.xpath("//ul[@id='SelectedNewsletterSubscriptionStoreIds_listbox']/li");
	
	By clkCustomerRole=By.xpath("//div[@class='input-group-append input-group-required']//div[@role='listbox']");
	By lstitemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemRegistered=By.xpath("//li[contains(text(),'Registered')]");
	By lstitemGuests=By.xpath("//li[contains(text(),'Guests')]");
	By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");
	
	By drpManage_venodrroles=By.xpath("//select[@id='VendorId']");
	By txtAdmincomment=By.xpath("//textarea[@id='AdminComment']");
	By btnSave=By.xpath("//button[@name='save']");
	
	//Action Methods
	public void clickCustomersmenu() {
		ldriver.findElement(lnkCustomers_menu).click();
	}
	public void clickCustomersmenuitem() {
		ldriver.findElement(lnkCustomers_menuitem).click();
	}
	public void clickAddcustomerbtn() {
		ldriver.findElement(btnAdd_customer).click();
	}
	public void setEmail(String mail) {
		ldriver.findElement(txtEmail).sendKeys(mail);
	}
	public void setPassword(String pwd) {
		ldriver.findElement(txtPassword).sendKeys(pwd);
	}
	public void setFirstname(String fname) {
		ldriver.findElement(txtFirstname).sendKeys(fname);
	}
	public void setLastname(String lname) {
		ldriver.findElement(txtLastname).sendKeys(lname);
	}
	public void setGender(String gender) {
		if(gender.equals("male")) {
			ldriver.findElement(rdMale_gender).click();
		}
		else if(gender.equals("female")) {
			ldriver.findElement(rdFemale_gender).click();
		}
		else {
			ldriver.findElement(rdMale_gender).click();
		}
	}
	public void setDOB(String dob) {
		ldriver.findElement(txtDOB).sendKeys(dob);
	}
	public void setCompanyname(String cname) {
		ldriver.findElement(txtComapanyname).sendKeys(cname);
	}
	public void clickTaxexempt() {
		ldriver.findElement(rdTaxexmption).click();
	}
	public void setNewsletter(String letter) {
		ldriver.findElement(drpNewsletter).click();
		
		List <WebElement> drpletterEles=ldriver.findElements(drpNewsletterlist);
		
		for(WebElement letterEle:drpletterEles) {
			String letters=letterEle.getText();
			if(letters.equals(letter)) {
				letterEle.click();
				break;
			}
		}
	}
	public void setCustomerRoles(String role) {
		ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
	
		ldriver.findElement(clkCustomerRole).click();
					
		WebElement listitem;
		
		switch(role) {
		case "Administrators":
				listitem=ldriver.findElement(lstitemAdministrators); break;
		case "Guests":
				listitem=ldriver.findElement(lstitemGuests); break;
		case "Registered":
			listitem=ldriver.findElement(lstitemRegistered); break;
		case "Vendors":
			listitem=ldriver.findElement(lstitemVendors); break;
		default:
			listitem=ldriver.findElement(lstitemGuests);
		}
					
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", listitem);
		
	}
	public void setManagerofVendor(String vendor) {
		WebElement drpmgrvndr=ldriver.findElement(drpManage_venodrroles);
		Select drpletter=new Select(drpmgrvndr);
		drpletter.selectByVisibleText(vendor);
	}
	public void setAdmincomment(String comment) {
		ldriver.findElement(txtAdmincomment).sendKeys(comment);
	}
	public void clickSave() {
		ldriver.findElement(btnSave).click();
	}
}
