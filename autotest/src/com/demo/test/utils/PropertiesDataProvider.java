package com.demo.test.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.configuration2.Configuration;


/**
 * @Desription 从.properties文件中读取相关测试数据<br>
 * 
 * */
public class PropertiesDataProvider {

	public static String getTestData(String configFilePath, String key) {
		String value="";
		try{
			Properties prop = new Properties();
			String path = System.getProperty("user.dir") + "/"+configFilePath;
			System.out.println(path);
			InputStream input = new FileInputStream(path);
			prop.load(input);
			input.close();
			value=prop.getProperty(key);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return value;
	}
}

