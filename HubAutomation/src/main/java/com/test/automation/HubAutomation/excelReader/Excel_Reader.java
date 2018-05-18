package com.test.automation.HubAutomation.excelReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {
	
	public String path;
	public FileOutputStream  fileOut = null;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	public Excel_Reader(String path){
		this.path = path;
		try {
			
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	public String[][] getDataFromSheet( String excelName, String sheetName){
		
		String dataset[][] = null;
		
		
			try {
				
				XSSFSheet sheet = workbook.getSheet(sheetName);
				
				int totalRow = sheet.getLastRowNum() + 1;
				
				int totalColumn = sheet.getRow(0).getLastCellNum();
				
				dataset = new String[totalRow - 1][totalColumn];
				
				for (int i = 1; i < totalRow; i++){
					
					XSSFRow rows = sheet.getRow(i);
					
					for(int j = 0; j< totalColumn; j++ ){
						
						XSSFCell cell = rows.getCell(i);
						
						if(cell.getCellType() ==  cell.CELL_TYPE_STRING){
							dataset[i-1][j] = cell.getStringCellValue();
						}else if(cell.getCellType() == cell.CELL_TYPE_NUMERIC){
							dataset[i-1][j] =String.valueOf(cell.getNumericCellValue());
						}else{
							dataset[i-1][j] = String.valueOf(cell.getBooleanCellValue());
						}
					}
				}
				return dataset;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Error in reading excel file : "+e.getMessage());
				e.printStackTrace();
			}		
		
		return dataset;	
	}
	
	

}
