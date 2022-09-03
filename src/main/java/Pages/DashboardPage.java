package Pages;

	import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import Base.TestBase;

	public class DashboardPage extends TestBase {
		
		@FindBy(xpath="//span[@class='nickname']") private WebElement name;
		@FindBy(xpath="//a[@class='dropdown-label']") private WebElement avatar;
		@FindBy(xpath="//ul[@class='list-flat dropdown-nav-list']") private WebElement profile;
		@FindBy(xpath="//a[normalize-space(text())='Activate']") private WebElement activateButton;
		@FindBy(xpath="//button[normalize-space(text())='Start investing']") private WebElement startButton;
		@FindBy(xpath="(//input[@type='text'])[2]") private WebElement searchButton;
		@FindBy(xpath="//button[text()='Create GTT ']") private WebElement gttButton;
		@FindBy(xpath="//button[text()='Buy ']") private WebElement buyButton;
		@FindBy(xpath="//button[text()='Sell ']") private WebElement sellButton;
		
		public DashboardPage()
		{
			PageFactory.initElements(driver, this);
		}
		public String displayName() throws InterruptedException
		{
			Thread.sleep(1000);
			return name.getText();
		}
		public String displayAvatar() throws InterruptedException
		{
			Thread.sleep(1000);
			Actions a = new Actions(driver);
			a.click(avatar).build().perform();
			for(int i=0;i<6;i++)
			{
				a.sendKeys(Keys.DOWN).build().perform();
				Thread.sleep(1000);
			}
			return avatar.getText();
		}
		public String displayProfile() throws InterruptedException
		{
			Thread.sleep(2000);
			avatar.click();
			Thread.sleep(1000);
			Actions b = new Actions(driver);
			b.moveToElement(profile).build().perform();
			for(int i=0;i<4;i++)
			{
				b.sendKeys(Keys.DOWN).build().perform();
				Thread.sleep(1000);
			}
			return profile.getText();
		}
		public void activate() throws InterruptedException
		{
			Thread.sleep(2000);
			activateButton.click();
			Thread.sleep(1000);
		}
		public void startInvesting() throws InterruptedException
		{
			Thread.sleep(5000);
			startButton.click();
			Thread.sleep(2000);
	        searchButton.sendKeys("infy");
	        Thread.sleep(2000);
			Actions a = new Actions(driver);
			a.moveToElement(searchButton).build().perform();
			for(int i=0;i<6;i++) 
			{
				a.sendKeys(Keys.DOWN).build().perform();
				Thread.sleep(1000);
			}
			a.sendKeys(Keys.ENTER).build().perform();
		}
		public List<String> button() throws InterruptedException
		{
			Thread.sleep(2000);
			String b = gttButton.getText();
			Thread.sleep(2000);
			String c = buyButton.getText();
			Thread.sleep(2000);
			String d = sellButton.getText();
			return Arrays.asList(b,c,d);
		}
}
