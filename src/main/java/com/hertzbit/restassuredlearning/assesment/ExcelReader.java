package com.hertzbit.restassuredlearning.assesment;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static ArrayList<Object> getDataForTestCase (Map<String, Integer> rowColumnMap, 
			String fileName, String sheetName, String testCaseName) throws Exception {
		
		FileInputStream fileInputStream = new FileInputStream(fileName);
		XSSFWorkbook xssfWorkbook =  new XSSFWorkbook(fileInputStream);
		ArrayList<Object> inputDataList = new ArrayList<>();
		
		Iterator<Sheet> sheetIterator = xssfWorkbook.iterator();
		//int sheetIndex = 0;
		while(sheetIterator.hasNext()) {
			Sheet currentSheet = sheetIterator.next();
			if(currentSheet.getSheetName().equals(sheetName)) {
				//Post
				Integer rowNumber = rowColumnMap.get("row")+1;
				Integer columnNumber = rowColumnMap.get("column");
				
				Integer rowIndex = 0;
				Integer columnIndex = 0;
				
				Iterator<Row> rowIterator = currentSheet.iterator();
				while(rowIterator.hasNext())
				{
					if(rowIndex>=rowNumber) {
						Row currentRow = rowIterator.next();
						if(currentRow.getCell(columnNumber).toString().equals(testCaseName)) {
							columnNumber++;
							Iterator<Cell> cellIterator = currentRow.cellIterator();
							
							while(cellIterator.hasNext()) {
								
								if(columnIndex >= columnNumber) {
								Cell currentCell = cellIterator.next();
								if(currentCell.getCellType().equals(CellType.STRING)) {
									inputDataList.add(currentCell.getStringCellValue());
								}else {
								//Numeric
									String convertedCellValue = NumberToTextConverter.toText(
											currentCell.getNumericCellValue());
											inputDataList.add(convertedCellValue);
								}		
								columnIndex++;
					}else {
						cellIterator.next();
						columnIndex++;
					}
				}
			}
		   rowIndex++;
					}else {
						rowIterator.next();
						rowIndex++;
					}
				}
			}
		}	
		return inputDataList;
		//System.out.println(inputDataList);		
	}
		
		public static Map<String, Integer> searchForTestCase (String fileName,
				String sheetName, String testCaseLiteral) throws Exception{	
			Map<String, Integer>rowColumnMap = new HashedMap<>();	
			
		FileInputStream fileInputStream = new FileInputStream(fileName);		
		XSSFWorkbook xssfWorkbook =  new XSSFWorkbook(fileInputStream);
		
		int totalNumberofSheets = xssfWorkbook.getNumberOfSheets();
		
		//System.out.println("Total Number of Sheets : " + totalNumberofSheets);
		int columnNumber = -1;
		int rowNumber = -1;
		 for(int i=0; i< totalNumberofSheets; i++) {
			 if(xssfWorkbook.getSheetName(i).equalsIgnoreCase(sheetName)) { //"Post"
				 //System.out.println("Post Sheet is Found!");
				 
				 XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(i);		 
				 Iterator<Row> rowIterator = xssfSheet.rowIterator();
				 boolean isFound = false;
				 int rowIndex = 0;
				 while(rowIterator.hasNext()) {
					 Row currentRow = rowIterator.next();
					 Iterator<Cell> cellIterator = currentRow.cellIterator();
					 int columnIndex = 0;
					 while(cellIterator.hasNext()) {
						// System.out.println(cellIterator.next());//to print all the cell values					 
						 Cell currentCell = cellIterator.next();
					 if(currentCell.getStringCellValue().equals(testCaseLiteral)) 
						 { //"bookOne"
							 columnNumber = columnIndex;
							 isFound = true;
							 break;
						 }
						 columnIndex++;
					 }

					 if(isFound) {
						 rowNumber =  rowIndex;
					     break;
					 }
					 rowIndex++;
				 }
			 rowColumnMap.put("row", rowNumber);
			 rowColumnMap.put("column", columnNumber);
		//System.out.println("Row:" +rowNumber +" , Column :"+columnNumber);
				}
		}
		
		return rowColumnMap;
	
		}
	  }

