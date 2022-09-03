package TestCases;

	
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.HoldingsPage;
import Pages.LoginPage;

	public class HoldingsTest extends HoldingsPage {
		HoldingsPage page;
		LoginPage login;
		
		@BeforeMethod
		public void setup() throws Exception
		{
			intialization();
			page = new HoldingsPage();
			login = new LoginPage();
			login.signin();
		}
		@Test(invocationCount = 4)
		public void placeOrderTest() throws InterruptedException 
		{
			System.out.println(page.placeOrder());
		}
		@Test(dependsOnMethods = "placeOrderTest")
		public void startTest() throws InterruptedException
		{
			page.placeOrder();
			System.out.println(page.start());
		}
		@Test(priority = 0) 
		public void searchForTest() throws Exception
		{
			page.placeOrder();
			page.start();
			page.searchFor();
		}
		@Test(priority = 1)
		public void createGttTest() throws Exception
		{
			page.placeOrder();
			page.start();
			page.searchFor();
			System.out.println(page.createGtt());
		}
		@Test (priority = 2)
		public void sellTest() throws Exception
		{
			page.placeOrder();
			page.start();
			page.searchFor();
			page.sell();

		}
		@AfterMethod
		public void exit()
		{
			driver.close();
		}

	}
	