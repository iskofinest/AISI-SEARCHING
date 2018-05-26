/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Product;
import Entities.Supplier;
import Entities.Transactions;
import absoluteindustrialsolutions.absoluteindustrialsolutions.AbsoluteIndustrialSolutions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author IPC
 */
public class ReadDataService {
    static String message = "";
    
    public static String getString(Cell cell, int index) {
        String value = "";
        
        switch(cell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING:
                value = cell.getStringCellValue();
                break;

            case HSSFCell.CELL_TYPE_NUMERIC:
                if(index == 1) value = String.valueOf(cell.getDateCellValue());
                else value = String.valueOf(cell.getNumericCellValue());
                break;

            case HSSFCell.CELL_TYPE_BOOLEAN:
                value = String.valueOf(cell.getBooleanCellValue());
                break;
        }
        return value.replace("\"", "");
    }
    
    public static double getInt(Cell cell, int index) {
        double value = 0;
        
        try{
            switch(cell.getCellType()) {
                case HSSFCell.CELL_TYPE_STRING:
                    value = Integer.parseInt(cell.getStringCellValue());
                    break;

                case HSSFCell.CELL_TYPE_NUMERIC:
                    value = cell.getNumericCellValue();
                    break;
            }
        }catch(NumberFormatException exception) {
            String number = "";
            String cellValue = cell.getStringCellValue();
            for(int i=0; i<cellValue.length()-1; i++) {
                char c = cellValue.charAt(i);
                if(Character.isDigit(c)) {
                    number += String.valueOf(c);
                }
            }
            value = Double.parseDouble(number);
            Logger.getLogger(AbsoluteIndustrialSolutions.class.getName()).log(Level.SEVERE, null, exception);
        }
        return value;
    }
    
    public static String getXLSXString(Cell cell, int index) {
        String value = "";
        
        switch(cell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING:
                value = cell.getStringCellValue();
                break;

            case HSSFCell.CELL_TYPE_NUMERIC:
                if(index == 1) value = String.valueOf(cell.getDateCellValue());
                else value = String.valueOf(cell.getNumericCellValue());
                break;

            case HSSFCell.CELL_TYPE_BOOLEAN:
                value = String.valueOf(cell.getBooleanCellValue());
                break;
        }
        return value.replace("\"", "");
    }
    
    public static double getXLSXInt(Cell cell, int index) {
        double value = 0;
        
        try{
            switch(cell.getCellType()) {
                case XSSFCell.CELL_TYPE_STRING:
                    value = Integer.parseInt(cell.getStringCellValue());
                    break;

                case XSSFCell.CELL_TYPE_NUMERIC:
                    value = cell.getNumericCellValue();
                    break;
            }
        }catch(NumberFormatException exception) {
            String number = "";
            String cellValue = cell.getStringCellValue();
            for(int i=0; i<cellValue.length()-1; i++) {
                char c = cellValue.charAt(i);
                if(Character.isDigit(c)) {
                    number += String.valueOf(c);
                }
            }
            value = Double.parseDouble(number);
            Logger.getLogger(AbsoluteIndustrialSolutions.class.getName()).log(Level.SEVERE, null, exception);
        }
        return value;
    }
    
