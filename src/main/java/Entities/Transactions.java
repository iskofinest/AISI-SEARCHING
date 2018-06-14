/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author IPC
 */
@Entity
//@Indexed
@Table(name="transaction")
public class Transactions implements Serializable{
    
    public static final String REFERENCE_NUMBER = "referenceNumber";
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;
    
    @Column(name="reference_number")
    private String referenceNumber;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="transaction")
    private Set<Product> products = new HashSet<>();

    public Transactions() {}

    
    
    public Transactions(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
    
    @Override
    public String toString() {
        String transactionString =  "Transactions{" + "id=" + id + ", referenceNumber=" + referenceNumber;
//        for(Product product: products) {
//            transactionString += "\n\t" + product.toString();
//        }
        transactionString += products.getClass().toString()+"\n}\n";
        return transactionString;
    }
    
    
}
