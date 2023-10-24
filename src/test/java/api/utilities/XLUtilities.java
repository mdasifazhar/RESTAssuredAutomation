package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.groovy.transform.FieldASTTransformation;

public class XLUtilities {
	
	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	public String path;
	
	public XLUtilities(String path) {
		this.path=path;
	}
	
	public int getRowCount(String sheetName) throws IOException{
		
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet= workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowCount;
	}
	public int getCellCount(String sheetName, int rowNum) throws IOException{
		
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet= workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellCount= row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellCount;
	}
	
	public String getCellData(String sheetName, int rowNum, int colNum) throws IOException{
		String data;
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet= workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		DataFormatter formatter = new DataFormatter();
		try {
		data =formatter.formatCellValue(cell);
		}catch(Exception e) {
			data="";
		}
		workbook.close();
		fis.close();
		return data;
	}
	
	public void setCellData(String sheetName,int rowNum, int colNum,String data) throws IOException{
		File file = new File(path);
		if(!file.exists()) {
			workbook= new XSSFWorkbook();
			fos= new FileOutputStream(file);
			workbook.write(fos);
		}
		
		fis= new FileInputStream(file);
		workbook= new XSSFWorkbook();
		
		if(workbook.getSheetIndex(sheetName)==-1)
			sheet= workbook.createSheet(sheetName);
		sheet= workbook.getSheet(sheetName);
		
		if(sheet.getRow(rowNum)==null)
			row= sheet.createRow(rowNum);
		row= sheet.getRow(rowNum);
		
		if(row.getCell(colNum)==null)
			cell= row.createCell(colNum);
		cell=row.getCell(colNum);
		
		fos= new FileOutputStream(path);
		workbook.write(fos);
		
		workbook.close();
		fis.close();
		fos.close();
		
	}
	

}
