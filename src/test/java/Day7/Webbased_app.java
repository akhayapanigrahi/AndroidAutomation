package Day7;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Webbased_app {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Rajesh Iphone");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"ios");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9.3.5");
		
		capabilities.setCapability("udid","499ae5ae6d066971991c5d27e8fbff07899a489d");
		capabilities.setCapability("bundleId","TAmobiletest.safarlauncher");
		
		AppiumDriver driver= new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		Set<String> contextHandles = driver.getContextHandles();
		System.out.println(contextHandles.size());
		
		for(String contextname:contextHandles)
		{
			System.out.println(contextname);
			
			if(contextname.contains("WEBVIEW"))
			{
				driver.context(contextname);
			}
			
			
		}
		
		driver.get("http://www.google.com");
		
		Thread.sleep(5000);
		
		driver.findElementById("lst-ib").sendKeys("Sachin");
		driver.findElementById("tsbb").click();
		
		Thread.sleep(9000);
		
		String Actual_Result = driver.findElementByXPath("//span[contains(text(),'Cricketer')]").getText();
		System.out.println("Actual Result is "+Actual_Result);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
