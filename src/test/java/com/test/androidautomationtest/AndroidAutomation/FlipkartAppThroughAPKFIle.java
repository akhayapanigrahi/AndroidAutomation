package com.test.androidautomationtest.AndroidAutomation;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class FlipkartAppThroughAPKFIle {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub
		
		
		File app= new File("F:\\Akshaya\\Appium\\Shared Docs\\Code\\APKFiles\\Flipkart_5.9_APKTrunkFlipkart_5.9_APKTrunk.apk");
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
				System.out.println("FlipkartApp  is installed");
				
				driver.removeApp("com.mobeta.android.demodslv");
				System.out.println("FlipkartApp Removed");
				Thread.sleep(8000);
				
				driver.installApp("F:\\Akshaya\\Appium\\Shared Docs\\Code\\APKFiles\\Flipkart_5.9_APKTrunkFlipkart_5.9_APKTrunk.apk");
				System.out.println("FlipkartApp Again installed");
				Thread.sleep(8000);
				
			}
			else
			{
				System.out.println("FlipkartApp NOT installed");
			}

	}

}
