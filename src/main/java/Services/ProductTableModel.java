/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Product;
import Entities.Supplier;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author IPC
 */
public class ProductTableModel extends AbstractTableModel{

    private List<Product> productList;
    private String[] columns ;
    
    public ProductTableModel(List<Product> productList){
        super();
        this.productList = productList ;
        columns = new String[]{
            "REFERENCE",
            "NAME", 
            "CATEGORY", 
            "DESCRIPTION",
            "BRAND", 
            "MODEL", 
            "QUANTITY", 
            "UNIT", 
            "PRODUCT DATE", 
            "FACTOR", 
            "ORIGINAL PRICE", 
            "SELLING PRICE", 
            "AGENT", 
            "SUPPLIER NAME",
            "CONTACT PERSON",
            "CONTACT DETAILS"};
        
    }
    
    
    @Override
    public int getRowCount() {
        return productList.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = productList.get(rowIndex);
        Object object = null;
        switch(columnIndex) {
            case 0:
                object = product.getTransaction().getReferenceNumber();
                break;
                
            case 1:
                object = product.getName();
                break;
                
            case 2:
                object = product.getCategory();
                break;
                
            case 3:
                object = product.getDescription();
                break;
                
            case 4:
                object = product.getBrand();
                break;
                
            case 5:
                object = product.getModel();
                break;
                
            case 6:
                object = product.getModel();
                break;
                
            case 7:
                object = product.getQuantity();
                break;
                
            case 8:
                object = product.getUnit();
                break;
                
            case 9:
                object = product.getProduct_date();
                break;
                
            case 10:
                object = product.getFactor();
                break;
                
            case 11:
                object = product.getOriginalPrice();
                break;
                
            case 12:
                object = product.getSellingPrice();
                break;
                
            case 13:
                object = product.getAgent();
                break;
                
            case 14:
                if(product.getSupplier().size() > 0) {
                    object = ((Supplier)product.getSupplier().toArray()[0]).getName();
                } else object = "";
                
                break;
                
            case 15:
                if(product.getSupplier().size() > 0) {
                    object = ((Supplier)product.getSupplier().toArray()[0]).getContactPerson();
                } else object = "";
                break;
                
            case 16:
                if(product.getSupplier().size() > 0) {
                    object = ((Supplier)product.getSupplier().toArray()[0]).getContactDetails();
                } else object = "";
                break;
                
        }
        return object;
    }
    
    
}
