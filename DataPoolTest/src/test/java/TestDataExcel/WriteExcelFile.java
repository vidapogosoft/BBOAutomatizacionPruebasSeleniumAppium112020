package TestDataExcel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcelFile {

    public void writeExcel(String filePath, String sheetName, String[] dataToWrite ) throws IOException
    {
        File file = new File(filePath);

        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);

        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);

        int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();

        XSSFRow row = newSheet.getRow(0);

        XSSFRow newRow = newSheet.createRow(rowCount+1);

        for(int i=0; i < row.getLastCellNum(); i++)
        {
            XSSFCell newCell = newRow.createCell(i);

            newCell.setCellValue(dataToWrite[i]);
        }

        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(file);

        newWorkbook.write(outputStream);

        outputStream.close();

    }

    public void writeCellValue(String filePath, String sheetName, int rowNumber,
                               int cellNumber, String resulText) throws IOException
    {

        File file = new File(filePath);

        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);

        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);

        XSSFRow row = newSheet.getRow(rowNumber);

        //XSSFCell firstCell = row.getCell(cellNumber-1);

        XSSFCell nextCell = row.createCell(cellNumber);

        nextCell.setCellValue(resulText);

        System.out.println(nextCell.getStringCellValue());

        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(file);

        newWorkbook.write(outputStream);

        outputStream.close();

    }

}
