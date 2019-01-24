package BaseScenario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass 
{
	public Properties ps;	
	public AppiumDriver<MobileElement> driver;
	
	@BeforeSuite
	@Parameters("cofig_file")
	public void set_up(@Optional("src/Utilities/Capability.properties")String congif_file) throws FileNotFoundException 
	{
		ps = new Properties();
		 InputStream input = new FileInputStream(congif_file);
        try {
			ps.load(input);
		} catch (IOException e) 
        {
			e.printStackTrace();
			System.out.println(e);
		}
        
	}
	@BeforeClass
	public void launch_app() throws Exception 
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName",ps.getProperty("DeviceName"));
		caps.setCapability("udid", ps.getProperty("Udid")); 
		caps.setCapability("platformName",ps.getProperty("platformName"));
		caps.setCapability("platformVersion", ps.getProperty("platformVersion"));
		caps.setCapability("appPackage", ps.getProperty("appPackage"));
		caps.setCapability("appActivity", ps.getProperty("appActivity"));
		caps.setCapability("noReset", ps.getProperty("noRest"));
		caps.setCapability("unicodeKeyboard", true);
		caps.setCapability("resetKeyboard", true);
		caps.setCapability("autoGrantPermissions","true");
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		
    }

	@AfterClass
	public void close()
	{
		driver.closeApp();
	}
	
}