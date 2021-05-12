package com.banking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties pro;	
	
	public ReadConfig() {		
		File src = new File("./configuration/config.properties");	
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		
		} catch (Exception e) {		
			System.out.println("Exception message: "+e.getMessage());
		}		
		
	}
	
	public String getAppURL() {
		String url = pro.getProperty("loginUrl");
		return url;
	}
	
	public String getUsername() {
		String uname = pro.getProperty("username");
		return uname;		
	}
	
	public String getFireFoxPath() {		
		String fpath = pro.getProperty("firefoxpath");
		return fpath;
	}
	
	
}
