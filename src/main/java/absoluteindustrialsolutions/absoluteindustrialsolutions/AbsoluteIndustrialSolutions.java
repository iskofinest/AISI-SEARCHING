/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absoluteindustrialsolutions.absoluteindustrialsolutions;

import Entities.Product;
import Entities.ProductTable;
import Entities.Transactions;
import Entities.User;
import Entities.Supplier;
import Forms.Login;
import Services.ProductService;
import Services.ReadDataService;
import Services.UserService;
import Services.TransactionServices;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author IPC
 */
public class AbsoluteIndustrialSolutions {
    static String message = "";
    
    public static void main(String[] args) {
        
//        try {
//            String fileName = "C:\\Users\\IPC\\Documents\\NetBeansProjects\\AISI-SEARCHING\\AISI QUOTATIONS_COMPILED.xlsx";
//            File file = null;
//            FileInputStream fileInputStream = null;
//            file = new File(fileName);
//            fileInputStream = new FileInputStream(file);
//            if(fileName.substring(fileName.lastIndexOf(".")+1).equals("xls")) {
//                
//                ReadDataService.readXLSData(fileInputStream);
//            } else {
//                ReadDataService.readXLSXData(fileInputStream);
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(AbsoluteIndustrialSolutions.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        ProductTable.session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Login login = new Login();
        login.setVisible(true);
        
    }
    
}

