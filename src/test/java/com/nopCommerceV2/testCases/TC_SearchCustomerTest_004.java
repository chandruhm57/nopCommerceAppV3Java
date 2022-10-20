package com.nopCommerceV2.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerceV2.pageObjects.AddcuctomerPage;
import com.nopCommerceV2.pageObjects.LoginPage;
import com.nopCommerceV2.pageObjects.SearchCustomer;

public class TC_SearchCustomerTest_004 extends BaseClass {
	
	@Test
	public void serachByEmail() throws InterruptedException
	{
		driver.get(baseURL);
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
		logger.info("Loging is successful");
		
		logger.info("Started searchByEmail test");
		AddcuctomerPage addcust=new AddcuctomerPage(driver);
		addcust.clickCustomersmenu();
		addcust.clickCustomersmenuitem();
		
		SearchCustomer scbymail=new SearchCustomer(driver);
		scbymail.setSearchEmail("victoria_victoria@nopCommerce.com");
		scbymail.clickSearch();
		Thread.sleep(3000);
		
		String mail=driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[1]/td[2]")).getText();
		String status=driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr/td/i")).getAttribute("nop-value");
		if(mail.equals("victoria_victoria@nopCommerce.com"))
		{
			Assert.assertTrue(true);
			logger.info("SearchByEmail test is passed");
			logger.info("Mail stutus:"+status);
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("SearchByEmail test is failed");
		}
		
		logger.info("SearchByEmail test Successful");
		
		
	}
		
}
