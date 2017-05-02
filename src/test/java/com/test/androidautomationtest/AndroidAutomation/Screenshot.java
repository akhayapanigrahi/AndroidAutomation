package com.test.androidautomationtest.AndroidAutomation;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Screenshot {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName","1c47b811");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","5.1.1");
		
		//app details
		capabilities.setCapability("appPackage","com.android.mms");
		capabilities.setCapability("appActivity","com.android.mms.ui.MmsTabActivity");
				
				//Appium server details
				AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				
				Thread.sleep(5000);
				TakesScreenshot screenshot=(TakesScreenshot) driver;
				File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
				System.out.println(screenshotAs);
				
				FileUtils.copyFile(screenshotAs, new File("F:\\Akshaya\\Appium\\Shared Docs\\Code\\Screenshots\\ResultMessage.png"));
				System.out.println("Screen shot is taken and kept in the mentioned location");
	}

}
