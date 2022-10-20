package com.nopCommerceV2.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerceV2.pageObjects.AddcuctomerPage;
import com.nopCommerceV2.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	

	@Test
	public void addNewCustomer() throws IOException, Exception
	{
		driver.get(baseURL);
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
		logger.info("Loging is successful");
		
		logger.info("Started addNewCustomer test");
		logger.info("providing customer details....");
		
		AddcuctomerPage addcust=new AddcuctomerPage(driver);
		addcust.clickCustomersmenu();
		addcust.clickCustomersmenuitem();
		addcust.clickAddcustomerbtn();
		
		String email = randomeString()+"@gmail.com";
		addcust.setEmail(email);
		
		addcust.setPassword("Test123");
		addcust.setFirstname("Sup");
		addcust.setLastname("riya");
		addcust.setGender("female");
		addcust.setDOB("01/06/1996");
		addcust.setCompanyname("Digitals");
		addcust.clickTaxexempt();
		addcust.setNewsletter("Test store 2");
		addcust.setCustomerRoles("Guest");
		addcust.setManagerofVendor("Vendor 2");
		addcust.setAdmincomment("abc");
		
		Thread.sleep(3000);
		
		addcust.clickSave();
		
		logger.info("validation started....");
		
		String msg = driver.findElement(By.tagName("body")).getText();
		
		if(msg.contains("The new customer has been added successfully"))
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			captureScreenshot(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
