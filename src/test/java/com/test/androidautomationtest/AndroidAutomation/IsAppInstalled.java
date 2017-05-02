package com.test.androidautomationtest.AndroidAutomation;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class IsAppInstalled {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		File app= new File("F:\\Akshaya\\Appium\\Shared Docs\\Code\\APKFiles\\Drag-Sort Demos_0.5.0_apk-dl.com.apk");
		DesiredCapabilities capabilities= new DesiredCapabilities();
	
	//device details
	capabilities.setCapability("deviceName","1c47b811");
	capabilities.setCapability("platformName","Android");
	capabilities.setCapability("platformVersion","5.1.1");
	
	//app details
	capabilities.setCapability("app",app.getAbsolutePath());
	
	//Appium server details
			AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			
			//wait
			
			Thread.sleep(8000);
	if(driver.isAppInstalled("com.mobeta.android.demodslv"))
	{
		Thread.sleep(5000);
		System.out.println("App is installed");
		
		driver.removeApp("com.mobeta.android.demodslv");
		System.out.println("Removed the App");
		Thread.sleep(8000);
		
		driver.installApp("F:\\Akshaya\\Appium\\Shared Docs\\Code\\APKFiles\\Drag-Sort Demos_0.5.0_apk-dl.com.apk");
		System.out.println("Again installed");
		Thread.sleep(8000);
		
	}
	else
	{
		System.out.println("NOT installed the App");
	}
}


}