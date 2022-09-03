package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {

	@Test
	public void softAssert()
	{
		System.out.println("Test1 started");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(5<2, true);
		System.out.println("Test1 ended");
		sa.assertAll();
	}
	@Test
	public void hardAssert()
	{
		System.out.println("Test2 started");
		Assert.assertEquals("Java", "Selenium", "JAVA==JAVA");
		System.out.println("Test2 ended");
		
	}
}
