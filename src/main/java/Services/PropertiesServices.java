/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;
import org.hibernate.SessionFactory;

/**
 *
 * @author AISI
 */
public class PropertiesServices {
    private static SessionFactory sessionFactory = null;
    private static OutputStream outputStream = null;
    
    public static void setHibernatePropertiesFile(String url, String database, String username, String password) {
        try {
            Properties prop = new Properties();
            outputStream = new FileOutputStream("config.properties");
                   
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
    }
    
}
