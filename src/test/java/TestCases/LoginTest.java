package TestCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Utility.TakeScreenShot;

	public class LoginTest extends LoginPage{  
	
	 	LoginPage login;
		
		@BeforeMethod/*(groups = {"Sanity","Regression"})*/
		public void setup() throws Exception
		{
			intialization();
			login = new LoginPage();
		}
		@Test/*(groups = "Regression")*/
		public void test1()
		{
			System.out.println("Application opened successfully");
		}
		@Test/*(groups = "Sanity")*/
		public void verifyTitleTest()
		{
			String actTitle = login.verifyTitle();
			String expTitle = "Kite - Zerodha's fast and elegant flagship trading platform ";
			Assert.assertEquals(actTitle, expTitle);
		}
		@Test/*(groups = "Regression")*/
		public void verifyKiteLogoTest() 
		{
			boolean logo = login.verifyKiteLogo();
            Assert.assertTrue(logo);
		}
		@Test/*(groups = "Sanity")*/
		public void siginTest() throws Exception
		{
			login.signin();
		}
		@AfterMethod/*(groups = {"Sanity","Regression"})*/
		public void onTestFailure(ITestResult result) throws IOException
		{
			if(ITestResult.FAILURE==result.getStatus()) {
			TakeScreenShot.takeScreenShots(driver, result.getName());
			}
			driver.quit();
		}
		

	}
	