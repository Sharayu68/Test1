package Base;

	
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import Utility.ReadProperty;
import io.github.bonigarcia.wdm.WebDriverManager;

	public class TestBase {
		
		
		public static WebDriver driver;
		
		public void intialization() throws Exception
		{
			String browser = ReadProperty.readPropertyFile("Browser");
			if(browser.equals("Chrome"))
			{
			System.setProperty("webdriver.chrome.driver","chromedriver");
			driver = new ChromeDriver();
		    }
			else if(browser.equals("Firefox"))
			{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		    }
			else if(browser.equals("Edge"))
			{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		    }
			driver.get(ReadProperty.readPropertyFile("Url"));
			driver.manage().window().maximize();
		}
	}
//I updated my test base
//Again updated my test base
//Once again modified



