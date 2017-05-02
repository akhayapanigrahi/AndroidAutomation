package com.test.androidautomationtest.AndroidAutomation;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Facebook {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {

		
DesiredCapabilities capabilities= new DesiredCapabilities();
		
		//device details
		capabilities.setCapability("deviceName","1c47b811");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","5.1.1");
		
		//app details
		capabilities.setCapability("appPackage","com.facebook.katana");
		capabilities.setCapability("appActivity","com.facebook.LoginActivity");
		
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		Thread.sleep(10000);
		
		driver.findElementById("com.facebook.katana:id/login_username").clear();
		driver.findElementById("com.facebook.katana:id/login_username").sendKeys("akshaya.panigrahi85@gmail.com");
		driver.findElementById("com.facebook.katana:id/login_password").sendKeys("symphonyteleca@9");
		driver.findElementById("com.facebook.katana:id/login_login").click();
		Thread.sleep(10000);

		
		
		
		
		
		

	}

}
