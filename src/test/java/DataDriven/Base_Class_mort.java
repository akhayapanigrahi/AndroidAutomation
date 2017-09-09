package DataDriven;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Base_Class_mort {
	
	public static Process process;
	public static AndroidDriver driver;
	static String Appium_Node_Path="C:\\Program Files (x86)\\Appium\\node.exe";
    static String Appium_JS_Path="C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js";
    static AppiumDriverLocalService service;
    static String service_url;
	public static void Start_Server() throws IOException, InterruptedException
	{
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().
                usingPort(4723).usingDriverExecutable(new File(Appium_Node_Path)).
                withAppiumJS(new File(Appium_JS_Path)));
        service.start();
        Thread.sleep(25000);
        service_url = service.getUrl().toString();
	}
	
	public static void Init_App() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		//device details
		capabilities.setCapability("deviceName","1c47b811");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","5.1.1");
		
		//app details
		capabilities.setCapability("appPackage","com.boondoggle.mortcalc");
		capabilities.setCapability("appActivity","com.boondoggle.mortcalc.MortCalc");
		
		
		//Appium server details
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		//wait
	 
		
		Thread.sleep(5000);
		
	}
	
	
	public static void Stop_Server() throws InterruptedException
	{
						
		        service.stop();

		    }

}
