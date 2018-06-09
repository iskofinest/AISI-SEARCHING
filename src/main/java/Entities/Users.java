/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Email;


/**
 *
 * @author IPC
 */

@Entity
@Table(name = "users")
public class Users {
    
    public static final String EMPLOYEE_ID = "employee_id";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String FIRST_NAME = "firstName";
    public static final String MIDDLE_NAME = "middleName";
    public static final String LAST_NAME = "lastName";
    public static final String AUTHORITY = "authority";
    public static final String E_MAIL = "email";
    public static final String CONTACT = "contact";
    public static final String ADDRESS = "address";
    
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", length=10, nullable=false)
    private int id;
    
    @Column(name="employee_ID", length=20, nullable=false)
    private String employee_id;
    
    @Column(name="username", length=20, nullable=false)
    private String username;
    
    @Column(name="password", length=20, nullable=false)
    private String password;
    
    @Column(name="firstName", length=50, nullable=false)
    private String firstName;
    
    @Column(name="middleName", length=20, nullable=false)
    private String middleName;
    
    @Column(name="lastname", length=20, nullable=false)
    private String lastName;
    
    @Column(name="authority", length=20, nullable=false)
    private String authority;
    
    @Email(message="Please provide a valid email address")
    @Column(name="email", length=50, nullable=false)
    private String email;
    
    @Column(name="contact", length=20, nullable=false)
    private String contact;
    
    @Column(name="address", length=150, nullable=false)
    private String address;
    
    public Users(){}
    
    
    public Users(String employee_id, String username, String password, String firstName, String middleName, String lastName, String authority, String email, String contact, String address) {
        this.employee_id = employee_id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.authority = authority;
        this.email = email;
        this.contact = contact;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", employee_id=" + employee_id + ", username=" + username + ", password=" + password + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", authority=" + authority + ", email=" + email + ", contact=" + contact + ", address=" + address + '}';
    }
    
    
    
}
