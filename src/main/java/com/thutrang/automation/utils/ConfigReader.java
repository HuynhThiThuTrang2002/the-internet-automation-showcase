package com.thutrang.automation.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
	Properties properties;
	public ConfigReader() {
		try {
			properties = new Properties();
			InputStream input = getClass()
					.getClassLoader()
					.getResourceAsStream("config.properties");
			
			if(input == null) {
				throw new RuntimeException("Cannot find config.properties");
			}
			properties.load(input);
		} catch(Exception e) {
			throw new RuntimeException("Failed to load config file", e);
		}
	}
	public String get(String key) {
		return properties.getProperty(key);
	}
}
