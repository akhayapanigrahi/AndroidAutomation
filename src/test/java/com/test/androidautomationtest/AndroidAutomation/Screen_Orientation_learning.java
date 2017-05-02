package com.test.androidautomationtest.AndroidAutomation;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Screen_Orientation_learning {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		//Launch the app
		
				DesiredCapabilities capabilities= new DesiredCapabilities();
				
				capabilities.setCapability("deviceName","1c47b811");
				capabilities.setCapability("platformName","Android");
				capabilities.setCapability("platformVersion","5.1.1");
				
				
				capabilities.setCapability("appPackage","com.mobeta.android.demodslv");
				capabilities.setCapability("appActivity","com.mobeta.android.demodslv.Launcher");
						
				//appium server
				AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				
				//wait
				Thread.sleep(5000);
				
				driver.rotate(ScreenOrientation.LANDSCAPE);
				Thread.sleep(8000);
				
				driver.rotate(ScreenOrientation.PORTRAIT);
				Thread.sleep(8000);
				System.out.println("Screen is rotated");
				TakesScreenshot screenshot=(TakesScreenshot) driver;
				File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
				System.out.println(screenshotAs);
				
				FileUtils.copyFile(screenshotAs, new File("F:\\Akshaya\\Appium\\Shared Docs\\Code\\Screenshots\\ScreenRotated.png"));
				System.out.println("Screen shot is taken and kept in the mentioned location");
				
	}

}
