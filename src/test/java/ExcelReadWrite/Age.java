package ExcelReadWrite;

import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;

public class Age {

	public static void main(String[] args) throws IOException {
		
		ReadingExcelData xl= new ReadingExcelData("F:\\Akshaya\\Appium\\Shared Docs\\Code\\ExcelFiles\\Age.xls");
		
		HSSFSheet Sheet1 = xl.Setsheet("Sheet1");
		
		int Rowcount = xl.getrowcount(Sheet1);
		System.out.println(Rowcount);
		
		for(int i=1;i<=Rowcount;i++)
		{
			String Age = xl.Readvalue(Sheet1, i, "Age");
			double Age_Final=Double.parseDouble(Age);
			
			if(Age_Final>=18)
			{
				xl.writecell(Sheet1, i, "Status", "Major");
			}
			else
			{
				xl.writecell(Sheet1, i, "Status", "Minor");
			}
			
		}//end of forloop
		
		xl.save_excel("F:\\Akshaya\\Appium\\Shared Docs\\Code\\ExcelFiles\\Age.xls");
		

	}

}

