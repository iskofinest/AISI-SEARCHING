/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absoluteindustrialsolutions.absoluteindustrialsolutions;

import Entities.Product;
import Entities.Supplier;
import Entities.Transactions;
import Forms.Login;
import Services.ProductService;
import Services.ReadDataService;
import Utilities.HibernateUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author IPC
 */
public class AbsoluteIndustrialSolutions {
    static String message = "";
    
    public static void main(String[] args) {
        
//        try {
//            String fileName = "C:\\Users\\AISI-IVY\\Downloads\\Developers Folder\\GitHub\\AISI QUOTATIONS_COMPILED.xlsx";
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
        
//        ProductTable.session = Utilities.HibernateUtil.getSessionFactory().openSession();
        
//        Product product = new Product("name", 
//            "description",
//            "brand",
//            "model",
//                1,
//                "pcs",
//                new Date(),
//                BigDecimal.valueOf(1000),
//                "PHP",
//                "agent",
//                "contactPerson"
//        );
//        Transactions transaction = new Transactions("sample");
//        Supplier supplier = new Supplier("name", "contact details");
//        ProductService.saveProduct(transaction, product, supplier);
//        SessionFactory session = HibernateUtil.getSessionFactory();
//        session.close();
        Login login = new Login();
        login.setVisible(true);
        
    }
    
}

