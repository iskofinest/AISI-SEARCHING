/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Users;
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
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Users.class);
        criteria.add(Restrictions.eq(Users.USERNAME, username));
        criteria.add(Restrictions.eq(Users.PASSWORD, password));
        List list = criteria.list();
//        session.close();
        return list;
    }
    public static List getUserLogin(String username, String password, String authority) {
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        System.out.println("USERNAME: " + username);
        System.out.println("PASSWORD: " + password);
        System.out.println("AUTHORITY: " + authority);
        Criteria criteria = session.createCriteria(Users.class);
        criteria.add(Restrictions.eq(Users.USERNAME, username));
        criteria.add(Restrictions.eq(Users.PASSWORD, password));
        criteria.add(Restrictions.eq(Users.AUTHORITY, authority));
        List list = criteria.list();
        session.close();
        return list;
    }
    
    public static boolean createUser(String employee_id, String username, String password, String firstName, String middleName, String lastName, String authority, String email, String contact, String address) {
        try{
            Users user = new Users(employee_id, username, 
                    password, firstName, middleName, 
                    lastName, authority,
                email, contact, address);
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(user);
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
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("update User set "
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
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Users.class);
            criteria.add(Restrictions.eq(Users.USERNAME, username));
            List list = criteria.list();
            session.close();
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
    
    public static String[][] getAllUsers() {
        String hql = "FROM Users";
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        List<Users> users = query.list();      // no ClassCastException here
        String[][] data = new String[users.size()][11];
        for(int i=0; i<users.size(); i++) {
            Users user = users.get(i);
            data[i][0] = user.getEmployee_id();
            data[i][1] = user.getUsername();
            data[i][2] = user.getAuthority();
            data[i][3] = user.getLastName();
            data[i][4] = user.getFirstName();
            data[i][5] = user.getMiddleName();
            data[i][6] = user.getContact();
            data[i][7] = user.getEmail();
            data[i][8] = user.getAddress();
            data[i][9] = user.getPassword();
            data[i][10] = user.getId() + "";
        }
        return data;
    }

    public static Users getUserBy(int userId) {
        Users user = new Users();
        Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
        user = (Users) session.get(Users.class, userId);
        session.close();
        return user;
    }

    public static boolean updateUser(Users user) {
        boolean updated = false;
        try{
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.update(user);
            tx.commit();
            session.close();
            updated = true;
        } catch(Exception ex) {
            updated = false;
            System.out.println(ex.toString());
        }
        return updated;
    }

    public static boolean deleteUser(Users user) {
        boolean deleted = false;
        try{
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.delete(user);
            tx.commit();
            session.close();
            deleted = true;
        } catch(Exception ex) {
            deleted = false;
            System.out.println(ex.toString());
        }
        return deleted;
    }

    public static boolean updateUserPassword(int id, String newPassword) {
        boolean passwordChanged = false;
        Users user = getUserBy(id);
        try{
            Session session = Utilities.HibernateUtil.getSessionFactory().openSession();
            user.setPassword(newPassword);
            Transaction tx = session.beginTransaction();
            session.update(user);
            tx.commit();
            session.close();
            passwordChanged = true;
        } catch(Exception ex) {
            passwordChanged = false;
            System.out.println(ex.toString());
        }
        return passwordChanged;
    }
    
}
