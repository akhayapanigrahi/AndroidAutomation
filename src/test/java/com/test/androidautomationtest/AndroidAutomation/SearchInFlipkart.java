package com.test.androidautomationtest.AndroidAutomation;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SearchInFlipkart {

	//public static void main(String[] args) throws MalformedURLException, InterruptedException {
	@Test
	public void searchShoes() throws InterruptedException, MalformedURLException{
		// TODO Auto-generated method stub
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		//device details
		capabilities.setCapability("deviceName","1c47b811");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","5.1.1");
		//App details
		capabilities.setCapability("appPackage","com.flipkart.android");
		capabilities.setCapability("appActivity","com.flipkart.android.activity.HomeFragmentHolderActivity");
		//Appium server details
				AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				
				//wait
				WebDriverWait wait=new WebDriverWait(driver, 10);
				WebElement ele_serchtxtbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.flipkart.android:id/search_widget_textbox")));
				System.out.println(ele_serchtxtbox.isDisplayed());
				ele_serchtxtbox.click();
				Thread.sleep(5000);
				//Here /n is used to press enter
				driver.findElementById("com.flipkart.android:id/search_autoCompleteTextView").sendKeys("Reebok Shoes"+"\n");
				Thread.sleep(10000);
				Dimension size = driver.manage().window().getSize();
				System.out.println(size);
				
				int Starty=(int)(size.height*0.90);
				int Endy=(int)(size.height*0.10);
				
				int Startx=(int)(size.width*0.50);
				WebElement ele_item = driver.findElementByXPath("//*[@class='android.widget.TextView']");				
				
				do{
					List elements = driver.findElementsByXPath("//*[@index='2'][@class='android.widget.TextView'][@text='Reebok ZEST Running Shoes']");
					
					int size2 = elements.size();
					System.out.println(size2);
					Thread.sleep(3000);
					
					if(size2>0){
						driver.findElementByXPath("//*[@index='2'][@class='android.widget.TextView'][@text='Reebok ZEST Running Shoes']").click();
						break;
						
					}
					driver.swipe(Startx, Starty, Startx, Endy, 1000);
					Thread.sleep(2000);
				} while(ele_item.isDisplayed()==true);
				Thread.sleep(7000);
				
				WebDriverWait wait2= new WebDriverWait(driver, 35);
			//	WebElement ele_Buy = wait2.until(ExpectedConditions.presenceOfElementLocated(By.id("com.flipkart.android:id/product_buynow_1")));
				WebElement ele_Buy = wait2.until(ExpectedConditions.presenceOfElementLocated(By.id("com.flipkart.android:id/product_buynow_1")));
				System.out.println(ele_Buy.isDisplayed());
				ele_Buy.click();
				Thread.sleep(4000);
				
				driver.findElementByXPath("//*[@index='0'][@text='7'][@class='android.widget.TextView']").click();
				driver.findElementById("com.flipkart.android:id/continue_variant").click();
				
				Thread.sleep(12000);
				String Actual_Result = driver.findElementById("com.flipkart.android:id/title_action_bar").getText();
				
				System.out.println(Actual_Result);
				
				
				
	}
				
				
	}


