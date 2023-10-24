package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException{
		String path= System.getProperty("user.dir")+"//testData//UserData.xlsx";
		XLUtilities util= new XLUtilities(path);
		int rowNum=util.getRowCount("Sheet1");
		int colNum= util.getCellCount("Sheet1", rowNum);
		String [][]data = new String[rowNum][colNum];
		
		for(int i=1;i<=rowNum;i++) {
			for(int j=0;j<colNum;j++) {
				data[i-1][j]=util.getCellData("Sheet1", i, j);
				System.out.println(data[i-1][j]);
			}
		}
		
		return data;
	}
	
	@DataProvider(name="UserNames")
	public String[] getUserName() throws IOException{
		String path=System.getProperty("user.dir")+"//testData//UserData.xlsx";
		XLUtilities util= new XLUtilities(path);
		int rowNum=util.getRowCount("Sheet1");
		String [] data= new String[rowNum];
		for(int i=1;i<=rowNum;i++) {
		data[i-1]= util.getCellData("Sheet1", i, 1);
		System.out.println(data[i-1]);
		}
		return data;
	}
}
