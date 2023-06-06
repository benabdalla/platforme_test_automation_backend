package com.saphir.platforme.utils;

import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ExcelUtils {


    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;


    // This method is to set the File path and to open the Excel file, Pass Excel
    // Path and Sheetname as Arguments to this method

    public static void setExcelFile(String Path, String SheetName) throws Exception {

        try {

            // Open the Excel file

            FileInputStream ExcelFile = new FileInputStream(Path);
//add  b
            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);
//System.out.println("name feuille "+ExcelWSheet.getSheetName());
        } catch (Exception e) {

            throw (e);

        }

    }

    // This method is to read the test data from the Excel cell, in this we are
    // passing parameters as Row num and Col num


    public static String getCellData(int RowNum, int ColNum) throws Exception {

        try {

            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
/***********get string  cell only*******************/
            //String CellData = Cell.getStringCellValue();
/***********get formula cell ******************************/
            FormulaEvaluator evaluator = ExcelWBook.getCreationHelper().createFormulaEvaluator();
            CellValue cellValue = evaluator.evaluate(Cell);

            if (Cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
                //System.out.println("Cell formula value is  --> " + cellValue.getNumberValue()); // La valeur int de la formule
                int intCellData = (int) cellValue.getNumberValue();
                String CellData = Integer.toString(intCellData);
                return CellData;
            } else {
/***********get string and int cell only*******************/
                DataFormatter df = new DataFormatter();
                String CellData = df.formatCellValue(Cell);
                return CellData;
            }

        } catch (Exception e) {

            return "";

        }

    }

    public static String getCellData1(int RowNum, int ColNum) throws Exception {

        try {

            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
/***********get string  cell only*******************/
            //String CellData = Cell.getStringCellValue();
/***********get formula cell ******************************/
            FormulaEvaluator evaluator = ExcelWBook.getCreationHelper().createFormulaEvaluator();
            CellValue cellValue = evaluator.evaluate(Cell);

            if (Cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
                //System.out.println("Cell formula value is  --> " + cellValue.getNumberValue()); // La valeur int de la formule
                float intCellData = (float) cellValue.getNumberValue();
                String CellData = String.format("%.1f", intCellData);
                return CellData;
            } else {
/***********get string and int cell only*******************/
                DataFormatter df = new DataFormatter();
                String CellData = df.formatCellValue(Cell);
                return CellData;
            }

        } catch (Exception e) {

            return "";

        }

    }


    public static String getCellDate1(int RowNum, int ColNum, String languge) throws Exception {

        try {

            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
/***********get string  cell only*******************/
            //String CellData = Cell.getStringCellValue();
/***********get formula cell ******************************/
            FormulaEvaluator evaluator = ExcelWBook.getCreationHelper().createFormulaEvaluator();
            CellValue cellValue = evaluator.evaluate(Cell);

            if (Cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
                //System.out.println("Cell formula value is  --> " + cellValue.getNumberValue()); // La valeur int de la formule
                float intCellData = (float) cellValue.getNumberValue();
                String CellData = String.format("%.1f", intCellData);
                return CellData;
            } else {
/***********get string and int cell only*******************/

                if (languge == "fr") {


                    String dateexcel = cellValue.getStringValue();
                    DateTimeFormatter formatter_1 = DateTimeFormatter.ofPattern("d/MM/yyyy");
                    LocalDate local_date_1 = LocalDate.parse(dateexcel, formatter_1);
                    String date_string = formatter_1.format(local_date_1);

                    return date_string;

                } else {
                    String dateexcel = cellValue.getStringValue();
                    DateTimeFormatter formatter_1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                    LocalDate local_date_1 = LocalDate.parse(dateexcel, formatter_1);
                    String date_string = formatter_1.format(local_date_1);

                    return date_string;
                }
            }

        } catch (Exception e) {

            return "";

        }
    }


    //This method return numéro de ligne of given user

    public static int GetLigneData(String User) throws Exception {
        try {
            String detecteduser;
            int num_ligne = 0;
            do {
                num_ligne++;
                detecteduser = getCellData(num_ligne, 1);
            } while (!(detecteduser.equals(User) || detecteduser.equals("")));
            if (detecteduser.equals(User)) {
                return num_ligne;
            } else {
                return 0;
            }
        } catch (Exception e) {

            return 0;

        }


    }

    public static int GetLigneData1(String User) throws Exception {
        try {
            String detecteduser;
            int num_ligne = 0;
            do {
                num_ligne++;
                detecteduser = getCellData(num_ligne, 0);
            } while (!(detecteduser.equals(User) || detecteduser.equals("")));
            if (detecteduser.equals(User)) {
                return num_ligne;
            } else {
                return 0;
            }
        } catch (Exception e) {

            return 0;

        }


    }

    // This method is to write in the Excel cell, Row num and Col num are the
    // parameters

    public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {

        try {

            Row = ExcelWSheet.getRow(RowNum);

            Cell = Row.getCell(ColNum);

            //if (Cell == null) {

            Cell = Row.createCell(ColNum);

            Cell.setCellValue(Result);

            //} else {

            Cell.setCellValue(Result);

            //}

            // Constant variables Test Data path and Test Data file name

            /*FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);

            ExcelWBook.write(fileOut);

            fileOut.flush();

            fileOut.close();
*/
        } catch (Exception e) {

            throw (e);

        }

    }

    public static void setCellData1(String Result, int RowNum, int ColNum, String Path, String name) throws Exception {

        try {

            setExcelFile(Path, name);
            System.out.println("file name = " + ExcelWSheet.getSheetName());

            ExcelWSheet.getRow(RowNum).createCell(ColNum).setCellValue(Result);
            // here we need to specify where you want to save file

            // Constant variables Test Data path and Test Data file name

            FileOutputStream fileOut = new FileOutputStream(Path);

            ExcelWBook.write(fileOut);


            fileOut.close();

        } catch (Exception e) {

            throw (e);

        }

    }

    /*public static void setCellData1(String Result, int RowNum, int ColNum, String Path) throws Exception {

        try {
            FileInputStream inputStream = new FileInputStream(new File(Path));
            Workbook workbook = WorkbookFactory.create(inputStream);
                Row row = ExcelWSheet.createRow(RowNum);
                    org.apache.poi.ss.usermodel.Cell cell = row.createCell(ColNum);
            cell.setCellValue(Result);
            FileOutputStream outputStream = new FileOutputStream(Path);
            workbook.write(outputStream);
            outputStream.close();

        } catch (IOException | EncryptedDocumentException
                | InvalidFormatException ex) {
            ex.printStackTrace();
        }

    }*/


}
