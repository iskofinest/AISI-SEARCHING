/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Product;
import Entities.Supplier;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

/**
 *
 * @author IPC
 */
public class SupplierService {
    
    
    private final static Logger logger = Logger.getLogger(SupplierService.class.getName());
    
    public static String[][] getSupplierForProduct(Product product) {
        Object[] suppliersList = product.getSupplier().toArray();
        String[][] suppliers = new String[suppliersList.length][3];
        
        for(int i=0; i<suppliersList.length; i++) {
            Supplier supplier = (Supplier)suppliersList[i];
            suppliers[i][0] = supplier.getName();
            suppliers[i][1] = supplier.getContactDetails();
            suppliers[i][2] = String.valueOf(supplier.getId());
        }
        return suppliers;
    }

    public static Supplier findSupplierById(int supplierID) {
        Supplier supplier = new Supplier();
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        supplier = (Supplier) session.get(Supplier.class, supplierID);
        session.close();
        return supplier;
    }
    
    public static boolean updateSupplier(Supplier supplier) {
        boolean saved = false;
        logger.log(Logger.Level.FATAL,saved);
        try{
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.update(supplier);
            tx.commit();
            session.close();
            saved = true;
        } catch(Exception ex) {
            saved = false;
            System.out.println(ex.toString());
        }
        return saved;
    }

    public static List<Supplier> findAll() {
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        List list = session.createQuery("from Supplier order by name").list();
        session.close();
        return list; 
    }
    
    public static List<Supplier> selectNames() {
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        List list = session.createQuery("select distinct name from Supplier where name not like '%%' or name not like '%-%' order by name").list();
        session.close();
        return list; 
    }
    
      public static List<Supplier> searchSupplierNames(){  
//            String hql = "select name from supplier";
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            return session.createQuery("select name from Supplier order by name").list();
    }
    
    
    
}
