package Day7;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Swithes1 {

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
		
		driver.scrollTo("Switches").click();
		
		Thread.sleep(4000);
		
		WebElement ele_item = driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]"
				+ "/UIATableView[1]/UIATableCell[1]/UIASwitch[1]");
		
		String init_val = ele_item.getAttribute("value");
		System.out.println("Initial value is "+init_val);
		
		Thread.sleep(4000);
		
		ele_item.click();
		
		Thread.sleep(4000);
		
		String Final_val = ele_item.getAttribute("value");
		System.out.println("Final_val value is "+Final_val);
		
		
		
		
		
		
		

	}

}
