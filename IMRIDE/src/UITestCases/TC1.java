package UITestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import BaseScenario.BaseClass;
import Utilities.ScreenShot;

public class TC1 extends BaseClass
{	
	@Test
	public void Verify_Home_Page_Ui() throws Exception
	{
		try
		{
	driver.findElement(By.id("com.activescaler.imride:id/frag_phone_ccode_et")).setValue("91");
  	driver.findElement(By.id("com.activescaler.imride:id/frag_phone_no_et")).sendKeys("9999224733");
	driver.hideKeyboard();
	driver.findElement(By.id("com.activescaler.imride:id/frag_phone_term_st")).click();
	driver.findElement(By.id("com.activescaler.imride:id/frag_phone_continue_bt")).click();	
	
	}
	catch(Exception e)
	{
	    ScreenShot.take_screenshot(driver);

	}
	}
	@Test
	public void OTP_Verification() throws Exception
	{
		try
		{
	
	
	}
	catch(Exception e)
	{
	    ScreenShot.take_screenshot(driver);

	}
	}
	
}