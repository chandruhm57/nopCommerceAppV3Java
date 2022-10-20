package com.nopCommerceV2.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Try {
	
	Properties pro;
	
	public Try() {
		File src=new File("./Configuration/config.properties");
		try {
			FileInputStream fi=new FileInputStream(src);
			pro=new Properties();
			pro.load(fi);
		} catch (Exception e) {
				e.getMessage();
		}
	}
	public String getApplication()	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getUsername() {
		String email=pro.getProperty("email");
		return email;
		
	}
	public String getPassword() {
		String password=pro.getProperty("password");
		return password;
	}
	
	
	
}
