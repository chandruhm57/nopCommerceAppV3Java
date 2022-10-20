package com.nopCommerceV2.testCases;


import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopCommerceV2.pageObjects.LoginPage;
import com.nopCommerceV2.utilities.XLUtils;

public class TC_LoginDDTUsingDateProvider_0020 extends BaseClass {
	/*
	@Test(dataProvider="LoginData")
	public void loginTest(String user, String pwd) throws Exception
	{
		driver.get(baseURL);
		logger.info("URL is opened...");
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(user);
		logger.info("User provided"); //logger msg
		
		lp.setPassword(pwd);
		logger.info("Password provided");//logger msg
		
		lp.clickLogin();
		logger.info("Login in Clicked");//logger msg
		
		Thread.sleep(2000);
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			lp.clickLogout();
			Assert.assertTrue(true);
			logger.info("Login Passed");//logger msg
			
		}
		else
		{
			//captureScreen(driver,"logintest");
			Assert.assertTrue(false);
			logger.info("Login Failed");//logger msg
		}
		
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String file=System.getProperty("user.dir")+"/src/test/java/com/nopCommerceV2/testData/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(file, "Sheet1");
		int columnCount=XLUtils.getCellCount(file, "Sheet1", 1);
		
		String loginData[][]=new String[rownum][columnCount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<columnCount;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(file, "Sheet1", i, j);
			}
		}
		return loginData;
	}
	*/
}
