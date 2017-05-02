package com.test.androidautomationtest.AndroidAutomation;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WhatsApp_Message {
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
		
		driver.findElementById("com.whatsapp:id/search_src_text").sendKeys("Jolly Aircel");
		Thread.sleep(5000);
		driver.findElementByXPath("//*[@resource-id='com.whatsapp:id/conversations_row_contact_name'][@text='Jolly Aircel']").click();

		// In send keys, while passing double space, it is adding one "."
		driver.findElementById("com.whatsapp:id/entry").sendKeys("sending from code..dont b afraid..");
		driver.findElementById("com.whatsapp:id/send").click();
		Thread.sleep(3000);

		//Below code is to send a image from gallery
		driver.findElementByXPath("//*[@class='android.widget.ImageButton'][@index='1']").click();
		Thread.sleep(3000);
		driver.findElementById("com.whatsapp:id/pickfiletype_gallery").click();

		//Click on Photos
		driver.findElementByXPath("//*[@text='Camera photos'][@class='android.widget.TextView'][@index='1']").click();
		//Click on camera photos
		Thread.sleep(3000);
		/*List <WebElement> pic= driver.findElementsByXPath("//*[@id='com.whatsapp:id/thumbnail'][@class='android.widget.ImageView']");
		System.out.println("Size of the list is "+pic.size());
		pic.get(1).click(); */
		/*driver.findElementByXPath("//*[@text='Camera photos'][@id='com.whatsapp:id/title']").click();*/
		Thread.sleep(7000);

		List<WebElement> all_Photos = driver.findElementsByXPath("//*[@class='android.view.View']");
		System.out.println(all_Photos.size());
		
      if(all_Photos.size()>0){
    	  
    	  driver.findElementByXPath("//*[@index='6']").click();
  		Thread.sleep(10000);

    	  driver.findElementById("com.whatsapp:id/send").click();
	
}
	
		
		//Validation of Message sent
		/*String Expected="Hello Kan karucha from Automation code";
		List<WebElement> ele_cont = driver.findElementsById("com.whatsapp:id/message_text");
		System.out.println(ele_cont.size());
		
		int flag=0;//mismatch
		for(WebElement ele:ele_cont)
		{
			System.out.println(ele.getText());
			
			if(ele.getText().equals(Expected))
			{
				flag=1;//matching
				break;
			}
			else
			{
				flag=0;//mismatch
			}
			
		}
		
		
		if(flag==1)
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
	}*/

}
}
