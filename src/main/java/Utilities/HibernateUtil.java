/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Services.JSONService;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author IPC
 */
public class HibernateUtil {
 
    private static final SessionFactory sessionFactory;
    private static final String message = "Unable to connect into the database.";
    
    static {
        
        
        try {
            JSONObject jsonConfigFile = JSONService.getJSONFile();
            Properties properties = new Properties();
            properties.setProperty("hibernate.connection.url", String.valueOf(jsonConfigFile.get("hibernate.connection.url")));
            properties.setProperty("hibernate.connection.username", String.valueOf(jsonConfigFile.get("hibernate.connection.username")));
            properties.setProperty("hibernate.connection.password", String.valueOf(jsonConfigFile.get("hibernate.connection.password")));
            
            Configuration configuration = new Configuration().configure(); // configuration // settings // from // hibernate.cfg.xml
            configuration.setProperties(properties);
            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
            serviceRegistryBuilder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
//            javax.swing.JOptionPane.showMessageDialog(null, ex.toString(), "ERROR", 0);
            javax.swing.JOptionPane.showMessageDialog(null, message, "ERROR", 0);
            JSONService.setJSONFile();
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    
}
