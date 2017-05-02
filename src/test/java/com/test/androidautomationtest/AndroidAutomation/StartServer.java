package com.test.androidautomationtest.AndroidAutomation;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class StartServer {
	static String Appium_Node_Path = "C:\\Program Files (x86)\\Appium\\node.exe";
	static String Appium_JS_Path = "C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js";
	static AppiumDriverLocalService service;
	static String service_url;

	public static void main(String[] args) throws Exception {
		StartServer sv=new StartServer();
		sv.appiumStart();
		sv.ExecuteCode();
		sv.appiumStop();
		
	}
	/* To execute this code Add  this Maven dependency
	 * <!--  <dependency>
    <groupId>io.appium</groupId>
    <artifactId>java-client</artifactId>
    <version>3.4.0</version>
</dependency> -->

*/
	public void appiumStart() throws Exception {
		service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder().usingPort(4723)
						.usingDriverExecutable(new File(Appium_Node_Path))
						.withAppiumJS(new File(Appium_JS_Path)));
		service.start();
		Thread.sleep(25000);
		service_url = service.getUrl().toString();
	}
	public void ExecuteCode() throws InterruptedException,
			MalformedURLException {

		String AppPath = "‪‪D:\\seleniumworkspace\\appium\\src\\base.apk";
		
		File app = new File(AppPath);

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Galaxy S5");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "6.0.1");
		
		capabilities.setCapability("app", app.getAbsolutePath());

		System.out.println(app.getAbsolutePath());

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		Thread.sleep(8000);

		driver.findElementById("com.davemorrissey.labs.subscaleview.sample:id/basicFeatures").click();
		Thread.sleep(3000);

		List<WebElement> ele_cont = driver.findElementsById("com.mobeta.android.demodslv:id/text");
		System.out.println(ele_cont.size());

		TouchAction action = new TouchAction(driver);

		action.longPress(ele_cont.get(0)).moveTo(ele_cont.get(5)).release()
				.perform();

		Thread.sleep(8000);

	}

	
	public  void appiumStop() throws Exception{
        service.stop();

    }
}
