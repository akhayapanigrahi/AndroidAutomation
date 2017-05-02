package com.test.Calculator;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;

public class CalculatorTest extends Baseclass{

	public static void main(String[] args) throws Exception {
		
		appiumStart();
		Init_App();
		CalculatorTest test=new CalculatorTest();
		test.caluclate();

	}
	
	public void caluclate() throws IOException, InterruptedException{
		mort_template temp=new mort_template();
		ExcelReadWrite xl= new ExcelReadWrite("F:\\Akshaya\\Appium\\Shared Docs\\Code\\26-Mar-17_Mobile\\26-Mar-17_Mobile\\EMI_Data1.xls");
		HSSFSheet Sheet1 = xl.Setsheet("Sheet1");
		
		int RowCount = xl.getrowcount(Sheet1);
		System.out.println(RowCount);
		for(int i=1;i<=RowCount;i++)
		{
			String Amount = xl.Readvalue(Sheet1, i, "Amount");
			String Interest = xl.Readvalue(Sheet1, i, "Interest");
			String Tenure = xl.Readvalue(Sheet1, i, "Tenure").replace(".0", "");
			String Exp_Result = xl.Readvalue(Sheet1, i, "Exp_Result");
			
			String Actual_Res =temp.calculateEMI(driver, Amount, Tenure, Interest);

			xl.writecell(Sheet1, i, "Actual_Result", Actual_Res);
			
			if(Actual_Res.equals(Exp_Result))
			{
				xl.writecell(Sheet1, i, "Status", "Pass");
			}
			else
			{
				xl.writecell(Sheet1, i, "Status", "Fail");
			}
			
		}//for loop end
		
		
		xl.save_excel("D:\\EMI_Data1.xls");
	}

	
}
