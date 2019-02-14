package UITestCases;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import BaseScenario.BaseClass;
import Utilities.ScreenShot;
import io.appium.java_client.MobileElement;



public class TC_VerificationScreenUI extends BaseClass
{	
	@Test(priority=1)
	public void Verify_Home_Page_Ui() throws Exception
	{
		try
		{
	driver.findElement(By.id("com.activescaler.imride:id/frag_phone_ccode_et")).setValue("1");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  	driver.findElement(By.id("com.activescaler.imride:id/frag_phone_no_et")).setValue("1234567890");
	driver.findElement(By.id("com.activescaler.imride:id/frag_phone_term_st")).click();
	driver.findElement(By.id("com.activescaler.imride:id/frag_phone_continue_bt")).click();	
	Thread.sleep(2000);
	}
	catch(Exception e)
	{
	    ScreenShot.take_screenshot(driver);

	}
	}
	@Test(priority=2)
	public void Verify_TextLabel() throws Exception
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("com.activescaler.imride:id/frag_phone_veri_code_et")).sendKeys("123456");
		MobileElement resendbutton = driver.findElement(By.id("	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);"));
		String button_Text = resendbutton.getText();
		if(button_Text.equalsIgnoreCase("RESEND CODE"));
		resendbutton.click();
	
	}
	@Test(priority=2)
	public void Verify_ButtonText() throws Exception
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("com.activescaler.imride:id/frag_phone_veri_code_et")).sendKeys("123456");
		MobileElement resendbutton = driver.findElement(By.id("	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);"));
		String button_Text = resendbutton.getText();
		if(button_Text.equalsIgnoreCase("RESEND CODE"));
		resendbutton.click();
	}
	@Test(priority=2)
	public void Verify_ButtonColour() throws Exception
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("com.activescaler.imride:id/frag_phone_veri_code_et")).sendKeys("123456");
		MobileElement resendbutton = driver.findElement(By.id("	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);"));
		String button_Text = resendbutton.getText();
		if(button_Text.equalsIgnoreCase("RESEND CODE"));
		resendbutton.click();
	}
	
}