package com.qa.demoblaze.testdata;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DemoBlaze_SupplyTestData {
	public static Properties dataprop;
	public static FileInputStream ip1;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	
	public DemoBlaze_SupplyTestData() throws Exception {
		
		dataprop = new Properties();
		ip1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\demoblaze\\configurations\\testData.properties");
		dataprop.load(ip1);
	}
	
	@DataProvider(name = "DemoBlazeCredentialsDataProviderSupply")
	public static Object[][] dataSupplyFrom2DimentionalObjectArray(){
		Object [][] data = {{dataprop.getProperty("dataProviderUsername1"), dataprop.getProperty("dataProviderPassword1")},
				            {dataprop.getProperty("dataProviderUsername2"), dataprop.getProperty("dataProviderPassword2")},
				            {dataprop.getProperty("dataProviderUsername3"), dataprop.getProperty("dataProviderPassword3")},
				            {dataprop.getProperty("dataProviderUsername4"), dataprop.getProperty("dataProviderPassword4")},
				            {dataprop.getProperty("dataProviderUsername5"), dataprop.getProperty("dataProviderPassword5")}};
		return data;
}
	@DataProvider(name = "DemoBlazeCrendtialsExcelSheetWithDataProviderSupply")
	public static Object [][] excelSheetDataSupply() throws Exception{
	Object[][]data = DemoBlaze_SupplyTestData.getDemoBlazeTestDataFromExcellSheet("Login");
	return data;
}
	
    public static Object[][] getDemoBlazeTestDataFromExcellSheet(String sheetName) throws Exception{
		ip1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\qa\\demoblaze\\testdata\\DemoBlaze TestData.xlsx");
		workbook = new XSSFWorkbook(ip1) ;
		sheet = workbook.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows][cols];
		
		for(int i=0; i<rows; i++) {
			XSSFRow row = sheet.getRow(i+1);
			 
			for(int j=0; j<cols; j++) {
				XSSFCell cell = row.getCell(j);
				CellType celltype = cell.getCellType();
				
				switch(celltype) {
				
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
					
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					break;
					
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				}
			}
		}
		return data;
		
		
		}
	}
	
	


	
