package com.opencart.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig() {

		try {
			File src =new File("./Configuration/config.properties");
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
			
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	
	public String getApplicationURL() {
		return prop.getProperty("baseURL");
	}
	
	public String getUserName() {
		return prop.getProperty("email");
	}
	
	public String getPassword() {
		return prop.getProperty("password");
	}

}
