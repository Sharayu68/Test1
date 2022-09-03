package Pages;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import Base.TestBase;
import Utility.ReadProperty;

	public class LoginPage extends TestBase {
		
		@FindBy(xpath="//input[@id='userid']") private WebElement id;
		@FindBy(xpath="//input[@id='password']") private WebElement pass;	
		@FindBy(xpath="//button[@type='submit']") private WebElement submitButton;
		@FindBy(xpath="//a[@class='logo kite-logo']") private WebElement kiteLogo;
		@FindBy(xpath="//h2[text()='Login to Kite']") private WebElement liteLabel;
		@FindBy(xpath="//input[@id='pin']") private WebElement pin;
		@FindBy(xpath="//button[text()='Continue ']") private WebElement continueButton;
		public LoginPage() 
		{
			PageFactory.initElements(driver, this);
		}
		public String verifyTitle()
		{
			return driver.getTitle();
		}
		public boolean verifyKiteLogo() 
		{
			 return kiteLogo.isDisplayed();
		}
		public void signin() throws Exception
		{
			id.sendKeys(ReadProperty.readPropertyFile("UserId"));
			Thread.sleep(1000);
			pass.sendKeys(ReadProperty.readPropertyFile("Password"));
			Thread.sleep(1000);
			submitButton.click();
			Thread.sleep(1000);
			pin.sendKeys(ReadProperty.readPropertyFile("Pin"));
			Thread.sleep(1000);
			continueButton.click();
		}
		
	}
