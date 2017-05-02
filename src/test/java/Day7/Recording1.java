package Day7;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Recording1 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Rajesh Iphone");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"ios");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9.3.5");
		
		capabilities.setCapability("udid","499ae5ae6d066971991c5d27e8fbff07899a489d");
		capabilities.setCapability("bundleId","com.example.apple-samplecode.UICatalog");
		
		AppiumDriver driver= new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[5]/UIAStaticText[1]")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
