package utils;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Tetiana_Matiunina on 09.12.2015.
 */
public class ExcelReader {

    private static final Logger LOGGER = Logger.getLogger(ExcelReader.class);

    public static String[][] excelRead(String filePath, String sheetName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet worksheet = workbook.getSheet(sheetName);
        int rowNum = worksheet.getLastRowNum() + 1;
        int colNum = worksheet.getRow(0).getLastCellNum();
        String value;
        String[][] data = new String[(rowNum)][colNum];
        for (int i = 0; i < rowNum; i++) {
            Row row = worksheet.getRow(i);
            for (int j = 0; j < colNum; j++) {
                Cell cell = row.getCell(j);
                try {
                    value = cellToString(cell);
                } catch (IllegalArgumentException ex) {
                    LOGGER.error("Error at try to convert cell to string. Error message: " + ex.getMessage(), ex);
                    throw  new IllegalArgumentException("Error at try to convert cell to string. Error message: " + ex.getMessage(), ex);
                }
                data[i][j] = value;
                LOGGER.debug("The value from excel is " + value);
            }
        }
        return data;

    }

    public static String cellToString(Cell cell) {
        int type;
        Object result;
        type = cell.getCellType();
        switch (type) {
            case 0:
                result = Math.round(cell.getNumericCellValue());
                break;
            case 1:
                result = cell.getStringCellValue();
                break;
            default:
                throw new IllegalArgumentException("There are no support for this type of cell");
        }
        return result.toString();
    }
}