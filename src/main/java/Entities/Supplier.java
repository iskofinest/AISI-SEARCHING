/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author IPC
 */

@Entity
@Table(name="Supplier")
public class Supplier {
    
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
    
//    @Column(name="products", length=50, nullable=true)
//    @ManyToMany(cascade = CascadeType.ALL, mappedBy="suppliers")
    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "product_supplier",
//            joinColumns = @JoinColumn (name = "product_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn (name = "supplier_id", referencedColumnName = "id"))
//    @ManyToMany(cascade = { CascadeType.ALL })
//    @JoinTable(
//        name = "Product_Supplier", 
//        joinColumns = { @JoinColumn(name = "product_id") }, 
//        inverseJoinColumns = { @JoinColumn(name = "supplier_id") }
//    )
//    @ManyToMany( fetch = FetchType.LAZY, mappedBy = "suppliers", cascade = CascadeType.ALL)
//    @Column(name="products")
    
//    @ManyToMany(mappedBy = "suppliers")
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
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

//    @Override
//    public String toString() {
//        return "Supplier{" + "id=" + id + ", name=" + name + ", contactPerson=" + contactPerson + ", contactDetails=" + contactDetails + ", products=" + products + '}';
//    }
    
    
    
}
