package com.test.androidautomationtest.AndroidAutomation;

import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CallThroughSwipe {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		//device details
		capabilities.setCapability("deviceName","1c47b811");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","5.1.1");
		
		//app details
		capabilities.setCapability("appPackage","com.android.contacts");
		capabilities.setCapability("appActivity","com.android.contacts.activities.PeopleActivity");
		
		//Appium server details
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		//wait
		Thread.sleep(5000);
		
		driver.findElementByXPath("//*[@package='com.android.contacts'][@class='android.widget.LinearLayout']").click();
		
		
		//get the width and height
				Thread.sleep(5000);
				Dimension size = driver.manage().window().getSize();
				System.out.println("Size is "+size);
				
				int Starty= (int)(size.height*0.70);
				System.out.println("Starty is "+Starty);
				
				int Endy=(int)(size.height*0.10);
				System.out.println("Endy is "+Endy);
						
				int Startx=(int)(size.width*0.50);
				System.out.println("Startx is "+Startx);
								
				Thread.sleep(5000);	
				
				WebElement ele_contact = driver.findElementByXPath("//*[@class='android.view.View']");
				
				//driver.findElementByXPath("//*[@text='Badapua Chenai'][@class='android.view.View'][@package='com.android.contacts']").click();
				
				do
				{
					
				List<WebElement> ele_item1 = driver.findElementsByXPath("//*[@text='Jolly'][@class='android.widget.TextView']");
				int size2 = ele_item1.size();
				System.out.println(size2);
			     Thread.sleep(3000);
		
				if(size2>0)
				{
					
					int Startx1=(int)(size.width*0.10);
						int Endx1=(int)(size.width*0.90);
						
					WebElement ele_item2 = driver.findElementByXPath("//*[@text='Jolly'][@class='android.widget.TextView']");
					int Starty1 = ele_item2.getLocation().getY();
						
						System.out.println("Found Contact Jolly");
					driver.swipe(Startx1, Starty1, Endx1, Starty1, 1000);
					Thread.sleep(5000);

					ele_item2.click();
					//driver.findElementByXPath("//*[@id='com.android.contacts:id/data'][@class='android.widget.TextView']").click();
					//driver.findElementByXPath("//*[@id='com.android.contacts:id/primary_action_view'][@index='0'][@class='android.widget.LinearLayout']").click();
					driver.findElementById("com.android.contacts:id/primary_action_view").click();
					Thread.sleep(2000);
					driver.findElementById("com.android.incallui:id/sim1").click();


						break;
						
						
				}
				//Vertical swipe
				driver.swipe(Startx, Starty, Startx, Endy, 1000);
				Thread.sleep(2000);
				
				}	while(ele_contact.isDisplayed()==true);


				
				Thread.sleep(7000);
				
			   String Actual_Result = driver.findElementById("com.android.incallui:id/name").getText();
				System.out.println("Actual Result is "+Actual_Result);
				
				if(Actual_Result.contains("Jolly"))
				{
					System.out.println("Pass");
				}
				else
				{
					System.out.println("Fail");
				}
				
				

			}

}
		
	