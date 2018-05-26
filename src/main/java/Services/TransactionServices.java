/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Product;
import Entities.ProductTable;
import Entities.Supplier;
import Entities.Transactions;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author IPC
 */
public class TransactionServices {
    
    
    public static void saveTransaction(Transactions transactions, Product product, Supplier supplier) { 
        try {
            System.out.println(transactions.toString());
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Transactions.class)
                    .add(Restrictions.eq(Transactions.REFERENCE_NUMBER, transactions.getReferenceNumber()));
            List<Transactions> list = criteria.list();
            if(list.size()>0) {
                transactions = (Transactions) list.get(0);
            }
            
            Set<Product> products = transactions.getProducts();
            Set<Supplier> suppliers = product.getSupplier();
            supplier = isSupplierExist(supplier, session);
            suppliers.add(supplier);
            System.out.println(transactions.toString());
            products.forEach(e-> System.out.println("TransactionServices: " + e.toString()));
            suppliers.forEach(e-> System.out.println("TransactionServices: " + e.toString()));
            product.setSupplier(suppliers);
            products.add(product);
            if(!transactions.getReferenceNumber().equals("")) transactions.setProducts(products);
//            session.save(transactions);
            product.setTransaction(transactions);
            product.setSupplier(suppliers);
            session.save(product);
            
//            session.save(product.getSupplier());
//            if(isTransactionExist(transactions)) {
//                
//            }
//            session.save(transactions);
            tx.commit();
            session.close();
            System.out.println("TRANSACTION SAVED!!!");
        } catch(Exception e) {
//            JOptionPane.showMessageDialog(null, e.toString());
            Logger.getLogger(TransactionServices.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public static boolean isTransactionExist(Transactions transactions) {
        int rowNumber = 0;
        try {
            Criteria criteria = ProductTable.session.createCriteria(Transaction.class);
//            Criteria criteria = Utilities.HibernateUtil.getSessionFactory()
//                    .openSession().createCriteria(Transaction.class);
            criteria.add(Restrictions.eq(Transactions.REFERENCE_NUMBER, transactions.getReferenceNumber()));
            criteria.setProjection(Projections.rowCount());
            rowNumber = Integer.parseInt(criteria.uniqueResult().toString());
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "isTransactionExist(): " + e.toString(), "ERROR OCCURRED", 0);
        }
        return rowNumber > 0;
    }

    public static Supplier isSupplierExist(Supplier supplier, Session session) {
        try {
            Criteria criteria = session.createCriteria(Supplier.class);
            criteria.add(Restrictions.eq(Supplier.NAME, supplier.getName()));
            List list = criteria.list();
            if(list.size()>0) {
                supplier = (Supplier) list.get(0);
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "ISSUPPLIEREXISTS(): " + e.toString(), "ERROR OCCURRED", 0);
        }
        return supplier;
    }
    
}
