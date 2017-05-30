package com.actitime.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {

	String filePath = Constants.testDataFilePath;
public String getExcelData(String sheetName, int rowNum , int colNum) throws EncryptedDocumentException, InvalidFormatException, IOException{
	FileInputStream fis = new FileInputStream(filePath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	Row row = sh.getRow(rowNum);
	Cell cel = row.getCell(colNum);
	String data = cel.getStringCellValue();
	return data;
}

public int getRowCount(String sheetName) throws EncryptedDocumentException, InvalidFormatException, IOException{
	FileInputStream fis = new FileInputStream(filePath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	int rowCount = sh.getLastRowNum();
	return rowCount;
}

public void setExcelData(String sheetName, int rowNum , int colNum, String data) throws EncryptedDocumentException, InvalidFormatException, IOException{
	
	FileInputStream fis = new FileInputStream(filePath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	Row row = sh.getRow(rowNum);
	Cell cel = row.createCell(colNum);
	cel.setCellType(cel.CELL_TYPE_STRING);
	FileOutputStream fos = new FileOutputStream(filePath);
	cel.setCellValue(data);
	wb.write(fos);
	wb.close();
	
}










}
