package com.excelplugin;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelPlugin {
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static String testcaseName;
    public void loadExcelFile() throws IOException {
        File file=new File("src/main/resources/testdata/Testdata.xlsx");
        FileInputStream fileInputStream=new FileInputStream(file);
        workbook=new XSSFWorkbook(fileInputStream);
    }

    public int getRowCount(String sheet){
        return workbook.getSheet(sheet).getLastRowNum();
    }
    public int getColCount(String sheet){
        return workbook.getSheet(sheet).getRow(0).getLastCellNum();
    }

    public int searchTestCase(String sheet,String testcase){
        int rows=getRowCount(sheet);
int rowfound=0;
        for(int r=1;r<=rows;r++){

            String currentTest=workbook.getSheet(sheet).getRow(r).getCell(0).getStringCellValue();
            if(testcase.equals(currentTest.trim())){
                rowfound= r;
                break;
            }

        }
return rowfound;
    }

    public int searchColumn(String sheet,String column){
        int cols=getColCount(sheet);
        int colFound=0;
        for(int c=1;c<=cols-1;c++){

            String cuurentCol=workbook.getSheet(sheet).getRow(0).getCell(c).getStringCellValue();
            if(column.equals(cuurentCol.trim())){
                colFound= c;
                break;
            }

        }
        return colFound;
    }

    public String getData(String sheet,String column){
        String data="";
        int row=searchTestCase(sheet,testcaseName);
        int col=searchColumn(sheet,column);
        switch (workbook.getSheet(sheet).getRow(row).getCell(col).getCellType()){
            case STRING:
                data=  workbook.getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
                break;
            case NUMERIC:
                data=  String.valueOf(workbook.getSheet(sheet).getRow(row).getCell(col).getNumericCellValue());
                break;
        }
        return data;
    }
}
