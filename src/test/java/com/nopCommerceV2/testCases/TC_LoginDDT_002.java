package com.nopCommerceV2.testCases;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.nopCommerceV2.pageObjects.LoginPage;
import com.nopCommerceV2.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test
	public void loginTestDDT() throws IOException, Exception {
		
		driver.get(baseURL);
		logger.info("URL is opened...");
		String file=System.getProperty("user.dir")+"/src/test/java/com/nopCommerceV2/testData/LoginData.xlsx";
		
		int rows=XLUtils.getRowCount(file, "Sheet1");
		
		ArrayList <String> list=new ArrayList<String>();
		
		for(int i=1;i<=rows;i++) {
			String username1=XLUtils.getCellData(file,"Sheet1",i, 0);
			String password1=XLUtils.getCellData(file, "Sheet1",i, 1);
			String exp=XLUtils.getCellData(file, "Sheet1", i, 2);
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(username1);
			logger.info("Provided Username");
			lp.setPassword(password1);
			logger.info("Provided password");
			lp.clickLogin();
			logger.info("Login in Clicked");
			
			Thread.sleep(3000);
			
			String expTitle="Dashboard / nopCommerce administration";
			String actTitle=driver.getTitle();
			
			if(actTitle.equals(expTitle)) {
				if(exp.equals("Pass")) {
					XLUtils.setCellData(file, "Sheet1", i, 3, "Pass");
					list.add("Pass");
					lp.clickLogout();
				}
				else {
					list.add("Fail");
				}
			}
			else {
				if(exp.equals("Pass")) {
					list.add("Fail");
				}
				else {
					list.add("Pass");
					XLUtils.setCellData(file, "Sheet1", i, 3, "Fail");
				}
			}
			
		}
		
		if(list.contains("Pass")) {
			Assert.assertTrue(true);
			logger.info("Login Passed");
		}
		else {
			Assert.assertTrue(false);
			logger.info("Login Failed");
		}
		
	}
	
}
