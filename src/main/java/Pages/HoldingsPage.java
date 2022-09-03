package Pages;

	import java.io.File;
	import java.io.IOException;

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

	public class HoldingsPage extends TestBase{

		@FindBy(xpath="//span[text()='Holdings']") private WebElement holdings;
		@FindBy(xpath="//button[text()='Get started ']") private WebElement getStarted;
	    @FindBy(xpath="(//input[@icon='search'])[2]") private WebElement search;
	    @FindBy(xpath="//a[text()=' View 20 depth']") private WebElement more;
		@FindBy(xpath="//button[text()='Create GTT ']") private WebElement gttButton;
		@FindBy(xpath="//button[text()='Buy ']") private WebElement buyButton;
		@FindBy(xpath="(//input[@type='number'])[2]") private WebElement triggerPrice;
		@FindBy(xpath="(//input[@type='number'])[3]") private WebElement quantity;
		@FindBy(xpath="(//input[@type='number'])[4]") private WebElement price;
		@FindBy(xpath="//button[@class='place button-blue']") private WebElement placeButton;
		@FindBy(xpath="//label[text()='Iceberg']") private WebElement options;
		@FindBy(xpath="//label[@class='su-switch-control']") private WebElement switchTo;
		@FindBy(xpath="//label[text()='Intraday ']") private WebElement intraday;
		@FindBy(xpath="//label[text()='Market']") private WebElement market;
		@FindBy(xpath="//span[text()='More options ']") private WebElement moreOptions;
		@FindBy(how = How.XPATH, using="//label[text()='Validity']") private WebElement validity;
		
		public HoldingsPage()
		{
			PageFactory.initElements(driver, this);
		}
		public String placeOrder() throws InterruptedException
		{
			Thread.sleep(2000);
			holdings.click();
			return holdings.getText();
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
			search.sendKeys(ReadExcel.readExcelFile(0, 0));
			Actions a = new Actions(driver);
			for(int i=0;i<4;i++)
			{
				a.sendKeys(Keys.DOWN).build().perform();
				Thread.sleep(1000);
			}
			a.sendKeys(Keys.ENTER).build().perform();
		}
		public String createGtt() throws Exception
		{

			Thread.sleep(2000);
			gttButton.click();
			Thread.sleep(1000);
			triggerPrice.clear();
			triggerPrice.sendKeys(ReadExcel.readExcelFile(0,1));
			Thread.sleep(1000);
			quantity.clear();
			quantity.sendKeys(ReadExcel.readExcelFile(0,2));
			Thread.sleep(1000);
			price.clear();
			price.sendKeys(ReadExcel.readExcelFile(0,3));
			String b = placeButton.getText();
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest = new File("C:\\Users\\asus\\eclipse-workspace\\Javaprogram\\ScreenShots\\holdingsGtt.jpeg");
			FileHandler.copy(source, dest);
			return b;
		}
		
		public void sell() throws InterruptedException, IOException
		{
			Thread.sleep(2000);
			buyButton.click();
			Thread.sleep(2000);
			options.click();
			Thread.sleep(1000);
			switchTo.click();
			Thread.sleep(1000);
			market.click();
			Thread.sleep(1000);
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest = new File("C:\\Users\\asus\\eclipse-workspace\\Javaprogram\\ScreenShots\\holdingsSell.jpeg");
			FileHandler.copy(source, dest);
			moreOptions.click();
			Thread.sleep(1000);
			Actions a = new Actions(driver);
			a.moveToElement(validity).build().perform();
			for(int i=0;i<2;i++) 
			{
				a.sendKeys(Keys.DOWN).click().build().perform();
				Thread.sleep(1000);
			}
			
		}
	}
