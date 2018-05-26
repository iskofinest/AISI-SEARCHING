/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Forms.ProductsTable;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

/**
 *
 * @author IPC
 */
public class ExcelReportService {
    
    
    public static void printProducts(String[] columns, String[][] productData) {
        
        System.out.println("***************************************************");
        for(String[] row : productData) {
            int index = 0;
            for(int i=0; i<12; i++) {
                System.out.println(index + columns[index] + "" + row[i]);
                index += 1;
            }
        }
        System.out.println("***************************************************");
        
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sample Sheet");
        sheet.getPrintSetup().setLandscape(true);
        sheet.setColumnWidth(0, 4000);
        sheet.setColumnWidth(1, 4000);
        sheet.setColumnWidth(2, 8000);
        sheet.setColumnWidth(3, 4000);
        sheet.setColumnWidth(4, 4000);
        sheet.setColumnWidth(5, 4000);
        sheet.setColumnWidth(6, 4000);
        sheet.setColumnWidth(7, 4000);
        sheet.setColumnWidth(8, 4000);
        sheet.setColumnWidth(9, 4000);
        sheet.setColumnWidth(10, 4000);
        sheet.setColumnWidth(11, 4000);
        HSSFRow sheetRow;
        HSSFRow headerRow = sheet.createRow(0);
        for(int columnIndex=0; columnIndex<columns.length; columnIndex++) {
            HSSFCell cell = headerRow.createCell(columnIndex);
            HSSFCellStyle style = cell.getCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER);
            style.setVerticalAlignment(VerticalAlignment.CENTER);
            cell.setCellValue(columns[columnIndex]);
            System.out.println(cell.getStringCellValue());
        }
        
        for(int rowNumber=0; rowNumber<productData.length; rowNumber++) {
            sheetRow = sheet.createRow(rowNumber+1);
            String[] values = productData[rowNumber];
            for(int column=1; column<=values.length-1; column++) {
                HSSFCell cell = sheetRow.createCell(column-1, CellType.STRING);
                System.out.println(values[column-1]);
                String value = values[column-1].replace("\n", "");
                System.out.println(value);
                String message="", temp="";
                while(value.contains(" ")) {
                    temp = value.substring(0, value.indexOf(" ")) + " ";
                    if(temp.length()>40) {
                        message += "\n" + temp;
                    } else {
                        message += temp;
                    }
                    value = value.substring(value.indexOf(" ")+1);
                }
                message += value;
                
                
//                do {
//                    if(value.length()<1) break;
//                    if(value.length()>1 && value.contains(" ")) {
//                        message += value.substring(0, value.indexOf(" ")) + " ";
//                    } else if(value.length()>0 && !value.contains(" ")) {
//                        message += value;
//                        break;
//                    }
//                    value = value.substring(value.indexOf(" ")).trim();
//                    System.out.println(message);
//                }while(value.contains(" "));
//                StringTokenIterator str = new StringTokenIterator(values[column-1], " ");
//                while(str.hasNext()) {
//                    String temp = "";
//                    while(temp.length() < 100) {
//                        temp += String.valueOf(str.next()) + " ";
//                        System.out.println("|" + temp.trim() + "| : " + temp.length());
//                    }
//                    message += temp + "\n";
//                }
                cell.setCellValue(message);
//                cell.setCellValue(values[column-1]);
                HSSFCellStyle style = cell.getCellStyle();
                style.setWrapText(true);
                style.setAlignment(HorizontalAlignment.LEFT);
//                style.setBorderBottom(BorderStyle.THICK);
//                style.setBorderTop(BorderStyle.THICK);
//                style.setBorderRight(BorderStyle.THIN);
//                style.setBorderLeft(BorderStyle.THIN);
                style.setVerticalAlignment(VerticalAlignment.CENTER);
//                sheetRow.setRowStyle(style);
//                cell.setCellStyle(style);
            }
        }
        try {
            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\IPC\\Downloads\\sample.xls");
            workbook.write(fileOut);
            workbook.close();
            fileOut.close();
//            Runtime runTime = Runtime.getRuntime();
//            Process process = runTime.exec("C:\\Users\\IPC\\Downloads\\sample.xls");
            System.out.println("PRINT SUCCESSFULL!!");
            Desktop.getDesktop().open(new File("C:\\Users\\IPC\\Downloads\\sample.xls"));
            System.out.println("OPENED!!");
        } catch (IOException ex) {
            Logger.getLogger(ProductsTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
