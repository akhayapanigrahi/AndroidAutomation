package com.test.androidautomationtest.AndroidAutomation;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WhatsApp_Click_Camera {
	public static int RESULT_LOAD_IMG = 1;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		//device details
		capabilities.setCapability("deviceName","1c47b811");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","5.1.1");
		
		//app details
		capabilities.setCapability("appPackage","com.whatsapp");
		capabilities.setCapability("appActivity","com.whatsapp.HomeActivity");
		
		//Appium server details
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		//wait
		Thread.sleep(10000);
		
		//Go to Whats App, search contact,send a message, validate message recieved
		//driver.findElementById("com.whatsapp:id/menuitem_search").sendKeys("Jolly");
		driver.findElementByXPath("//*[@resource-id='com.whatsapp:id/menuitem_search'][@class='android.widget.TextView'][@index='0']").click();
		
		driver.findElementById("com.whatsapp:id/search_src_text").sendKeys("Satyajit Whtsapp");
		Thread.sleep(5000);
		driver.findElementByXPath("//*[@resource-id='com.whatsapp:id/conversations_row_contact_name'][@text='Satyajit Whtsapp']").click();
		Thread.sleep(5000);
		 driver.findElementByXPath("//*[@resource-id='com.whatsapp:id/camera_btn']").click();
		 driver.findElementByXPath("//*[@resource-id='com.whatsapp:id/shutter']").click();
		 Thread.sleep(2000);
		 driver.findElementByXPath("//*[@resource-id='com.whatsapp:id/send']").click();

		
}
	
		
		

}