    public static Date getDate(Cell cell, int index) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        try {
            switch(cell.getCellType()) {
                case HSSFCell.CELL_TYPE_STRING:
                    date = cell.getDateCellValue();
                    break;

                case HSSFCell.CELL_TYPE_NUMERIC:
                    date = cell.getDateCellValue();
                    break;
            }
        } catch(IllegalStateException ex) {
            message += ex.toString() +"\n";
            Logger.getLogger(AbsoluteIndustrialSolutions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Date(sdf.format(date));
    }
    public static Date getXLSXDate(Cell cell, int index) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        try {
            switch(cell.getCellType()) {
                case XSSFCell.CELL_TYPE_STRING:
                    date = cell.getDateCellValue();
                    break;

                case XSSFCell.CELL_TYPE_NUMERIC:
                    date = cell.getDateCellValue();
                    break;
            }
        } catch(IllegalStateException ex) {
            message += ex.toString() +"\n";
            Logger.getLogger(AbsoluteIndustrialSolutions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Date(sdf.format(date));
    }
    
    
    public static void readXLSData(FileInputStream xlsFile){
        try {
            FileWriter writer = null;
            File errorMessageFile = new File("ErrorMessageFile");
            writer = new FileWriter(errorMessageFile);
        
        /*******************************READING AND SAVING DATA PURPOSE*******************************************/
        try{
            HSSFWorkbook book;
//            file = new File("D:\\Downloads\\JHipster Tutorial\\AISIData.xls");
            book = new HSSFWorkbook(xlsFile);
            HSSFSheet sheet = book.getSheetAt(0);
            Iterator<Row> rowItr = sheet.rowIterator();
            rowItr.next();
            int index = 0;
            int rowIndex = 0;
//            System.out.println("BLANK:" + HSSFCell.CELL_TYPE_BLANK);
//            System.out.println("BOOLEAN:" + HSSFCell.CELL_TYPE_BOOLEAN);
//            System.out.println("ERROR:" + HSSFCell.CELL_TYPE_ERROR);
//            System.out.println("FORMULA:" + HSSFCell.CELL_TYPE_FORMULA);
//            System.out.println("NUMERIC:" + HSSFCell.CELL_TYPE_NUMERIC);
//            System.out.println("STRING:" + HSSFCell.CELL_TYPE_STRING);
            
            while(rowItr.hasNext()) {
                message += "ROWINDEX: " + rowIndex;
                System.out.println("ROWINDEX: " + rowIndex++);
                Product product = new Product();
                String reference = "";
                String name = "";
                String category = "";
                String description = "";
                String brand = "";
                String model = "";
                int quantity = 0;
                String unit = "";
                Date product_date = new Date();
                String factor = "";
                BigDecimal originalPrice = new BigDecimal(0);
                BigDecimal sellingPrice = new BigDecimal(0);
                String agent = "";
                
                Supplier supplier = new Supplier();
                String supplierName = "";
                String contactPerson = "";
                String contactDetails = "";
                index = 0;
                Row rows = rowItr.next();
                Iterator<Cell> cells = rows.cellIterator();
                while(cells.hasNext()) {
                    Cell cell = cells.next();
                    System.out.print(index + ": ");
                    message += index + ": ";
                    switch(index) {
                        case 0:
                            System.out.print("REFERENCE: ");
                            message += "REFERENCE: ";
                            reference = String.valueOf(getString(cell, index));
                            break;
                            
                        case 1:
                            System.out.print("DATE: ");
                            message += "DATE: ";
                            product_date = getDate(cell, index);
                            break;
                            
                        case 2:
                            System.out.print("NAME: ");
                            message += "NAME: ";
                            name = String.valueOf(getString(cell, index));
                            break;
                            
                        case 3:
                            System.out.print("CATEGORY: ");
                            message += "CATEGORY: ";
                            category = String.valueOf(getString(cell, index));
                            break;
                            
                        case 4:
                            System.out.print("DESCRIPTION: ");
                            message += "DESCRIPTION: ";
                            description = String.valueOf(getString(cell, index)); 
                            System.out.println("DESCRIPTION LENGTH: " + description.length());
                            message += "DESCRIPTION LENGTH: " + description.length() + "\n";
                            if(description.length()>250) {
                                description = description.substring(0, 251);
                            }
                            break;
                            
                        case 5:
                            System.out.print("BRAND: ");
                            message += "BRAND: ";
                            brand = String.valueOf(getString(cell, index));
                            break;
                            
                        case 6:
                            System.out.print("MODEL: ");
                            message += "MODEL: ";
//                            switch(cell.getCellType()) {
//                                case HSSFCell.CELL_TYPE_NUMERIC:
//                                    model = getString(cell, index);
//                                    break;
//                                    
//                                case HSSFCell.CELL_TYPE_STRING:
//                                    model = cell.getStringCellValue();
//                                    break;
//                            }
                            model = String.valueOf(getString(cell, index));
                            break;
                            
                        case 7:
                            System.out.print("SUPPLIER: ");
                            message += "SUPPLIER: ";
                            supplierName = String.valueOf(getString(cell, index));
                            break;
                            
                        case 8:
                            System.out.print("CONTACT PERSON: ");
                            message += "CONTACT PERSON: ";
                            contactPerson = String.valueOf(getString(cell, index));
                            break;
                            
                        case 9:
                            System.out.print("CONTACT DETAILS: ");
                            message += "CONTACT DETAILS: ";
                            contactDetails = String.valueOf(getString(cell, index));
                            if(contactDetails.length()>250) {
                                contactDetails = contactDetails.substring(0, 251);
                            }
                            break;
                            
                        case 10:
                            System.out.print("ORIGINAL PRICE: ");
                            message += "ORIGINAL PRICE: ";
                            try {
                                originalPrice = BigDecimal.valueOf(getInt(cell, index));
                            } catch(NumberFormatException ex) {
                                System.out.println(ex.toString());
                            }
                            break;
                            
                        case 11:
                            System.out.print("FACTOR: ");
                            message += "FACTOR: ";
                            factor = String.valueOf(getString(cell, index));
                            break;
                            
                        case 12:
                            System.out.print("SELLING PRICE: ");
                            message += "SELLING PRICE: ";
                            try {
                                sellingPrice = BigDecimal.valueOf(getInt(cell, index));
                            } catch(NumberFormatException ex) {
                                System.out.println(ex.toString());
                                Logger.getLogger(AbsoluteIndustrialSolutions.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                            
                        case 13:
                            System.out.print("QUANTITY: ");
                            message += "QUANTITY: ";
                            String value = getString(cell, index);
                            try {
                                quantity = Integer.parseInt(value.substring(0, value.indexOf(" ")));
                                unit = value.substring(value.lastIndexOf(" ")+1);
                            }catch(StringIndexOutOfBoundsException ex) {
                                System.out.println(ex.toString());
                                Logger.getLogger(AbsoluteIndustrialSolutions.class.getName()).log(Level.SEVERE, null, ex);
                            } catch(NumberFormatException ex) {
                                System.out.println(ex.toString());
                                Logger.getLogger(AbsoluteIndustrialSolutions.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                            
                        case 14:
                            System.out.print("AGENT: ");
                            message += "AGENT: ";
                            agent = String.valueOf(getString(cell, index));
                            break;
                            
                    }
                    switch(cell.getCellType()) {
                        case HSSFCell.CELL_TYPE_STRING:
                            System.out.println(cell.getStringCellValue());
                            message += cell.getStringCellValue() + "\n";
                            break;

                        case HSSFCell.CELL_TYPE_NUMERIC:
                            if(index == 1 ) {
                                System.out.println(cell.getDateCellValue());
                                message += cell.getDateCellValue() + "\n";
                            }
                            else {
                                System.out.println(cell.getNumericCellValue());
                                message += cell.getNumericCellValue() + "\n";
                            }
                            break;

                        case HSSFCell.CELL_TYPE_BOOLEAN:
                            System.out.println(cell.getBooleanCellValue());
                            message += cell.getBooleanCellValue() + "\n";
                            break;
                    }
                    index++;
                }
                Transactions transaction = new Transactions();
                transaction.setReferenceNumber(reference);
                supplier = new Supplier(supplierName, contactPerson, contactDetails);
                product = new Product(name, category, description, brand, model, quantity, unit, product_date, factor, originalPrice, sellingPrice, agent);
                TransactionServices.saveTransaction(transaction, product, supplier);
//                Set<Supplier> suppliers = product.getSupplier();
//                suppliers.add(supplier);
//                product.setSupplier(suppliers);
//                ProductService.createProduct(product, supplier);
//                ProductService.createProduct(reference, name, category, description, brand, model, quantity, unit, product_date, factor, originalPrice, sellingPrice, agent, supplier);
                System.out.println("");
                message += "\n";
            }
            
        } catch(Exception e) {
            System.out.println(e.toString());
            message += e.toString() + "\n";
            Logger.getLogger(AbsoluteIndustrialSolutions.class.getName()).log(Level.SEVERE, null, e);
    }
            
    /*******************************READING AND SAVING DATA PURPOSE*******************************************/
            writer.write(message);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(AbsoluteIndustrialSolutions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void readXLSXData(FileInputStream xlsxFile){
        System.out.println("XLSXDATA");
        System.out.println("XLSXDATA");
        System.out.println("XLSXDATA");
        System.out.println("XLSXDATA");
        System.out.println("XLSXDATA");
        System.out.println("XLSXDATA");
        System.out.println("XLSXDATA");
        System.out.println("XLSXDATA");
        try {
            FileWriter writer = null;
            File errorMessageFile = new File("ErrorMessageFile");
            writer = new FileWriter(errorMessageFile);
        
        /*******************************READING AND SAVING DATA PURPOSE*******************************************/
        try{
            XSSFWorkbook book = new XSSFWorkbook(xlsxFile);
            XSSFSheet sheet = book.getSheetAt(0);
            Iterator<Row> rowItr = sheet.rowIterator();
            rowItr.next();
            int index = 0;
            int rowIndex = 0;
//            System.out.println("BLANK:" + HSSFCell.CELL_TYPE_BLANK);
//            System.out.println("BOOLEAN:" + HSSFCell.CELL_TYPE_BOOLEAN);
//            System.out.println("ERROR:" + HSSFCell.CELL_TYPE_ERROR);
//            System.out.println("FORMULA:" + HSSFCell.CELL_TYPE_FORMULA);
//            System.out.println("NUMERIC:" + HSSFCell.CELL_TYPE_NUMERIC);
//            System.out.println("STRING:" + HSSFCell.CELL_TYPE_STRING);
            
            while(rowItr.hasNext()) {
                message += "ROWINDEX: " + rowIndex;
                System.out.println("ROWINDEX: " + rowIndex++);
                Product product = new Product();
                String reference = "";
                String name = "";
                String category = "";
                String description = "";
                String brand = "";
                String model = "";
                int quantity = 0;
                String unit = "";
                Date product_date = new Date();
                String factor = "";
                BigDecimal originalPrice = new BigDecimal(0);
                BigDecimal sellingPrice = new BigDecimal(0);
                String agent = "";
                
                Supplier supplier = new Supplier();
                String supplierName = "";
                String contactPerson = "";
                String contactDetails = "";
                index = 0;
                Row rows = rowItr.next();
                Iterator<Cell> cells = rows.cellIterator();
                while(cells.hasNext()) {
                    Cell cell = cells.next();
                    System.out.print(index + ": ");
                    message += index + ": ";
                    switch(index) {
                        case 0:
                            System.out.print("REFERENCE: ");
                            message += "REFERENCE: ";
                            reference = String.valueOf(getXLSXString(cell, index));
                            break;
                            
                        case 1:
                            System.out.print("DATE: ");
                            message += "DATE: ";
                            product_date = getXLSXDate(cell, index);
                            break;
                            
                        case 2:
                            System.out.print("NAME: ");
                            message += "NAME: ";
                            name = String.valueOf(getXLSXString(cell, index));
                            break;
                            
                        case 3:
                            System.out.print("CATEGORY: ");
                            message += "CATEGORY: ";
                            category = String.valueOf(getXLSXString(cell, index));
                            break;
                            
                        case 4:
                            System.out.print("DESCRIPTION: ");
                            message += "DESCRIPTION: ";
                            description = String.valueOf(getXLSXString(cell, index)); 
                            System.out.println("DESCRIPTION LENGTH: " + description.length());
                            message += "DESCRIPTION LENGTH: " + description.length() + "\n";
                            if(description.length()>250) {
                                description = description.substring(0, 251);
                            }
                            break;
                            
                        case 5:
                            System.out.print("BRAND: ");
                            message += "BRAND: ";
                            brand = String.valueOf(getXLSXString(cell, index));
                            break;
                            
                        case 6:
                            System.out.print("MODEL: ");
                            message += "MODEL: ";
//                            switch(cell.getCellType()) {
//                                case HSSFCell.CELL_TYPE_NUMERIC:
//                                    model = getString(cell, index);
//                                    break;
//                                    
//                                case HSSFCell.CELL_TYPE_STRING:
//                                    model = cell.getStringCellValue();
//                                    break;
//                            }
                            model = String.valueOf(getXLSXString(cell, index));
                            break;
                            
                        case 7:
                            System.out.print("SUPPLIER: ");
                            message += "SUPPLIER: ";
                            supplierName = String.valueOf(getXLSXString(cell, index));
                            break;
                            
                        case 8:
                            System.out.print("CONTACT PERSON: ");
                            message += "CONTACT PERSON: ";
                            contactPerson = String.valueOf(getXLSXString(cell, index));
                            break;
                            
                        case 9:
                            System.out.print("CONTACT DETAILS: ");
                            message += "CONTACT DETAILS: ";
                            contactDetails = String.valueOf(getXLSXString(cell, index));
                            if(contactDetails.length()>250) {
                                contactDetails = contactDetails.substring(0, 251);
                            }
                            break;
                            
                        case 10:
                            System.out.print("ORIGINAL PRICE: ");
                            message += "ORIGINAL PRICE: ";
                            try {
                                originalPrice = BigDecimal.valueOf(getXLSXInt(cell, index));
                            } catch(NumberFormatException ex) {
                                System.out.println(ex.toString());
                            }
                            break;
                            
                        case 11:
                            System.out.print("FACTOR: ");
                            message += "FACTOR: ";
                            factor = String.valueOf(getXLSXString(cell, index));
                            break;
                            
                        case 12:
                            System.out.print("SELLING PRICE: ");
                            message += "SELLING PRICE: ";
                            try {
                                sellingPrice = BigDecimal.valueOf(getXLSXInt(cell, index));
                            } catch(NumberFormatException ex) {
                                System.out.println(ex.toString());
                                Logger.getLogger(AbsoluteIndustrialSolutions.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                            
                        case 13:
                            System.out.print("QUANTITY: ");
                            message += "QUANTITY: ";
                            String value = getXLSXString(cell, index);
                            try {
                                quantity = Integer.parseInt(value.substring(0, value.indexOf(" ")));
                                unit = value.substring(value.lastIndexOf(" ")+1);
                            }catch(StringIndexOutOfBoundsException ex) {
                                System.out.println(ex.toString());
                                Logger.getLogger(AbsoluteIndustrialSolutions.class.getName()).log(Level.SEVERE, null, ex);
                            } catch(NumberFormatException ex) {
                                System.out.println(ex.toString());
                                Logger.getLogger(AbsoluteIndustrialSolutions.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                            
                        case 14:
                            System.out.print("AGENT: ");
                            message += "AGENT: ";
                            agent = String.valueOf(getXLSXString(cell, index));
                            break;
                            
                    }
                    switch(cell.getCellType()) {
                        case XSSFCell.CELL_TYPE_STRING:
                            System.out.println(cell.getStringCellValue());
                            message += cell.getStringCellValue() + "\n";
                            break;

                        case XSSFCell.CELL_TYPE_NUMERIC:
                            if(index == 1 ) {
                                System.out.println(cell.getDateCellValue());
                                message += cell.getDateCellValue() + "\n";
                            }
                            else {
                                System.out.println(cell.getNumericCellValue());
                                message += cell.getNumericCellValue() + "\n";
                            }
                            break;

                        case XSSFCell.CELL_TYPE_BOOLEAN:
                            System.out.println(cell.getBooleanCellValue());
                            message += cell.getBooleanCellValue() + "\n";
                            break;
                    }
                    index++;
                }
                Transactions transaction = new Transactions();
                transaction.setReferenceNumber(reference);
                supplier = new Supplier(supplierName, contactPerson, contactDetails);
                product = new Product(name, category, description, brand, model, quantity, unit, product_date, factor, originalPrice, sellingPrice, agent);
                TransactionServices.saveTransaction(transaction, product, supplier);
//                Set<Supplier> suppliers = product.getSupplier();
//                suppliers.add(supplier);
//                product.setSupplier(suppliers);
//                ProductService.createProduct(product, supplier);
//                ProductService.createProduct(reference, name, category, description, brand, model, quantity, unit, product_date, factor, originalPrice, sellingPrice, agent, supplier);
                System.out.println("");
                message += "\n";
            }
            
        } catch(Exception e) {
            System.out.println(e.toString());
            message += e.toString() + "\n";
            Logger.getLogger(AbsoluteIndustrialSolutions.class.getName()).log(Level.SEVERE, null, e);
    }
            
    /*******************************READING AND SAVING DATA PURPOSE*******************************************/
            writer.write(message);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(AbsoluteIndustrialSolutions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
