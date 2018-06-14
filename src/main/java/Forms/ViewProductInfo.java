/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Entities.Product;
import Entities.ProductTable;
import Entities.Supplier;
import Entities.Transactions;
//import Network.NetworkHandlerService;
import Services.ExcelReportService;
import Services.ProductService;
import Services.SupplierService;
import java.awt.Color;
import java.io.File;
import java.math.BigDecimal;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * 05-19-2018
 */
public class ViewProductInfo extends javax.swing.JFrame {

    
    boolean isAdmin = false;
    Product product;
    JComponent components[];
    private JFrame previousForm = null;
    
    /**
     * Creates new form ViewProduct
     */
    public ViewProductInfo() {
        initComponents();
    }

    ViewProductInfo(int productID, JFrame previousForm) {
        initComponents();
        this.previousForm = previousForm;
        components = new JComponent[]{txtReference, txtItem, txtBrand, txtModel, txtQuantity, txtProductDate, 
            txtOrigPrice, txtAgent, txtSupplier, txtDescription};
        if(ProductTable.currentUser.getAuthority().equals("ADMIN")) {
            isAdmin = true;
        }
        txtSupplier.setEditable(false);
        enableFields(false);    // disable all fields by default
        product = ProductService.getProduct(productID);
        btnDelete.setEnabled(isAdmin);
        btnEdit.setEnabled(isAdmin);
        initializeData();
    }
    
    /*****************************************CUSTOME METHODS*****************************************/
    
    // sets enability of fields
    private void enableFields(boolean enability){
        txtReference.setEditable(enability);
        txtItem.setEditable(enability);
        txtDescription.setEditable(enability);
        txtBrand.setEditable(enability);
        txtModel.setEditable(enability);
        txtQuantity.setEditable(enability);
        txtUnit.setEditable(enability);
        txtProductDate.setEnabled(enability);
        txtOrigPrice.setEditable(enability);
        txtAgent.setEditable(enability);
    }
    
