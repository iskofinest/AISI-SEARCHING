/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.ProductTable;
import Entities.User;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author IPC
 */
public class UserService {
    
    public static List getUserLogin(String username, String password) {
//        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = ProductTable.session.createCriteria(User.class);
        criteria.add(Restrictions.eq(User.USERNAME, username));
        criteria.add(Restrictions.eq(User.PASSWORD, password));
        List list = criteria.list();
//        session.close();
        return list;
    }
    public static List getUserLogin(String username, String password, String authority) {
//        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        System.out.println("USERNAME: " + username);
        System.out.println("PASSWORD: " + password);
        System.out.println("AUTHORITY: " + authority);
        Criteria criteria = ProductTable.session.createCriteria(User.class);
        criteria.add(Restrictions.eq(User.USERNAME, username));
        criteria.add(Restrictions.eq(User.PASSWORD, password));
        criteria.add(Restrictions.eq(User.AUTHORITY, authority));
        List list = criteria.list();
//        session.close();
        return list;
    }
    
    public static boolean createUser(String employee_id, String username, String password, String firstName, String middleName, String lastName, String authority, String email, String contact, String address) {
        try{
            User user = new User(employee_id, username, 
                    password, firstName, middleName, 
                    lastName, authority,
                email, contact, address);
//            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = ProductTable.session.beginTransaction();
            ProductTable.session.save(user);
            tx.commit();
//            session.close();
        } catch(Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, e.toString(), "ERROR OCCURED", 0);
            return false;
        }
        return true;
    }
    
    public static boolean updateUser(int id, String employee_id, String username, String password, String firstName, String middleName, String lastName, String authority, String email, String contact, String address) {
        try{
//            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Query query = ProductTable.session.createQuery("update User set "
                    +  " = :stockName" 
                    +
    				" where stockCode = :stockCode");
            
        } catch(Exception e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }
    
    public static boolean isUsernameExists(String username) {
        boolean exists = false;
        try {
            Criteria criteria = ProductTable.session.createCriteria(User.class);
            criteria.add(Restrictions.eq(User.USERNAME, username));
            List list = criteria.list();
            if(list.size()>0) {
                exists = true;
            } else {
                exists = false;
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "ISSUPPLIEREXISTS(): " + e.toString(), "ERROR OCCURRED", 0);
        }
        return exists;
    }
    
}
