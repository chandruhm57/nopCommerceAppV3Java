package com.nopCommerceV2.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopCommerceV2.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Try{
	
	ReadConfig rc=new ReadConfig();
	
	public String baseURL=rc.getApplicationURL();
	public String email=rc.getUserEmail();
	public String password=rc.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		if(br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(br.endsWith("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(br.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();	
	}
	
	public void getScreenshot(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File(System.getProperty("user.dir")+"./Screenshots/"+tname+".png");
		FileUtils.copyFile(src, trg);
		
	}
	public static String getRandomString() {
		String generatedString1=RandomStringUtils.randomAlphabetic(5);
		return generatedString1;
	}
	
	public static String getRandomNum() {
		String generatedString2=RandomStringUtils.randomNumeric(2);
		return generatedString2;
	}
}
