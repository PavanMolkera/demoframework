//
//package utils;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Iterator;
//
//public class ExcelUtils {
//    
//    private static final String FILE_PATH = "src/test/resources/testdata.xlsx";
//
//    public static Object[][] getTestData(String sheetName) {
//        Object[][] data = null;
//
//        try (FileInputStream fis = new FileInputStream(new File(FILE_PATH));
//             Workbook workbook = new XSSFWorkbook(fis)) {
//
//            Sheet sheet = workbook.getSheet(sheetName);
//            if (sheet == null) {
//                throw new RuntimeException("Sheet '" + sheetName + "' not found. Check for typos.");
//            }
//
//            int rowCount = sheet.getPhysicalNumberOfRows();
//            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//            data = new Object[rowCount - 1][colCount];
//
//            Iterator<Row> rowIterator = sheet.iterator();
//            rowIterator.next(); // Skip header row
//
//            int rowIndex = 0;
//            while (rowIterator.hasNext()) {
//                Row row = rowIterator.next();
//                for (int colIndex = 0; colIndex < colCount; colIndex++) {
//                    Cell cell = row.getCell(colIndex);
//                    data[rowIndex][colIndex] = getCellValueAsString(cell);
//                }
//                rowIndex++;
//            }
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to read Excel file: " + e.getMessage());
//        }
//        return data;
//    }
//
//    private static String getCellValueAsString(Cell cell) {
//        if (cell == null) {
//            return "";
//        }
//        switch (cell.getCellType()) {
//            case STRING:
//                return cell.getStringCellValue();
//            case NUMERIC:
//                return String.valueOf((int) cell.getNumericCellValue());
//            case BOOLEAN:
//                return String.valueOf(cell.getBooleanCellValue());
//            case FORMULA:
//                return cell.getCellFormula();
//            case BLANK:
//                return "";
//            default:
//                return "";
//        }
//    }
//}















package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelUtils {
    
    private static final String FILE_PATH = "src/test/resources/testdata.xlsx";

    public static Object[][] getTestData(String sheetName) {
        try (FileInputStream fis = new FileInputStream(new File(FILE_PATH));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet '" + sheetName + "' not found. Check for typos.");
            }

            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
            Object[][] data = new Object[rowCount - 1][colCount];

            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next(); // Skip header row

            int rowIndex = 0;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                for (int colIndex = 0; colIndex < colCount; colIndex++) {
                    Cell cell = row.getCell(colIndex);
                    data[rowIndex][colIndex] = getCellValueAsString(cell);
                }
                rowIndex++;
            }

            return data;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read Excel file: " + e.getMessage());
        }
    }

    private static String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "";
        }
    }
}










