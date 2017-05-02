package com.test.androidautomationtest.AndroidAutomation;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Start_Stop_Appium {
	public static void main(String[] args) throws InterruptedException, IOException {
		//This code is not working
		//Provide the path of Node.exe and appium.js 
		String Start_Server="F:\\Appium\\node.exe F:\\Appium\\node_modules\\appium\\bin\\appium.js";
		 
		Process process = Runtime.getRuntime().exec(Start_Server);
		System.out.println(process);
		
		if(process!=null)
		{
			System.out.println("Started the appium Server");
		}
		else
		{
			System.out.println("NOT able to Start the Server");
		}
		
		Thread.sleep(20000);
	/*	================================================ */
				
DesiredCapabilities capabilities= new DesiredCapabilities();
		
		//device details
		capabilities.setCapability("deviceName","1c47b811");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","5.1.1");
		
		//app details
		capabilities.setCapability("appPackage","com.mobeta.android.demodslv");
		capabilities.setCapability("appActivity","com.mobeta.android.demodslv.Launcher");
		Thread.sleep(5000);

		//Appium server details
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		//wait
		Thread.sleep(5000);
		
		driver.findElementById("com.mobeta.android.demodslv:id/activity_title").click();
		List<WebElement> elements = driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle");
		//Drag and drop
		
		TouchAction action=new TouchAction(driver);
		action.longPress(elements.get(0)).moveTo(elements.get(5)).release().perform();
	
	
	}
	
}
