package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	public Properties prop;
	FileInputStream fs;

	public Properties init_prop(){
	prop= new Properties();
	
	try {
		fs = new FileInputStream("./src/test/resources/config/config.properties");
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}

	try {
		prop.load(fs);
	} catch (IOException e) {
	  e.printStackTrace();
	}
	return prop;
	}
}
