package com.nopCommerceV2.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		File src=new File("./Configuration/config.properties");
		try { //Exception is created becoz if the config.properties file is not present or something is missing, we need to handle the exception.
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception is "+e.getMessage()); 
		}
	}
	
	public String getApplicationURL() {
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUserEmail() {
		String username=pro.getProperty("email");
		return username;
	}
	 
	public String getPassword() {
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getChromePath() {
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getEdgePath() {
		String edgepath=pro.getProperty("edgepath");
		return edgepath;
	}
	
	public String getFirefoxPath() {
		String firefoxpath=pro.getProperty("firfoxpath");
		return firefoxpath;
	}
	
	

}
