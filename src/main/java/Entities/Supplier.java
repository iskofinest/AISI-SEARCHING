/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author IPC
 */

@Entity
@Table(name="supplier")
public class Supplier implements Serializable{

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String CONTACT_PERSON = "ContactPerson";
    public static final String CONTACT_DETAILS = "ContactDetails";
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="contact_person")
    private String contactPerson;
    
    @Column(name="contact_details")
    private String contactDetails;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Product> products = new HashSet<Product>(0);

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
    
    public Supplier(){}
    
    public Supplier(String name, String contactPerson, String contactDetails) {
        this.name = name;
        this.contactPerson = contactPerson;
        this.contactDetails = contactDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        String oldContactPerson = this.contactPerson;
        this.contactPerson = contactPerson;
        changeSupport.firePropertyChange("contactPerson", oldContactPerson, contactPerson);
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        String oldContactDetails = this.contactDetails;
        this.contactDetails = contactDetails;
        changeSupport.firePropertyChange("contactDetails", oldContactDetails, contactDetails);
    }

//    @Override
//    public String toString() {
//        return "Supplier{" + "id=" + id + ", name=" + name + ", contactPerson=" + contactPerson + ", contactDetails=" + contactDetails + ", products=" + products + '}';
//    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
    
    
}
