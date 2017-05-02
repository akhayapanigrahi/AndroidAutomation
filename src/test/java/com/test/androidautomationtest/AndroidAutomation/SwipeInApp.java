package com.test.androidautomationtest.AndroidAutomation;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SwipeInApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		//Launch app
		//class              reference variable=Object
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		//device details
		capabilities.setCapability("deviceName","1c47b811");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","5.1.1");
		

		//app details
		capabilities.setCapability("appPackage","com.mobeta.android.demodslv");
		capabilities.setCapability("appActivity","com.mobeta.android.demodslv.Launcher");
		
		//Appium server details
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		//wait
		Thread.sleep(5000);
		
		        driver.findElementByXPath("//*[@index='3'][@class='android.app.ActionBar$Tab']").click();
				Thread.sleep(5000);
				Dimension size = driver.manage().window().getSize();
				System.out.println("Size is "+size);
				
				int Starty= (int)(size.height*0.90);
				System.out.println("Starty is "+Starty);
				
				int Endy=(int)(size.height*0.05);
				System.out.println("Endy is "+Endy);
						
				int Startx=(int)(size.width*0.50);
				System.out.println("Startx is "+Startx);
								
				Thread.sleep(5000);	
				
				WebElement ele_contact = driver.findElementByXPath("//*[@class='android.widget.TextView']");
				
				do
				{
					
					List<WebElement> ele_item1 = driver.findElementsByXPath("//*[@index='1'][@text='Badapua Chenai'][@class='android.widget.TextView']");
					int size2 = ele_item1.size();
					System.out.println(size2);
					Thread.sleep(3000);
				
					if(size2>0)
					{
						
						int Startx1=(int)(size.width*0.10);
						int Endx1=(int)(size.width*0.90);
						
						WebElement ele_item2 = driver.findElementByXPath("//*[@index='1'][@text='Badapua Chenai'][@class='android.widget.TextView']");
						int Starty1 = ele_item2.getLocation().getY();
						
						System.out.println("Found Office2");
						driver.swipe(Startx1, Starty1, Endx1, Starty1, 1000);
						break;
						
						
					}
				//Vertical swipe
				driver.swipe(Startx, Starty, Startx, Endy, 1000);
				Thread.sleep(2000);
				
				}	while(ele_contact.isDisplayed()==true);
				
				Thread.sleep(7000);
				
			    String Actual_Result = driver.findElementById("com.android.phone:id/callStateLabel").getText();
				System.out.println("Actual Result is "+Actual_Result);
				
				if(Actual_Result.contains("Dialling"))
				{
					System.out.println("Pass");
				}
				else
				{
					System.out.println("Fail");
				}
				
				

			}

		}
		
	