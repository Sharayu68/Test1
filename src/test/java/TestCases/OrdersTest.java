package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.OrdersPage;

	public class OrdersTest extends OrdersPage {
		
		OrdersPage page;
		LoginPage login;
		
		@BeforeMethod(groups = {"Sanity","Regression"})
		public void setup() throws Exception
		{
			intialization();
			page = new OrdersPage();
			login = new LoginPage();
			login.signin();
		}
		@Test(groups = "Sanity")
		public void placeOrderTest() throws Exception
		{
			System.out.println(page.placeOrder());
		}
		@Test(groups = "Sanity")
		public void startTest() throws Exception
		{
			page.placeOrder();
			System.out.println(page.start());
		}
		@Test(groups = "Sanity")
		public void searchForTest() throws Exception
		{
			page.placeOrder();
			page.start();
			page.searchFor();
		}
		@Test(groups = "Sanity")
		public void moreOptionsTest() throws Exception
		{
			page.placeOrder();
			page.start();
			page.searchFor();
			System.out.println(page.moreOptions());
		}
		@Test(groups = "Regression")
		public void gttOptionTest() throws Exception
		{
			page.gttOption();
		}
		@Test(groups = "Regression")
		public void basketOptionTest() throws Exception
		{
			page.basketOption();
		}
		@Test(groups = "Regression")
		public void createSipTest() throws Exception
		{
			page.createSip();
		}
		@Test(groups = "Regression")
		public void alertTest() throws Exception
		{
			page.alert();
		}
		@Test(groups = "Regression")
		public void ipoTest() throws Exception
		{
			page.ipo();
		}
		
		@AfterMethod(groups = {"Sanity","Regression"})
		public void exit()
		{
			driver.close();
		}

	}
