package com.test.Calculator;

import io.appium.java_client.android.AndroidDriver;

public class mort_template {
	
	
	public String calculateEMI(AndroidDriver driver,String Amount, String Tenure, String Interest ) throws InterruptedException
	{
		
		driver.findElementById("com.finance.emi.calculate:id/principal").sendKeys(Amount);
		driver.findElementById("com.finance.emi.calculate:id/interest").sendKeys(Interest);
		driver.findElementById("com.finance.emi.calculate:id/loan_tenure").sendKeys(Tenure);
		driver.findElementById("com.finance.emi.calculate:id/calculate").click();

		
		String output = driver.findElementById("com.finance.emi.calculate:id/emi").getText();
		String Actual_Result=output.replace("$", "");
		return Actual_Result;
		
		
	}
	
	
	
	
}
