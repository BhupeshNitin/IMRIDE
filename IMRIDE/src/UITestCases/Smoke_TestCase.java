package UITestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import BaseScenario.BaseClass;
import Locator.SearchResult;
import Utilities.ScreenShot;
import io.appium.java_client.MobileElement;


public class Smoke_TestCase extends BaseClass implements SearchResult
{	
	@Test(priority=1)
	public void Verify_Invalid_Number() throws Exception
	{
		try
		{
	driver.findElement(By.id("com.activescaler.imride:id/textView_selectedCountry")).click();	
	driver.findElement(By.id("com.activescaler.imride:id/editText_search")).sendKeys("Antarctica");
	driver.findElement(By.id("com.activescaler.imride:id/textView_countryName")).click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.id("com.activescaler.imride:id/frag_phone_no_et")).sendKeys("9999224733");
	driver.findElement(By.id("com.activescaler.imride:id/frag_phone_term_st")).click();
	driver.findElement(By.id("com.activescaler.imride:id/frag_phone_continue_bt")).click();	
	
	}
	catch(Exception e)
	{
	    ScreenShot.take_screenshot(driver);

	}
	}
	
	@Test(priority=2)
	public void Verify_Valid_Number() throws Exception
	{
		try
		{
	driver.findElement(By.id("com.activescaler.imride:id/textView_selectedCountry")).click();	
	driver.findElement(By.id("com.activescaler.imride:id/editText_search")).sendKeys("American Samoa");
	List<MobileElement> Code = driver.findElements(By.id("com.activescaler.imride:id/textView_code"));
	int size = Code.size();
	for(int i=0;i<size;i++)
	{
	String codenumber = Code.get(i).getText();
	if(codenumber.equals("+1"))
	{
		Code.get(i).click();
	}
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.id("com.activescaler.imride:id/frag_phone_no_et")).clear();
	driver.findElement(By.id("com.activescaler.imride:id/frag_phone_no_et")).sendKeys("1234567890");
//	driver.findElement(By.id("com.activescaler.imride:id/frag_phone_term_st")).click();
	driver.findElement(By.id("com.activescaler.imride:id/frag_phone_continue_bt")).click();	
	} 
     	}
	catch(Exception e)
	{
	    ScreenShot.take_screenshot(driver);

	}
	}
		
	@Test(priority=3)
	public void Verify_Resend_Number() throws Exception
	{	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("com.activescaler.imride:id/frag_phone_veri_code_et")).sendKeys("123456");
	}

	@Test(priority=4)
	public void VerifyNumber() throws Exception
	{ 
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).click();
		driver.findElement(By.id("com.activescaler.imride:id/search_side_user_iv")).click();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    String number = driver.findElement(By.id("com.activescaler.imride:id/phone_et")).getText();
		Assert.assertEquals(number, "+11234567890");
		
	}
	@Test(priority=5)
	public void CreateProfile() throws Exception
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.hideKeyboard();
		driver.findElement(By.id("com.activescaler.imride:id/name_et")).sendKeys("nitin");
		driver.findElement(By.id("com.activescaler.imride:id/male_radioBt")).click();
		scroll.scrollDown();
		driver.findElement(By.id("com.activescaler.imride:id/zipcode_et")).sendKeys("110006");
		driver.findElement(By.id("com.activescaler.imride:id/state_et")).sendKeys("Delhi");
		driver.findElement(By.id("com.activescaler.imride:id/city_et")).sendKeys("delhi");
		driver.findElement(By.id("com.activescaler.imride:id/street_address_et")).sendKeys("1447 1st floor old delhi");
		driver.findElement(By.id("com.activescaler.imride:id/profile_save")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("GoogleExchange")).click();
		Thread.sleep(2000);
	}
	@Test(priority=6)
	public void verify_profile()
	{
		String expectedemail = "nitin.vrm2@gmail.com";
		MobileElement email_text = (MobileElement)driver.findElement(By.id("com.activescaler.imride:id/email_et"));
		String actual_text = email_text.getText();
		softAssert.assertEquals(expectedemail,actual_text);
		softAssert.assertAll();
		
	}
	@Test(priority=7)
	public void search_source() throws Exception
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   	 driver.findElement(By.id("com.activescaler.imride:id/toolbar")).click();
    driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
		 MobileElement source  = driver.findElement(By.id("com.activescaler.imride:id/frag_search_from_et"));
		 source.click();
		 MobileElement departing  = driver.findElement(By.id("com.activescaler.imride:id/frag_depart_et"));
		 departing.sendKeys("Singapore Zoo"); 
	     Thread.sleep(10000);
	   	driver.findElement(By.id("com.activescaler.imride:id/secondary_address_tv")).click();
	   
	}
	@Test(priority=8)
	public void search_destination() throws Exception
	{
		driver.findElement(By.id("com.activescaler.imride:id/frag_search_where_et")).click();
		MobileElement where=driver.findElement(By.id("com.activescaler.imride:id/frag_depart_et"));
		     where.click();
			 where.sendKeys("tokyo international");
			 Thread.sleep(10000);
		  	driver.findElement(By.id("com.activescaler.imride:id/secondary_address_tv")).click();
	}
	@Test(priority=9)
	public void search_selecttime()
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id(calendar)).click();
		driver.findElement(By.xpath(loc_date)).click();
		driver.findElement(By.id("com.activescaler.imride:id/frag_cal_select_bt")).click();
		driver.findElement(By.id("android:id/button1")).click();
		
	}
	@Test(priority=10)
	public void search()
	{
		driver.findElement(By.id("com.activescaler.imride:id/frag_search_bt")).click();
	}
	@Test(priority=11)
	public void whyareyoutravelling() throws Exception
	{
		driver.findElement(By.id("com.activescaler.imride:id/frag_smart_search_bus")).click();
		driver.findElement(By.id("com.activescaler.imride:id/frag_why_are_you_select_btn")).click();
		Thread.sleep(8000);	
	}
	
	@Test(priority=12)
	public void select_trip()
	{
	List<MobileElement> search_result=driver.findElements(By.id("com.activescaler.imride:id/item_search_result_view"));
	int list = search_result.size();
	System.out.println(list);
	int c=0;
	for(int i=0;i<list;i++ )
	{
		c=c+1;
		if(c==2)
		{
			search_result.get(i).click();
		}
	}	
			
	}
	@Test(priority=13)
	public void booktrip()
	{
		scroll.scrollDown();
		scroll.scrollDown();
		driver.findElement(By.id("com.activescaler.imride:id/frag_plan_overview_book_btn")).click();
	}
	

	@Test(priority=14)
	public void add_travler()
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("com.activescaler.imride:id/frag_review_trip_traveler_info_bt")).click();
		List<MobileElement> trav=driver.findElements(By.id("com.activescaler.imride:id/item_traveler_list_checkbox"));
		int list = trav.size();
		System.out.println(list);
		int c=0;
		for(int i=0;i<list;i++ )
		{
			c=c+1;
			if(c==2)
			{
				trav.get(i).click();
			}
		}
	}
	@Test(priority=15)
	public void add_payment() throws Exception
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("com.activescaler.imride:id/frag_review_trip_payment_info_bt")).click();
		MobileElement trav=driver.findElement
		(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView"));
		trav.click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.activescaler.imride:id/item_choose_payment_cb")).click();
		driver.findElement(By.id("com.activescaler.imride:id/frag_choose_payment_select_btn")).click();
		driver.findElement(By.id("com.activescaler.imride:id/frag_review_trip_confirm_bt")).click();
		
	}
	
		
	
}	
