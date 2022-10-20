package com.nopCommerceV2.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.nopCommerceV2.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();

	public String baseURL=readconfig.getApplicationURL();
	public String email=readconfig.getUserEmail();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{

		if(br.equals("chrome"))
		{
			//ChromeOptions options=new ChromeOptions();
			//options.addArguments("--headless");
			//options.setHeadless(true);
			
			WebDriverManager.chromedriver().setup();
			//driver=new ChromeDriver(options);
			driver=new ChromeDriver();
		}
		else if(br.equals("edge")) {
			
//			EdgeOptions options=new EdgeOptions();
//			options.setHeadless(true);
//			options.addArguments("--headless");
			
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
//			driver=new EdgeDriver(options);
		}
		else if(br.equals("firefox")) {
			
			FirefoxOptions options=new FirefoxOptions();
			options.setHeadless(true);
			//options.addArguments("--headless");
			
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver(options);
		}
		else if(br.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else {
			
//			ChromeOptions options=new ChromeOptions();
//			//options.addArguments("--headless");
//			options.setHeadless(true);
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
//			driver=new ChromeDriver(options);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		logger=Logger.getLogger("nopEcommerce");
		PropertyConfigurator.configure("Log4j.properties");
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	}
	
	public static String randomeString() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return generatedString1;
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return generatedString2;
	}
	
	
}
