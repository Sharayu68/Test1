package TestCases;

    import org.testng.annotations.AfterMethod;
    import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
    import Pages.DashboardPage;
    import Pages.LoginPage;

	public class DashboardTest extends DashboardPage {
		
		DashboardPage dp;
		LoginPage login;

		@BeforeMethod 
		public void setup() throws Exception
		{
			intialization();
			dp = new DashboardPage();
			login = new LoginPage();
			login.signin();
		}
		@Test(enabled = false, priority = 0)
		public void displayNameTest() throws InterruptedException
		{
			String value = dp.displayName();
			System.out.println(value);
		}
		@Test(enabled = false, priority = 1)
		public void displayAvatarTest() throws InterruptedException
		{
			System.out.println(dp.displayAvatar());
		}
		@Test(enabled = false, priority = 2)
		public void displayProfileTest() throws InterruptedException
		{
			System.out.println(dp.displayProfile());
		}
		@Test(enabled = false, priority = 3)
		public void startInvestingTest() throws InterruptedException
		{
			dp.startInvesting();
		}
		@Test(enabled = false, priority = 4)
		public void buttonTest() throws InterruptedException
		{
			dp.startInvesting(); 
			dp.button();
			System.out.println(dp.button());
		}
		@Test(priority = 5, enabled = true)
		public void activateTest() throws InterruptedException
		{
			dp.activate();
		}

		@AfterMethod
		public void exit()
		{
//			try {
//				driver.close();
//			}
//			catch(Exception e)
//			{}
			driver.quit();
		}

	}
