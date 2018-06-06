/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absoluteindustrialsolutions.absoluteindustrialsolutions;

import Forms.Login;
import Services.ReadDataService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;


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
        Login login = new Login();
        login.setVisible(true);
        System.out.println("sl;dfkjalskdfj");
        
    }
    
}

