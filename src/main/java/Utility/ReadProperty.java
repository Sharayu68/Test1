package Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperty {
	
	public static String readPropertyFile(String value) throws Exception
	{
		Properties p = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\asus\\eclipse-workspace\\FrameWork\\TestData\\Config.properties");
		p.load(file);
		return p.getProperty(value);
	}
	public static String readPropertyFile1(String value) throws Exception
	{
		Properties p = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\asus\\eclipse-workspace\\FrameWork\\TestData\\Locators.properties");
		p.load(file);
		return p.getProperty(value);
	}
}