    // initialize fields with product passed
    private void initializeData() {
        lblItem.setText(product.getName());
        txtReference.setText(product.getTransaction().getReferenceNumber());
        txtItem.setText(product.getName());
        txtDescription.setText(product.getDescription());
        txtBrand.setText(product.getBrand());
        txtModel.setText(product.getModel());
        txtQuantity.setText(String.valueOf(product.getQuantity()));
        txtUnit.setText(product.getUnit());
        txtProductDate.setDate(product.getProduct_date());
        txtOrigPrice.setText(String.valueOf(product.getOriginalPrice()));
        txtAgent.setText(product.getAgent());
        try { 
            txtSupplier.setText(((Supplier)product.getSuppliers().toArray()[0]).getName());
        } catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex.toString());
        }
    }
    
    
    
    /*****************************************CUSTOME METHODS*****************************************/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bg_Panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtModel = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtOrigPrice = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtAgent = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtSupplier = new javax.swing.JTextField();
        btnMoreSupplier = new javax.swing.JButton();
        lblItem = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtReference = new javax.swing.JTextField();
        txtItem = new javax.swing.JTextField();
        btnPrint = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtUnit = new javax.swing.JTextField();
        txtBrand = new javax.swing.JTextField();
        txtProductDate = new com.toedter.calendar.JDateChooser();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        bg_Panel.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("MODEL:  ");

        txtModel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtModel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtModel.setToolTipText("");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("QUANTITY:  ");

        txtQuantity.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtQuantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQuantity.setToolTipText("");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("PRODUCT DATE:  ");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("ORIG PRICE:  ");

        txtOrigPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtOrigPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtOrigPrice.setToolTipText("");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("AGENT:  ");

        txtAgent.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtAgent.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAgent.setToolTipText("");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("SUPPLIER:  ");

        txtSupplier.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSupplier.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSupplier.setToolTipText("");

        btnMoreSupplier.setBackground(new java.awt.Color(0, 0, 0));
        btnMoreSupplier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMoreSupplier.setForeground(new java.awt.Color(0, 204, 0));
        btnMoreSupplier.setText("View More Supplier");
        btnMoreSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoreSupplierActionPerformed(evt);
            }
        });

        lblItem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("REFERENCE:  ");

        txtReference.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtReference.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtReference.setToolTipText("");
        txtReference.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtItem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtItem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtItem.setToolTipText("");

        btnPrint.setBackground(new java.awt.Color(0, 0, 0));
        btnPrint.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(0, 204, 0));
        btnPrint.setText("Print");
        btnPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrintMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPrintMouseExited(evt);
            }
        });
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(0, 0, 0));
        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(51, 255, 0));
        btnEdit.setText("Edit");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditMouseExited(evt);
            }
        });
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("ITEM:  ");

        btnDelete.setBackground(new java.awt.Color(0, 0, 0));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(51, 204, 0));
        btnDelete.setText("Delete");
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteMouseExited(evt);
            }
        });
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("DESCRIPTION:  ");

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("BRAND:  ");

        txtUnit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUnit.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUnit.setToolTipText("");

        txtBrand.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtBrand.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBrand.setToolTipText("");

        txtProductDate.setDateFormatString("MMMM-dd-yyyy");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtReference, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(158, 158, 158)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtOrigPrice, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtAgent, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtSupplier, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnMoreSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                    .addComponent(txtProductDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblItem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtReference, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtProductDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOrigPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMoreSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete)))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout bg_PanelLayout = new javax.swing.GroupLayout(bg_Panel);
        bg_Panel.setLayout(bg_PanelLayout);
        bg_PanelLayout.setHorizontalGroup(
            bg_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        bg_PanelLayout.setVerticalGroup(
            bg_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMoreSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoreSupplierActionPerformed
        // TODO add your handling code here:
        setEnabled(false);
        new Suppliers(this, "SUPPLIERS FOR " + product.getName(), 
                SupplierService.getSupplierForProduct(product)).setVisible(true);
    }//GEN-LAST:event_btnMoreSupplierActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        String filePath = "";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            filePath = selectedFile.getAbsolutePath();
            ExcelReportService.printSingleProduct(filePath, product);
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if(btnEdit.getText().equals("Edit")) {
            btnBack.setText("Cancel");
            btnEdit.setText("Done!");
            btnPrint.setEnabled(false);
            btnDelete.setEnabled(false);
            enableFields(true);
            
        } else {
            btnEdit.setText("Edit");
            btnBack.setText("Back");
            if(JOptionPane.showConfirmDialog(null, "Are you sure you want to update product?", "CONFIRM ADD", JOptionPane.OK_CANCEL_OPTION, 3) == 0) {
                Transactions transaction = product.getTransaction();
                transaction = product.getTransaction();
                transaction.setReferenceNumber(txtReference.getText());
                product.setTransaction(transaction);
                product.setName(txtItem.getText());
                product.setBrand(txtBrand.getText());
                product.setModel(txtModel.getText());
                product.setQuantity(Integer.parseInt(txtQuantity.getText()));
                product.setUnit(txtUnit.getText());
                product.setDescription(txtDescription.getText());
                product.setProduct_date(txtProductDate.getDate());
                product.setOriginalPrice(BigDecimal.valueOf(Double.parseDouble(txtOrigPrice.getText())));
                product.setAgent(txtAgent.getText());
                if(ProductService.updateProduct(product)) {
//                    if(ProductTable.currentUser.getAuthority().equals("ADMIN")) {
//                        NetworkHandlerService.serverSendMessage("reload");
//                    } else {
//                        NetworkHandlerService.clientSendMessage("reload");
//                    }
                    JOptionPane.showMessageDialog(null, "Item successfully updated!", "UPDATE SUCCESS", 1);
                    ProductTable.productsTableForm.reloadTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Item failed to update!", "UPDATE FAILED", 1);
                }
            } else initializeData();
            btnPrint.setEnabled(true);
            btnDelete.setEnabled(true);
            enableFields(false);
            btnBack.setText("Back");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete"+" "+"'"+lblItem.getText()+"'"+" "+"product?", "CONFIRM DELETE", JOptionPane.OK_CANCEL_OPTION, 3) == 0) {
            if(ProductService.deleteProduct(product)) {
//            if(ProductTable.currentUser.getAuthority().equals("ADMIN")) {
//                NetworkHandlerService.serverSendMessage("reload");
//            } else {
//                NetworkHandlerService.clientSendMessage("reload");
//            }
            JOptionPane.showMessageDialog(null, lblItem.getText()+" "+ "Product Successfully Deleted!!", "DELETE SUCCESSFUL", 1);
            ProductTable.productsTableForm.reloadTable();
            ProductTable.productsTableForm.setEnabled(true);
            ProductTable.productsTableForm.setVisible(true);
            ProductTable.productsTableForm.requestFocus();
            dispose();
            } else {
                JOptionPane.showMessageDialog(null, lblItem.getText() + " Unable to Delete!!", "DELETE FAILED", 0);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        if(btnBack.getText().equals("Back")) {
            dispose();
            if(previousForm != null) {
                previousForm.setEnabled(true);
                previousForm.setVisible(true);
                previousForm.requestFocus();
            }else {
                ProductTable.productsTableForm.setEnabled(true);
            }
        } else {
            btnBack.setText("Back");
            btnEdit.setText("Edit");
            btnPrint.setEnabled(true);
            btnDelete.setEnabled(true);
            initializeData();
            enableFields(false);   
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int confirmation = JOptionPane.showConfirmDialog(null,"Do you want to exit.","WARNING",JOptionPane.YES_OPTION,JOptionPane.ERROR_MESSAGE);
        if(confirmation == JOptionPane.YES_OPTION){ 
            this.dispose();
            previousForm.setEnabled(true);
            previousForm.setVisible(true);
            previousForm.requestFocus();
        }else{
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnPrintMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseEntered
        // TODO add your handling code here:
        btnPrint.setBackground(Color.WHITE);
        btnPrint.setForeground(Color.BLACK);
        
    }//GEN-LAST:event_btnPrintMouseEntered

    private void btnPrintMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseExited
        // TODO add your handling code here:
        btnPrint.setBackground(Color.BLACK);
        btnPrint.setForeground(Color.GREEN);
    }//GEN-LAST:event_btnPrintMouseExited

    private void btnEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseEntered
        // TODO add your handling code here:
        btnEdit.setBackground(Color.WHITE);
        btnEdit.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnEditMouseEntered

    private void btnEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseExited
        // TODO add your handling code here:
        btnEdit.setBackground(Color.BLACK);
        btnEdit.setForeground(Color.GREEN);
    }//GEN-LAST:event_btnEditMouseExited

    private void btnDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseEntered
        // TODO add your handling code here:
        btnDelete.setBackground(Color.WHITE);
        btnDelete.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnDeleteMouseEntered

    private void btnDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseExited
        // TODO add your handling code here:
        btnDelete.setBackground(Color.BLACK);
        btnDelete.setForeground(Color.GREEN);
        
    }//GEN-LAST:event_btnDeleteMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewProductInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewProductInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewProductInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewProductInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewProductInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg_Panel;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnMoreSupplier;
    private javax.swing.JButton btnPrint;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblItem;
    private javax.swing.JTextField txtAgent;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtItem;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtOrigPrice;
    private com.toedter.calendar.JDateChooser txtProductDate;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtReference;
    private javax.swing.JTextField txtSupplier;
    private javax.swing.JTextField txtUnit;
    // End of variables declaration//GEN-END:variables
}
