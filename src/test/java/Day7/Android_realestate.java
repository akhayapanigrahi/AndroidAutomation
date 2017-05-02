package Day7;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Android_realestate {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "GT-I9300I");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		
		capabilities.setCapability("appPackage", "com.boondoggle.mortcalc");
		capabilities.setCapability("appActivity", "com.boondoggle.mortcalc.MortCalc");
		
		AppiumDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		//Identify Price element and enter values
				driver.findElementById("com.boondoggle.mortcalc:id/var_amount").sendKeys("10000");
				//IdentifyYears and enter values
				driver.findElementById("com.boondoggle.mortcalc:id/var_years").sendKeys("5");
				//Identify Interest and enter values
				driver.findElementById("com.boondoggle.mortcalc:id/var_interest").sendKeys("12");
				
				//Identify  element and click on the btn
				driver.findElementById("com.boondoggle.mortcalc:id/buttoncalc").click();
				
				//get the output
				String Output = driver.findElementById("com.boondoggle.mortcalc:id/var_mortgage").getText();
				System.out.println(Output);
				
				String Actual_Res = Output.replace("$", "");
				System.out.println(Actual_Res);
				
				String Expected_Res="222.44";
				//Validate
				if(Actual_Res.equals(Expected_Res))
				{
					System.out.println("Pass");
				}
				else
				{
					System.out.println("Fail");
				}
				

	}

}
