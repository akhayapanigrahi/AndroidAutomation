package DataDriven;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;

public class driver_mort extends Base_Class_mort {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		Start_Server();
		Init_App();
		
		mort_template c1= new mort_template();
		
		ExcelReadWrite xl= new ExcelReadWrite("F:\\Akshaya\\Appium\\Shared Docs\\Code\\ExcelFiles\\EMI_Data1.xls");
		HSSFSheet Sheet1 = xl.Setsheet("Sheet1");
		
		int RowCount = xl.getrowcount(Sheet1);
		System.out.println(RowCount);
		
		for(int i=1;i<=RowCount;i++)
		{
			String Amount = xl.Readvalue(Sheet1, i, "Amount");
			String Interest = xl.Readvalue(Sheet1, i, "Interest");
			String Tenure = xl.Readvalue(Sheet1, i, "Tenure").replace(".0", "");
			String Exp_Result = xl.Readvalue(Sheet1, i, "Exp_Result");
			
		
			String Actual_Res = c1.EMI(driver, Amount, Tenure, Interest);
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
		
		
		xl.save_excel("F:\\Akshaya\\Appium\\Shared Docs\\Code\\ExcelFiles\\EMI_Data1.xls");
		
		Stop_Server();
		
		
	}

}
