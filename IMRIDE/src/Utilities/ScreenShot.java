package Utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ScreenShot 
{
	public static void take_screenshot(AppiumDriver<MobileElement> driver) throws Exception
	{
		String path = "C:\\Users\\nitin.thalia\\eclipse-workspace\\IMRIDE.zip_expanded\\IMRIDE\\shreenshot\\";	
		File filesrc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		DateFormat	dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		File targetFile=new File(path + dateFormat.format(new Date()) +".png");
		FileUtils.copyFile(filesrc, targetFile);
	}

}
