/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Product;
import Entities.Supplier;
//import Mapper.ExcelReportServiceMapper;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 *
 * @author IPC
 */
public class ExcelReportService{
    
    static String[] columns = new String[]{"REFERENCE", "ITEM", "DESCRIPTION", "BRAND", "MODEL", 
                "QTY / Unit" , "QUOTATION DATE", "ORIGINAL PRICE", "AGENT", "SUPPLIER NAME",
            "CONTACT PERSON","CONTACT DETAILS"};
    
    public static void printProducts(String filePath, String[][] productData) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Product Report Sheet");
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
                cell.setCellValue(message);
                HSSFCellStyle style = cell.getCellStyle();
                style.setWrapText(true);
                style.setAlignment(HorizontalAlignment.LEFT);
                style.setVerticalAlignment(VerticalAlignment.CENTER);

            }
        }
        try { 
            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
            String fileName = dt1.format(new Date()) + ".xls";
            FileOutputStream fileOut = new FileOutputStream(filePath + "\\" + fileName);
            workbook.write(fileOut);
            workbook.close();
            fileOut.close();
            System.out.println("PRINT SUCCESSFULL!!");
            File reportFile = new File(filePath + "\\" + fileName);
            Desktop.getDesktop().open(reportFile);
            System.out.println("OPENED!!");
        } catch (IOException ex) {
            Logger.getLogger(ExcelReportService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void printSingleProduct(String filePath, Product product) {
        String data[] = new String[12];
        data[0] = product.getTransaction().getReferenceNumber();
        data[1] = product.getName();
        data[2] = product.getDescription().trim();
        data[3] = product.getBrand();
        data[4] = product.getModel();
        data[5] = product.getQuantity() + " "+ product.getUnit();
        data[6] = String.valueOf(product.getProduct_date());
        data[7] = String.valueOf(product.getOriginalPrice());
        data[8] = product.getAgent();
        data[9] = ((Supplier) product.getSuppliers().toArray()[0]).getName().trim();
        data[10] = ((Supplier) product.getSuppliers().toArray()[0]).getContactPerson().trim();
        data[11] = ((Supplier) product.getSuppliers().toArray()[0]).getContactDetails().trim();
        
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(product.getName());
        HSSFRow sheetRow;
        // selecting the region in Worksheet for merging data
        CellRangeAddress regionText = CellRangeAddress.valueOf("B2:C2");
        CellRangeAddress regionHeader = CellRangeAddress.valueOf("B3:C3");
        // merging the region
        sheet.addMergedRegion(regionText);
        sheet.addMergedRegion(regionHeader);
        HSSFCell headerText = sheet.createRow(1).createCell(1);
        HSSFCell headerName = sheet.createRow(2).createCell(1);
        headerText.setCellValue("REPORT FOR");
        HSSFCellStyle headerTextStyle = headerText.getCellStyle();
        headerTextStyle.setAlignment(HorizontalAlignment.CENTER);
        headerName.setCellValue(product.getName());
        sheet.autoSizeColumn(1, true);
        sheet.autoSizeColumn(2, true);
        sheet.autoSizeColumn(3, true);
        int rowIndex = 4;
        sheet.setColumnWidth(2, 8000);
        sheet.setColumnWidth(1, 8000);
        sheet.setColumnWidth(3, 8000);
        for(int i=0; i<columns.length; i++){
            HSSFRow row = sheet.createRow(rowIndex++);
            HSSFCell cellTitle = row.createCell(1);
            HSSFCell cellValue = row.createCell(2);
            cellTitle.setCellValue(columns[i]);
            cellValue.setCellValue(data[i]);
            CellStyle style = cellValue.getCellStyle();
            style.setWrapText(true);
            style.setVerticalAlignment(VerticalAlignment.CENTER);
            style.setAlignment(HorizontalAlignment.LEFT);
            CellStyle labelStyle = cellValue.getCellStyle();
            labelStyle.setWrapText(true);
            labelStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            labelStyle.setAlignment(HorizontalAlignment.LEFT);
        }

        try {
            String fileName = product.getName() + ".xls";
            FileOutputStream fileOut = new FileOutputStream(filePath + "\\" + fileName);
            workbook.write(fileOut);
            workbook.close();
            fileOut.close();
            Desktop.getDesktop().open(new File(filePath + "\\" + fileName));
        } catch (IOException ex) {
            Logger.getLogger(ExcelReportService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
