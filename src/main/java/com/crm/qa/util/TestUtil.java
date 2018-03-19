package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	public static String TESTDATA_SHEET_PATH="/Users/Sateesh/eclipse-workspace/FreeCRMTest/src/main/java/com/crm/qa/testdata/FreeCRMTestData.xlsx";

	public void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
	}
	
	public static Object[][] getTestData(String sheetname) throws IOException{
		FileInputStream file = new FileInputStream(TESTDATA_SHEET_PATH);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		XSSFCell cell;
		int totalRows = sheet.getPhysicalNumberOfRows();
		int totalCols = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[totalRows-1][totalCols];
		for(int i=1; i<totalRows; i++) {
			for(int j=0; j<totalCols; j++) {
				cell = sheet.getRow(i).getCell(j);
				if(cell.getCellTypeEnum() == CellType.NUMERIC) {
					data[i-1][j] = String.valueOf((long)cell.getNumericCellValue());
				}
				else if(cell.getCellTypeEnum() == CellType.STRING) {
					data[i-1][j] = cell.getStringCellValue();
				}
			}
		}
		return data;
	}
}
