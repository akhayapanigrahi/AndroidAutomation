package com.test.androidautomationtest.AndroidAutomation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Sms_learning {

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
		capabilities.setCapability("appPackage","com.android.mms");
		capabilities.setCapability("appActivity","com.android.mms.ui.MmsTabActivity");
		
		//Appium server details
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		//wait
		
		Thread.sleep(5000);
		
		String Exp_Result="8073099268";
		System.out.println("Expected Result is "+Exp_Result);
		
		//click on edit
		//tagname[@attributename='attribute vaue']
		//driver.fE("//tagname[@attributename='attribute vaue']")
		driver.findElementByXPath("//*[@index='0'][@class='android.widget.Button'][@text='Compose']").click();
			
		
		//Enter the number
		driver.findElementById("com.android.mms:id/recipients_editor").sendKeys("8073099268");
				
		//Enter msg
		driver.findElementById("com.android.mms:id/embedded_text_editor").sendKeys("Hi test");
		
		//click on send button
		driver.findElementById("com.android.mms:id/send_button").click();
		//Select SIM
				driver.findElementById("com.android.mms:id/sim2").click();

		Thread.sleep(5000);
		driver.findElementById("android:id/button1").click();
		//click on back
		/*The below driver.sendKeyEvent(AndroidKeyCode.BACK) will work in Appium 2.1.0 version
		But driver.pressKeyCode(66) will work in Appium 3.4.0*/

		//driver.sendKeyEvent(AndroidKeyCode.BACK);
		driver.pressKeyCode(66);

		Thread.sleep(3000);
		//get the output
		/*String Actual_Result = driver.findElementById("com.android.mms:id/from").getText();
		System.out.println("Actual Result is "+Actual_Result);
		
		//validate
		if(Actual_Result.equals(Exp_Result))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}*/
		
		List<WebElement> msg_cont = driver.findElementsById("com.android.mms:id/from");
		System.out.println(msg_cont.size());
		
		int flag=0;//mismatch
		
		//for(datatype refvarible: arrayname)
		for(WebElement element:msg_cont)
		{
			//System.out.println(element.getText());
			
			if((element.getText()).contains(Exp_Result))
			{
				
				flag=1;//matching
				break;
				
			}
			else
			{
				flag=0;
			}
			
		}
		
	
		if(flag==1)
		{
			System.out.println("Pass");
		}
		else if(flag==0)
		{
			System.out.println("Fail");
		}


	}

}
