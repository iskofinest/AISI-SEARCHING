/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Product;
import Entities.ProductTable;
import Entities.Supplier;
import org.hibernate.Transaction;

/**
 *
 * @author IPC
 */
public class SupplierService {
    
    
    public static String[][] getSupplierForProduct(Product product) {
        Object[] suppliersList = product.getSupplier().toArray();
        String[][] suppliers = new String[suppliersList.length][4];
        
        for(int i=0; i<suppliersList.length; i++) {
            Supplier supplier = (Supplier)suppliersList[i];
            suppliers[i][0] = supplier.getName();
            suppliers[i][1] = supplier.getContactPerson();
            suppliers[i][2] = supplier.getContactDetails();
            suppliers[i][3] = String.valueOf(supplier.getId());
        }
        return suppliers;
    }

    public static Supplier findSupplierByProductId(int supplierID) {
        Supplier supplier = new Supplier();
//        ProductTable.session = Utilities.HibernateUtil.getSessionFactory().openSession();
        supplier = (Supplier)ProductTable.session.get(Supplier.class, supplierID);
        return supplier;
    }
    
    public static boolean updateSupplier(Supplier supplier) {
        boolean saved = false;
        try{
//            session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = ProductTable.session.beginTransaction();
            ProductTable.session.update(supplier);
            tx.commit();
            saved = true;
        } catch(Exception ex) {
            saved = false;
            System.out.println(ex.toString());
        }
        return saved;
    }
    
}
