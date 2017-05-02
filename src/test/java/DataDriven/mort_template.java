package DataDriven;

import io.appium.java_client.android.AndroidDriver;

public class mort_template {
	
	
	public String EMI(AndroidDriver driver,String Amount, String Tenure, String Interest ) throws InterruptedException
	{
		driver.findElementById("com.boondoggle.mortcalc:id/var_amount").sendKeys(Amount);
		driver.findElementById("com.boondoggle.mortcalc:id/var_years").sendKeys(Tenure);
		driver.findElementById("com.boondoggle.mortcalc:id/var_interest").sendKeys(Interest);
		
		driver.findElementById("com.boondoggle.mortcalc:id/buttoncalc").click();
		
		Thread.sleep(2000);
		
		String Output = driver.findElementById("com.boondoggle.mortcalc:id/var_mortgage").getText();
		String Actual_Result = Output.replace("$", "");
		
		return Actual_Result;
		
		
	}

}
