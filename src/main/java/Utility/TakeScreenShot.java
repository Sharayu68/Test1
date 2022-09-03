package Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenShot {
	
	public static void takeScreenShots(WebDriver driver, String methodName) throws IOException
	{
	   File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   File destination = new File("C:\\Users\\asus\\eclipse-workspace\\FrameWork\\ScreenShots\\"+methodName+".jpeg");
	   FileHandler.copy(source, destination);
	}
	
	public static void takeScreenShots(Object name) throws IOException
	{
	   WebDriver driver = null;
	   File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   File destination = new File("C:\\Users\\asus\\eclipse-workspace\\FrameWork\\ScreenShots\\"+name+ ".jpeg");
	   FileHandler.copy(source, destination);
	}

	

}
