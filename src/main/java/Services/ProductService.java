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
import Entities.User;
import static Services.TransactionServices.isSupplierExist;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

/**
 *
 * @author IPC
 */
public class ProductService {
    
//    static Session session;
    
    public static String[][] getAllProducts() {
        String hql = "FROM Product";
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        List<Product> products = query.list();      // no ClassCastException here
        String[][] data = new String[products.size()][13];
        for(int i=0; i<products.size(); i++) {
            Product product = products.get(i);
            data[i][0] = product.getTransaction().getReferenceNumber();
            data[i][1] = product.getName();
            data[i][2] = product.getDescription();
            data[i][3] = product.getBrand();
            data[i][4] = product.getModel();
            data[i][5] = product.getQuantity() + " "+ product.getUnit();
            data[i][6] = product.getProduct_date().toString();
            data[i][7] = product.getOriginalPrice().toString();
            data[i][8] = product.getAgent();
            data[i][9] = ((Supplier)product.getSupplier().toArray()[0]).getName();
            data[i][10] = ((Supplier)product.getSupplier().toArray()[0]).getContactPerson();
            data[i][11] = ((Supplier)product.getSupplier().toArray()[0]).getContactDetails();
            data[i][12] = product.getId() + "";
        }
        return data;
    }
    
//    public static List getAllProducts() {
//        List list = null;
//        String hql = "FROM Product";
//        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
//        Query query = session.createQuery(hql);
//        List<Product> products = query.list();      // no ClassCastException here
//        return products;
//    }
    
    public static void createProduct(Product product, Supplier supplier) { 
        try {
//            Criteria cr = Utilities.HibernateUtil.getSessionFactory().openSession().createCriteria(Product.class)
//                .setProjection(Projections.projectionList()
//                .add(Projections.property("id"), "id")
//                .add(Projections.property("name"), "name"))
//                .setResultTransformer(Transformers.aliasToBean(Product.class));
//            List<Product> products = cr.list();
            System.out.println("************************************************************");
//            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
//            Criteria criteria = session.createCriteria(Product.class);
//            criteria.add(Restrictions.eq(Product.NAME, product.getName()));
//            List<Product> products = criteria.list();
//            products.forEach(e -> System.out.println(((Product)e).toString()));

//            session = Utilities.HibernateUtil.getSessionFactory().openSession();
            if(isProductExist(product)) {
                int quantity = product.getQuantity();
                Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
                Criteria criteria = session.createCriteria(Product.class)
                    .setProjection(Projections.projectionList()
                    .add(Projections.property(Product.NAME), product.getName()))
                    .setResultTransformer(Transformers.aliasToBean(Product.class));
                session.close();
            }
            if(isSupplierExist(supplier)) {
                System.out.println(supplier.getName() + " EXISTS");
                System.out.println(supplier.getName() + " EXISTS");
                System.out.println(supplier.getName() + " EXISTS");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "createProduct(): " + e.toString(), "ERROR OCCURED", 0);
        }
    }
    
    public static void createProduct(Product product) { 
        try {
            System.out.println(product.toString());
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
//            session.save(product.getSupplier());
            session.save(product);
            tx.commit();
            session.close();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    public static void createProduct(Supplier supplier) { 
        try {
            System.out.println(supplier.toString());
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
//            session.save(product.getSupplier());
            session.save(supplier);
            tx.commit();
            session.close();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
//    public static void createProduct(String reference, String name, String category, String description, String brand,
//            String model, int quantity, String unit, Date product_date, String factor, BigDecimal originalPrice, BigDecimal sellingPrice, String agent, Supplier supplier) {
//        try{
//            Product product = new Product(name, category, description, brand, model, quantity, unit, product_date,
//            factor, originalPrice, sellingPrice, agent);
//            product.addSupplier(supplier);
//            System.out.println(product.toString());
//            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
//            Transaction tx = session.beginTransaction();
//            session.save(product);
//            session.save(supplier);
//            tx.commit();
//            session.close();
//            product = new Product();
//            supplier = new Supplier();
//        } catch(Exception e) {
//            System.out.println(e.toString());
//            JOptionPane.showMessageDialog(null, e.toString(), "ERROR OCCURED", 0);
//        }
//    }
    
    public static String[][] getQueryList(String search) {
        List list = null;
        String hql = "FROM Product Where name LIKE '%" + search + "%'";
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        List<Product> products = query.list();      // no ClassCastException here
        session.close();
        String[][] data = new String[products.size()][13];
        for(int i=0; i<products.size(); i++) {
            Product product = products.get(i);
            data[i][0] = product.getTransaction().getReferenceNumber();
            data[i][1] = product.getName();
            data[i][2] = product.getDescription();
            data[i][3] = product.getBrand();
            data[i][4] = product.getModel();
            data[i][5] = product.getQuantity() + " "+ product.getUnit();
            data[i][6] = product.getProduct_date().toString();
            data[i][7] = product.getOriginalPrice().toString();
            data[i][8] = product.getAgent();
            data[i][9] = ((Supplier)product.getSupplier().toArray()[0]).getName();
            data[i][10] = ((Supplier)product.getSupplier().toArray()[0]).getContactPerson();
            data[i][11] = ((Supplier)product.getSupplier().toArray()[0]).getContactDetails();
            data[i][12] = product.getId() + "";
        }

        return data;
    }
    
    public static boolean isSupplierExist(Supplier supplier) {
        int rowNumber = 0;
        try {
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Supplier.class);
            criteria.add(Restrictions.eq(Supplier.NAME, supplier.getName()));
            criteria.setProjection(Projections.rowCount());
            rowNumber = Integer.parseInt(criteria.uniqueResult().toString());
            session.close();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "ISSUPPLIEREXISTS(): " + e.toString(), "ERROR OCCURRED", 0);
        }
        return rowNumber > 0;
    }
    
    public static boolean isProductExist(Product product) {
        int rowNumber = 0;
        try {
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Product.class);
            criteria.add(Restrictions.eq(Product.NAME, product.getName()));
            criteria.setProjection(Projections.rowCount());
            rowNumber = Integer.parseInt(criteria.uniqueResult().toString());
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "IPRODUCTREXISTS(): " + e.toString(), "ERROR OCCURRED", 0);
        }
        return rowNumber > 0;
    }
    
