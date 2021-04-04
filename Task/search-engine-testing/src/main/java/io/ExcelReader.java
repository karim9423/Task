package io;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
 
public class ExcelReader {
   private XSSFWorkbook workbook;
    private XSSFSheet sheet;
 
    public ExcelReader(String excelFilePath,String sheetName)
    {
    	 File file = new File(excelFilePath);
         //Create an object of FileInputStream class to read excel file
		try (FileInputStream inputStream = new FileInputStream(file)){
         workbook=new XSSFWorkbook(inputStream);
         sheet = workbook.getSheet(sheetName);
         }
		catch (Exception e) {
			e.printStackTrace();
		}
    }

    public String getCellData(int rowNumber,int cellNumber,String sheetName){
    	  sheet=workbook.getSheet(sheetName);
       //getting the cell value from rowNumber and cell Number
         XSSFCell cell =sheet.getRow(rowNumber).getCell(cellNumber);
        
        //returning the cell value as string
        return cell.getStringCellValue();
    }

}
