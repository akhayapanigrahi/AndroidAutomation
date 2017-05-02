package com.test.Calculator;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Baseclass {
	public static AndroidDriver driver;
	static String Appium_Node_Path="C:\\Program Files (x86)\\Appium\\node.exe";
    static String Appium_JS_Path="C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js";
    static AppiumDriverLocalService service;
    static String service_url;

    public static  void appiumStart() throws Exception{
        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().
                usingPort(4723).usingDriverExecutable(new File(Appium_Node_Path)).
                withAppiumJS(new File(Appium_JS_Path)));
        service.start();
        Thread.sleep(25000);
        service_url = service.getUrl().toString();
    }
    
	
	//Initialization of App
    
    public static void Init_App() throws MalformedURLException, InterruptedException
	{
     DesiredCapabilities capabilities= new DesiredCapabilities();
	
	//device details
	capabilities.setCapability("deviceName","1c47b811");
	capabilities.setCapability("platformName","Android");
	capabilities.setCapability("platformVersion","5.1.1");
	
	//app details
	capabilities.setCapability("appPackage","com.finance.emi.calculate");
	capabilities.setCapability("appActivity","com.finance.emi.calculate.activity.HomePageActivity");
	Thread.sleep(5000);

	//Appium server details
	AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	
	//wait
	Thread.sleep(5000);
	
	}
	//Stop server
	
    public  static void appiumStop() throws Exception{
        service.stop();

    }
}
