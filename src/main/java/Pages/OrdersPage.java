package Pages;

	import java.io.File;
	import java.io.IOException;
	import java.util.Arrays;
	import java.util.List;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.io.FileHandler;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.PageFactory;

	import Base.TestBase;
import Utility.ReadExcel;
import Utility.TakeScreenShot;

	public class OrdersPage extends TestBase {
		
		@FindBy(xpath="//span[text()='Orders']") private WebElement orders;
		@FindBy(xpath="(//span[text()='Orders'])[2]") private WebElement orderOption;
		@FindBy(xpath="//span[text()='GTT']") private WebElement gttoption;
		@FindBy(xpath="//span[text()='Baskets']") private WebElement basketoption;
		@FindBy(xpath="//span[text()='SIP']") private WebElement sipoption;
		@FindBy(xpath="//span[text()='Alerts']") private WebElement alertoption;
		@FindBy(xpath="//span[text()='IPO']") private WebElement ipooption;
		@FindBy(xpath="//button[text()='Get started ']") private WebElement getStarted;
		@FindBy(xpath="(//input[@type='text'])[2]") private WebElement search;
		@FindBy(xpath="//a[text()=' View 20 depth']") private WebElement more;
		@FindBy(xpath="//button[text()='Create GTT ']") private WebElement gttButton;
		@FindBy(xpath="//button[text()='Buy ']") private WebElement buyButton;
		@FindBy(how = How.XPATH, using="//button[text()='Sell ']") private WebElement sellButton;
		@FindBy(xpath="//button[text()='New GTT ']") private WebElement newGtt; 
		@FindBy(xpath="//button[text()='New basket']") private WebElement basket;
		@FindBy(xpath="//input[@label='Name']") private WebElement basketName;
		@FindBy(xpath="//button[text()='Create new SIP']") private WebElement sip;
		@FindBy(xpath="//input[@label='Name']") private WebElement sipName;
		@FindBy(xpath="//span[@class='su-checkbox-box']") private WebElement checkBox;
		@FindBy(xpath="//div[@name='day']") private WebElement day;
		@FindBy(xpath="//div[@name='time']") private WebElement time;
		@FindBy(xpath="//button[text()='Create new alert']") private WebElement alert;
		@FindBy(xpath="//input[@label='Name']") private WebElement alertName;
		@FindBy(xpath="(//div[@class='su-select'])[1]") private WebElement property;
		@FindBy(xpath="(//div[@class='su-select'])[2]") private WebElement is;
		@FindBy(xpath="(//input[@type='number'])[2]") private WebElement percent;
		@FindBy(xpath="//button[text()='Create ']") private WebElement submit;
		@FindBy(xpath="(//input[@type='text'])[3]") private WebElement search1;
		

		public OrdersPage()
		{
			PageFactory.initElements(driver, this);
		}
		public String placeOrder() throws InterruptedException
		{
			Thread.sleep(2000);
			orders.click();
			return orders.getText();
		}
		public String start() throws InterruptedException
		{
			Thread.sleep(2000);
			getStarted.click();
			return getStarted.getText();
		}
		public void searchFor() throws Exception
		{
			Thread.sleep(2000);
			search.sendKeys(ReadExcel.readExcelFile(1, 0));
			Thread.sleep(2000);
			Actions a = new Actions(driver);
			for(int i=0;i<5;i++)
			{
				a.sendKeys(Keys.DOWN).build().perform();
				Thread.sleep(1000);
			}
			a.sendKeys(Keys.ENTER).build().perform();
		}
		public List<String> moreOptions() throws InterruptedException, IOException
		{
			Thread.sleep(3000);
			more.click();
			Thread.sleep(1000);
			String b = gttButton.getText();
			Thread.sleep(1000);
			String c = buyButton.getText();
			Thread.sleep(1000);
			String d = sellButton.getText();
		    File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    File destination = new File("C:\\Users\\asus\\eclipse-workspace\\Javaprogram\\ScreenShots\\orders.jpeg");
		    FileHandler.copy(source, destination);
			return Arrays.asList(b,c,d);
			
		}
		public void gttOption() throws Exception
		{
			Thread.sleep(1000);
			orders.click();
			Thread.sleep(1000);
			gttoption.click();
			Thread.sleep(1000);
			newGtt.click();
			Thread.sleep(1000);
			search.sendKeys(ReadExcel.readExcelFile(1, 1));
			Thread.sleep(1000);
			Actions b = new Actions(driver);
			for(int j=0;j<5;j++)
			{
				b.sendKeys(Keys.DOWN).build().perform();
				Thread.sleep(1000);
			}
			b.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(1000);
		
			
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    File destination = new File("C:\\Users\\asus\\eclipse-workspace\\Javaprogram\\ScreenShots\\ordersGtt.jpeg");
		    FileHandler.copy(source, destination);
		}
		public void basketOption() throws Exception
		{
			Thread.sleep(1000);
			orders.click();
			Thread.sleep(1000);
			basketoption.click();
			Thread.sleep(1000);
			basket.click();
			Thread.sleep(2000);
			basketName.sendKeys(ReadExcel.readExcelFile(1, 2));
			Thread.sleep(1000);
			submit.click();
			Thread.sleep(1000);
			search1.sendKeys(ReadExcel.readExcelFile(1, 3));
			Thread.sleep(1000);
			Actions b = new Actions(driver);
			for(int i=0;i<6;i++)
			{
				b.sendKeys(Keys.DOWN).build().perform();
				Thread.sleep(1000);
			}
			b.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(1000);
			
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    File destination = new File("C:\\Users\\asus\\eclipse-workspace\\Javaprogram\\ScreenShots\\ordersBasket.jpeg");
		    FileHandler.copy(source, destination);
		}
		public void createSip() throws Exception
		{
			Thread.sleep(1000);
			orders.click();
			Thread.sleep(1000);
			sipoption.click();
			Thread.sleep(1000);
			sip.click();
			Thread.sleep(1000);
			sipName.sendKeys(ReadExcel.readExcelFile(1, 4));
			Thread.sleep(1000);
			checkBox.click();
			Thread.sleep(1000);
			Actions b = new Actions(driver);
			b.click(day).build().perform();
			for(int i=0;i<7;i++)
			{
				b.sendKeys(Keys.DOWN).build().perform();
				Thread.sleep(1000);
			}
			b.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(1000);
			Actions c = new Actions(driver);
			c.click(time).build().perform();
			for(int i=0;i<6;i++)
			{
				c.sendKeys(Keys.DOWN).build().perform();
				Thread.sleep(1000);
			}
			c.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(1000);
			
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    File destination = new File("C:\\Users\\asus\\eclipse-workspace\\Javaprogram\\ScreenShots\\ordersSip.jpeg");
		    FileHandler.copy(source, destination);
		}
		public void alert() throws Exception
		{
			Thread.sleep(1000);
			orders.click();
			Thread.sleep(1000);
			alertoption.click();
			Thread.sleep(2000);
			alert.click();
			Thread.sleep(2000);
			alertName.sendKeys(ReadExcel.readExcelFile(1, 5));
			Thread.sleep(1000);
			Actions b = new Actions(driver);
			b.click(property).build().perform();
			for(int i=0;i<2;i++)
			{
				b.sendKeys(Keys.DOWN).build().perform();
				Thread.sleep(1000);
			}
			b.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(1000);
			Actions c = new Actions(driver);
			c.click(is).build().perform();
			for(int i=0;i<2;i++)
			{
				c.sendKeys(Keys.DOWN).build().perform();
				Thread.sleep(1000);
			}
			c.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(2000);
			percent.clear();
			Thread.sleep(1000);
			percent.sendKeys(ReadExcel.readExcelFile(1, 6));
			Thread.sleep(1000);
			
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    File destination = new File("C:\\Users\\asus\\eclipse-workspace\\Javaprogram\\ScreenShots\\ordersAlert.jpeg");
		    FileHandler.copy(source, destination);
		
		}
		public void ipo() throws InterruptedException, IOException
		{
			Thread.sleep(1000);
			orders.click();
			Thread.sleep(1000);
			ipooption.click();
			Thread.sleep(2000);
			
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    File destination = new File("C:\\Users\\asus\\eclipse-workspace\\Javaprogram\\ScreenShots\\ordersIpo.jpeg");
		    FileHandler.copy(source, destination);
		}
		}
