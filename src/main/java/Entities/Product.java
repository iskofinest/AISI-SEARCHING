/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author IPC
 */
@Entity
@Table(name = "product")
public class Product implements Serializable{
    
    
    public static final String NAME = "name";
    public static final String ID = "id";
    public static final String CATEGORY = "category";
    public static final String DESCRIPTION = "description";
    public static final String BRAND = "brand";
    public static final String MODEL = "model";
    public static final String QUANTITY = "quantity";
    public static final String UNIT = "unit";
    public static final String PRODUCT_DATE = "product_date";
    public static final String FACTOR = "factor";
    public static final String ORIGINAL_PRICE = "originalPrice";
    public static final String SELLING_PRICE = "sellingPrice";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", length=10, nullable=false)
    private int id;
    
    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="transaction_id")
    private Transactions transaction;
    
    @Column(name="name")
    private String name;
    
    @Column(name="category")
    private String category;
    
    @Column(name="description")
    private String description;
    
    @Column(name="brand")
    private String brand;
    
    @Column(name="model")
    private String model;
    
    @Column(name="quantity")
    private int quantity;
    
    @Column(name="unit")
    private String unit;
    
    @Column(name="product_date")
//    @Type(type="date")
    
    @Temporal(TemporalType.DATE)
    private Date product_date;
    
    @Column(name="factor")
    private String factor;
    
    @Column(name="original_price")
    private BigDecimal originalPrice;
    
    @Column(name="selling_price")
    private BigDecimal sellingPrice;
    
    @Column(name="currency")
    private String currency;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    @Column(name="agent")
    private String agent;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(
//        name = "product_supplier", 
//        joinColumns = { @JoinColumn(name = "product_id") }
//    )
    
    @JoinTable(
        name = "product_supplier", 
        joinColumns = { @JoinColumn(name = "product_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "supplier_id") }
    )
    @Column(name="supplier_id", length=50, nullable=false)
    private Set<Supplier> suppliers = new HashSet<Supplier>(0);

    public Set<Supplier> getSupplier() {
        return suppliers;
    }

    public void setSupplier(Set<Supplier> supplier) {
        this.suppliers = supplier;
    }
    
    public Product(){}

    public Product(String name, String category, String description, String brand, String model, int quantity, String unit, Date product_date, String factor, BigDecimal originalPrice, BigDecimal sellingPrice, String currency, String agent) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.brand = brand;
        this.model = model;
        this.quantity = quantity;
        this.unit = unit;
        this.product_date = product_date;
        this.factor = factor;
        this.originalPrice = originalPrice;
        this.sellingPrice = sellingPrice;
        this.currency = currency;
        this.agent = agent;
    }    
    public Product(String name, String description, String brand, String model, int quantity, String unit, Date product_date, BigDecimal originalPrice, String currency, String agent) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.model = model;
        this.quantity = quantity;
        this.unit = unit;
        this.product_date = product_date;
        this.originalPrice = originalPrice;
        this.currency = currency;
        this.agent = agent;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Transactions getTransaction() {
        return transaction;
    }

    public void setTransaction(Transactions transaction) {
        this.transaction = transaction;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    
    
    @Override
    public String toString() {
        String product = "";
        try{
            product = "Product{" + "id=" + id + ", reference=" + transaction.toString() + ", name=" + name + ", category=" + category + ", description=" + description + ", brand=" + brand + ", model=" + model + ", quantity=" + quantity + ", unit=" + unit + ", product_date=" + product_date + ", factor=" + factor + ", originalPrice=" + originalPrice + ", sellingPrice=" + sellingPrice + ", agent=" + agent + ", supplier=" + suppliers.getClass().toString() + '}';
        }catch(StackOverflowError error) {
            System.out.println(error.toString());
        }
        return product;
    }

    
    
    
}
