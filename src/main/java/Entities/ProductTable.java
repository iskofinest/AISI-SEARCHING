/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Forms.ProductsTable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author IPC
 */
public class ProductTable {
    
    public static Users currentUser = new Users();
//    public static Session session;
    public static ProductsTable productsTableForm;
    public static Thread networkThread;
    String reference;
    String name;
    String category = "";
    String description = "";
    String brand = "";
    String model = "";
    String quantity = "";
    Date product_date = new Date();
    String factor = "";
    BigDecimal originalPrice;
    BigDecimal sellingPrice;
    String agent = "";
    String supplierName = "";
    String contactPerson = "";
    String contactDetails = "";

    public ProductTable(Product product) {
        this.reference = product.getTransaction().getReferenceNumber();
        this.name = product.getName();
        this.category = product.getCategory();
        this.description = product.getDescription();
        this.brand = product.getBrand();
        this.model = product.getModel();
        this.quantity = product.getQuantity() + " " + product.getUnit();
        this.product_date = product.getProduct_date();
        this.factor = product.getFactor();
        this.originalPrice = product.getOriginalPrice();
        this.sellingPrice = product.getSellingPrice();
        this.agent = product.getAgent();
        this.supplierName = ((Supplier)product.getSupplier().toArray()[0]).getName();
        this.contactPerson = ((Supplier)product.getSupplier().toArray()[0]).getContactPerson();
        this.contactDetails = ((Supplier)product.getSupplier().toArray()[0]).getContactDetails();
    }

    public ProductTable() {    }

    
    
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Date getProduct_date() {
        return product_date;
    }

    public void setProduct_date(Date product_date) {
        this.product_date = product_date;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
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

    
    
}
