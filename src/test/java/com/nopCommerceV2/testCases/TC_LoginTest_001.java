package com.nopCommerceV2.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;
import com.nopCommerceV2.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
 
	@Test
	public void logintest() throws Exception {
		driver.get(baseURL);
		logger.info("URL is opened...");
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(email);
		logger.info("User provided"); //logger msg
		
		lp.setPassword(password);
		logger.info("Password provided");//logger msg
		
		lp.clickLogin();
		logger.info("Login in Clicked");//logger msg
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Thread.sleep(5000);
			lp.clickLogout();
			Assert.assertTrue(true);
			logger.info("Login Passed");//logger msg
			
		}
		else
		{
			captureScreenshot(driver,"logintest");
			Assert.assertTrue(false);
			logger.info("Login Failed");//logger msg
		}
	}
}
