package com.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;
	/**
	 * This method is used to load the properties from config.properties file
	 * @return 
	 * @return it returns Properties prop object
	 */
	public Properties readConfig()
	{  
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream("./src/test/resources/Config/config.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	System.out.println(prop.getProperty("browser"));	
	return prop;
	}

}
