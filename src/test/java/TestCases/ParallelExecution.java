package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelExecution {
	WebDriver driver;
	
	@Test
	public void kite()
	{
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://kite.zerodha.com/");
	}
	@Test
	public void google()
	{
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://www.google.com/");
	}
	@Test
	public void facebook()
	{
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://www.facebook.com/");
	}
	@Test
	public void amazon()
	{
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://www.amazon.com/");
	}
	
}
