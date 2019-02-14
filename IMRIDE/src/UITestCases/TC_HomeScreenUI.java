package UITestCases;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BaseScenario.BaseClass;
import Utilities.ScreenShot;
import io.appium.java_client.MobileElement;

public class TC_HomeScreenUI extends BaseClass
{
	@Test(priority=1,enabled=false)
	public void verify_homepageLogo()
	{
		// Need to work on this point
	}
	@Test(priority=2)
	public void verify_WelcomeText()
	{
		MobileElement welcometext = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]"));
		String WelcomeExpectedtext = "Start your journey today!";
		String WelcomeActualtext = welcometext.getText();
		softAssert.assertEquals(WelcomeActualtext, WelcomeExpectedtext);
		softAssert.assertAll();
	}
	@Test(priority=3,enabled=false)
	public void verify_HomepageText2()
	{
		MobileElement Welcometext = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]"));
		String WelcomeActualtext ="Sign in easily with just your phone number.No need to remember password!";
		String WelcomeExpectedtext = Welcometext.getText();
		System.out.println(WelcomeActualtext);
		softAssert.assertEquals(WelcomeActualtext, WelcomeExpectedtext);
		softAssert.assertAll();
	}
	
	@Test(priority=4)
	public void verify_homepageButtontext()
	{
		 MobileElement button = driver.findElement(By.id("com.activescaler.imride:id/frag_phone_continue_bt"));
		 String buttonActualtext="CONTINUE";
		 String buttonExpectedtext = button.getText();
		 System.out.println(buttonExpectedtext);
		 softAssert.assertEquals(buttonActualtext, buttonExpectedtext);
		 softAssert.assertAll();
	}
	@Test(priority=5)
	public void verify_Login() throws Exception
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
		catch (InterruptedException e) 
		{
			ScreenShot.take_screenshot(driver);
		}
	}
	@Test(priority=5)
	public void verify_VerificationCodeScreenUI() throws Exception
	{
		MobileElement resendbutton = driver.findElement(By.id("com.activescaler.imride:id/frag_phone_veri_resend_bt"));
		String Expectedtext = "	RESEND CODE";
		String Actualtext = resendbutton.getText();
		softAssert.assertEquals(Actualtext, Expectedtext,"this is soft assertion");
		softAssert.assertAll();	
	}
	@Test(priority=6)
	public void verify_VerificationCodetext() throws Exception
	{
		MobileElement resendbutton = driver.findElement(By.id("com.activescaler.imride:id/frag_phone_veri_resend_bt"));
		String Expectedtext = "	RESEND CODE";
		String Actualtext = resendbutton.getText();
		softAssert.assertEquals(Actualtext, Expectedtext,"this is soft assertion");
		softAssert.assertAll();	
	}
	
	
	@Test(priority=7)
	public void verify_VerificationCodeScreen() throws Exception
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.id("com.activescaler.imride:id/frag_phone_veri_code_et")).sendKeys("123456");
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			ScreenShot.take_screenshot(driver);
		}
	}
	
	
	

}
