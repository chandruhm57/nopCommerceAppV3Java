package com.nopCommerceV2.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomer {
	
	WebDriver ldriver;
	
	public SearchCustomer(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	By txtbyemail=By.xpath("//input[@id='SearchEmail']");
	By txtbyfirstname=By.xpath("//input[@id='SearchFirstName']");
	By txtbylastname=By.xpath("//input[@id='SearchLastName']");
	By btnsearch=By.xpath("//button[@id='search-customers']");
	
	By tablecustomer=By.xpath("//table[@id='customers-grid']/tbody/tr");
	//By tableSpecificcustomer1=By.xpath("//table[@id='customers-grid']/tbody/tr[1]/td[2]");
	//By tableCustomerstatus=By.xpath("//table[@id='customers-grid']/tbody/tr/td/i");
	By tableSpecificcustomer=By.xpath("//table[@id='customers-grid']/tbody/tr/td");
	
	
	public void setSearchEmail(String email1) {
		ldriver.findElement(txtbyemail).sendKeys(email1);
	}
	
	public void setSearchFirstname(String firstname) {
		ldriver.findElement(txtbyfirstname).sendKeys(firstname);
	}
	
	public void setSearchLastname(String lastname) {
		ldriver.findElement(txtbylastname).sendKeys(lastname);
	}
	
	public void clickSearch() {
		ldriver.findElement(btnsearch).click();
	}
	
	/*public void searchTable(String email1) {
		String mail=ldriver.findElement(tableSpecificcustomer1).getText();
		if(mail.equals(email1))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			
		}
	}*/
	
	public boolean customerStatus(String bymaildata) {
		boolean flag = false;
		List <WebElement> customers=ldriver.findElements(tablecustomer);
	
		//table[@id='resultTable']/tbody/tr["+i+"]/td[5]
		
		for(int r=0;r<=customers.size();r++) {
			WebElement customermail=ldriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+r+"]/td[2]"));
			String name=customermail.getText();
		
			if(name.equals(bymaildata)) {
				String status=ldriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr/td/i")).getAttribute("nop-value");
				if(status.equals("true")) {
					flag=true;
				}
				else {
					flag=false;
				}
				
			}
		}
		return flag;
	}

}