    public static Product getProduct(int id) {
        Product product = new Product();
//        ProductTable.session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        product = (Product) session.get(Product.class, id);
        session.close();
        return product;
    }
    
    public static boolean updateProduct(Product product) {
        boolean saved = false;
        try{
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.update(product);
            tx.commit();
            session.close();
            saved = true;
        } catch(Exception ex) {
            saved = false;
            System.out.println(ex.toString());
        }
        return saved;
    }
    
    public static boolean deleteProduct(Product product) {
        boolean deleted = false;
        try{
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            product.setSupplier(new HashSet<Supplier>());
            product.setTransaction(new Transactions());
            session.delete(product);
            tx.commit();
            session.close();
            deleted = true;
        } catch(Exception ex) {
            deleted = false;
            System.out.println(ex.toString());
        }
        return deleted;
    }
    
    public static boolean saveProduct(Transactions transactions, Product product, Supplier supplier) { 
        boolean processed = false;
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
            processed = false;
        }
        processed = true;
        return processed;
    }
    
    public static boolean isTransactionExist(Transactions transactions) {
        int rowNumber = 0;
        try {
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Transaction.class);
//            Criteria criteria = Utilities.HibernateUtil.getSessionFactory()
//                    .openSession().createCriteria(Transaction.class);
            criteria.add(Restrictions.eq(Transactions.REFERENCE_NUMBER, transactions.getReferenceNumber()));
            criteria.setProjection(Projections.rowCount());
            session.close();
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
    
    public static String[][] searchMultipleFields(String reference, String name, String brand, String unit, String supplier ) {
        String hql = "Select p from Product p join p.suppliers s join p.transaction t "
                + "where p.name LIKE '%" + name + "%' "
                + "and s.name LIKE '%" + supplier + "%' "
                + "and t.referenceNumber LIKE '%" + reference + "%' and p.brand LIKE '%" + brand + "%' "
                + "and p.unit LIKE '%" + unit + "%'";
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        List<Product> products = query.list();
        session.close();
        String[][] data = new String[products.size()][13];
        for(int i=0; i<products.size(); i++) {
            Product product = products.get(i);
            data[i][0] = product.getTransaction().getReferenceNumber();
            data[i][1] = product.getName();
            data[i][2] = product.getDescription();
            data[i][3] = product.getBrand();
            data[i][4] = product.getModel();
            data[i][5] = product.getQuantity() + " "+ product.getUnit();
            data[i][6] = product.getProduct_date().toString();
            data[i][7] = product.getOriginalPrice().toString();
            data[i][8] = product.getAgent();
            data[i][9] = ((Supplier)product.getSupplier().toArray()[0]).getName();
            data[i][10] = ((Supplier)product.getSupplier().toArray()[0]).getContactPerson();
            data[i][11] = ((Supplier)product.getSupplier().toArray()[0]).getContactDetails();
            data[i][12] = product.getId() + "";
        }
        return data;
    }
    
    public static String[][] findProductBySupplierID(int id) {
        String hql = "Select p from Product p join p.suppliers s "
                + "where s.id=" + id;
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        List<Product> products = query.list();
        String[][] data = new String[products.size()][5];
        for(int i=0; i<products.size(); i++) {
            Product product = products.get(i);
            data[i][0] = product.getName();
            data[i][1] = product.getBrand();
            data[i][2] = product.getOriginalPrice().toString();
            data[i][3] = product.getAgent();
            data[i][4] = product.getId() + "";
        }
        return data;
    }
    
}
