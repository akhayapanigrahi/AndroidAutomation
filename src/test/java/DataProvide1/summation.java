package DataProvide1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

public class summation {
	
	
	@DataProvider(name="dp_Sum")
	public static Iterator<Object[]> gettestdata() throws IOException
	{
		ExcelReadWrite xl= new ExcelReadWrite("F:\\Akshaya\\Appium\\Shared Docs\\Code\\Mobile_8_Apr_2017\\Mobile_8_Apr_2017\\Sum1.xls");
		HSSFSheet Sheet1 = xl.Setsheet("Sheet1");
		
		int RowCount = xl.getrowcount(Sheet1);
		System.out.println(RowCount);
		
		//Create a list of object array
		
		List<Object[]> arr_list= new ArrayList<Object[]>();
		
		for(int i=1;i<=RowCount;i++)
		{
			Map<String,String> dMap= new HashMap<String,String>();
			
			dMap.put((xl.Readvalue(Sheet1, 0, "Num1")), (xl.Readvalue(Sheet1, i, "Num1")));
			dMap.put(xl.Readvalue(Sheet1, 0, "Num2"), (xl.Readvalue(Sheet1, i, "Num2")));
			dMap.put(xl.Readvalue(Sheet1, 0, "Exp_Result"), (xl.Readvalue(Sheet1, i, "Exp_Result")));
			
			//create the object array of size 1
			Object[] x=new Object[1];
			x[0]=dMap;
			//add the the array to list
			arr_list.add(x);
			
		}
		
		return arr_list.iterator();
		
	}
	

}
