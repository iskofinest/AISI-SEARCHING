/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

//<editor-fold desc="IMPORTS" defaultstate="collapsed">
import Entities.ProductTable;
import Network.NetworkHandlerService;
import Services.ExcelReportService;
import Services.ProductService;
import Services.UserService;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
//</editor-fold>

/**
 *
 * @author Jovanie
 */
public class ProductsTable extends javax.swing.JFrame {

    //<editor-fold desc="VARIABLE DECLARATIONS" defaultstate="collapsed">
    JTextField searchFields[];
    String month[] = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
    String day[] = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
    String[] columns = new String[]{"REFERENCE", "ITEM", "DESCRIPTION", "BRAND", "MODEL", 
                "QTY / Unit" , "QUOTATION DATE", "ORIGINAL PRICE", "AGENT", "SUPPLIER NAME",
            "CONTACT PERSON","CONTACT DETAILS"};
    String[][] productList;
    String[][] userList;
    boolean isAdmin = false;
    boolean productsTableMode = true;
    boolean searching = false;
    int start = 0;
    int max = 28;
    int listCount = 0;
    //</editor-fold>
    
    /**
     * Creates new form Products
     */
    //<editor-fold desc="REAL TIME CONSTRUCTOR" defaultstate="collapsed">

    public ProductsTable() {
        initComponents();
        initializeData();
        isAdmin = ProductTable.currentUser.getAuthority().equals("ADMIN");
        System.out.println(ProductTable.currentUser.getAuthority());
        if(!isAdmin) {
            jMenu1.remove(btnAddProduct);
            jMenuBar1.remove(btnView);
        }
    }

    
    //</editor-fold>
    
    //<editor-fold desc="CUSTOM METHODS" defaultstate="collapsed">
    
    // initialize custom changes
    private void initializeData() {
        setTime().start();  // FOR DATE AND TIME DISPLAY
        lblCurrentUser.setText("LOGGED IN AS: " +   // FOR CURRENT USER DISPLAY 
                ProductTable.currentUser.getFirstName() + " " + ProductTable.currentUser.getLastName());
        reloadTable();  // FOR UPDATING THE TABLE
        ProductTable.productsTableForm = this;   // SAVING THIS FORM TO THE CONSTANT HANDLER
        dataTable.setDefaultEditor(Object.class, null); // DISABLING THE JTABLE EDIT
        searchFields = new JTextField[]{txtSearchReference, txtSearchItemName, txtSearchBrand, txtSearchUnit, txtSearchSupplierName};
        btnPrevious.setEnabled(false);
        listCount = ProductService.countAllProduct();
        for(JTextField searchField : searchFields) {
            searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
                            if( txtSearchBrand.getText().trim().equals("") && txtSearchItemName.getText().trim().equals("") &&
                                    txtSearchReference.getText().trim().equals("") && txtSearchUnit.getText().trim().equals("") &&
                                    txtSearchSupplierName.getText().trim().equals("")) {
                                listCount = ProductService.countAllProduct();
                                reloadTable();
                                searching = false;
                            } else {
                                String reference = txtSearchReference.getText().trim();
                                String name = txtSearchItemName.getText().trim();
                                String brand = txtSearchBrand.getText().trim();
                                String unit = txtSearchUnit.getText().trim();
                                String supplier = txtSearchSupplierName.getText().trim();
                                start = 0;
                                listCount = ProductService.countMultipleFields(reference, name, brand, unit, supplier);
                                if(listCount < 28) {
                                    btnPrevious.setEnabled(false);
                                    btnNext.setEnabled(false);
                                }
                                searching = true;
                                searchProducts();
                            }
                        }
                    }
                });
            }
        });
        }
        
    }
    
    // thread for updating time
    private Thread setTime() { 
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    Calendar calendar = new GregorianCalendar();
                    String time = month[calendar.get(Calendar.MONTH)] + " " +
                            calendar.get(Calendar.DAY_OF_MONTH) + ", " +
                            calendar.get(Calendar.YEAR) + " " +
                            day[calendar.get(Calendar.DAY_OF_WEEK)-1] + " " +
                            ((calendar.get(Calendar.HOUR)==0)?12:calendar.get(Calendar.HOUR)) + ":" +
                            ((calendar.get(Calendar.MINUTE)<10) ? "0" +calendar.get(Calendar.MINUTE) : calendar.get(Calendar.MINUTE)) + ":" +
                            ((calendar.get(Calendar.SECOND)<10)? "0"+ calendar.get(Calendar.SECOND):calendar.get(Calendar.SECOND)) + " " +
                            ((calendar.get(Calendar.AM_PM) == 1)?"PM":"AM");
                    lblTime.setText(time);
                }
            }
        });
        return thread;
    }
    
    // reload product data table for update
    public void reloadTable() {
        productList = ProductService.getAllProducts(start, max);
        DefaultTableModel model = new DefaultTableModel(productList, columns);
        dataTable.setModel(model);
    }
    
    
    
    private void searchProducts() {
        String reference = txtSearchReference.getText().trim();
        String name = txtSearchItemName.getText().trim();
        String brand = txtSearchBrand.getText().trim();
        String unit = txtSearchUnit.getText().trim();
        String supplier = txtSearchSupplierName.getText().trim();
        productList = ProductService.searchMultipleFields(reference, name, brand, unit, supplier, start);
//        TableModel model = new ProductTableModel(productList);
//        dataTable.setModel(model);
        
//        productList = ProductService.getQueryList(searchtxt);
        DefaultTableModel model = new DefaultTableModel(productList, columns);
        dataTable.setModel(model);
    }
    
    private void enableSearchFields(boolean enability) {
        txtSearchReference.setEditable(enability);
        txtSearchItemName.setEditable(enability);
        txtSearchBrand.setEditable(enability);
        txtSearchUnit.setEditable(enability);
        txtSearchSupplierName.setEditable(enability);
    }
    
    public void updateUserTable() {
        userList = UserService.getAllUsers();
    }
    
    //</editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtSearchBrand = new javax.swing.JTextField();
        txtSearchItemName = new javax.swing.JTextField();
        txtSearchReference = new javax.swing.JTextField();
        txtSearchSupplierName = new javax.swing.JTextField();
        txtSearchUnit = new javax.swing.JTextField();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblCurrentUser = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnAddProduct = new javax.swing.JMenuItem();
        printMenu = new javax.swing.JMenuItem();
        btnLogout = new javax.swing.JCheckBoxMenuItem();
        btnView = new javax.swing.JMenu();
        btnProductView = new javax.swing.JMenuItem();
        btnUserView = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PRODUCTS TABLE");
        setExtendedState(6);
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        bgPanel.setBackground(new java.awt.Color(0, 102, 0));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("A   B   S   O   L   U   T   E");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Industiral  Solutions Inc");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Absolute Solution for your Bussiness needs");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel4.setBackground(new java.awt.Color(0, 51, 51));

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtSearchBrand.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSearchBrand.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtSearchItemName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSearchItemName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtSearchReference.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSearchReference.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtSearchSupplierName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSearchSupplierName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtSearchUnit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSearchUnit.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnNext.setText("NEXT");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setText("PREVIOUS");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(txtSearchReference, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnPrevious)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtSearchItemName)
                .addComponent(txtSearchReference)
                .addComponent(txtSearchBrand)
                .addComponent(txtSearchSupplierName)
                .addComponent(txtSearchUnit)
                .addComponent(btnNext)
                .addComponent(btnPrevious))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search by Reference:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Search by Item:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Search by Brand:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Search by Supplier:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Search by Unit:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addComponent(jLabel2)
                .addGap(134, 134, 134)
                .addComponent(jLabel3)
                .addGap(132, 132, 132)
                .addComponent(jLabel9)
                .addGap(135, 135, 135)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblTime.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 255, 255));
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTime.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lblCurrentUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCurrentUser.setForeground(new java.awt.Color(255, 255, 255));
        lblCurrentUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCurrentUser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCurrentUser, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(343, 343, 343)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCurrentUser, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(9, 9, 9)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        dataTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dataTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        dataTable.setGridColor(new java.awt.Color(0, 0, 0));
        dataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dataTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout bgPanelLayout = new javax.swing.GroupLayout(bgPanel);
        bgPanel.setLayout(bgPanelLayout);
        bgPanelLayout.setHorizontalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bgPanelLayout.setVerticalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setText("Options");

        btnAddProduct.setText("Add Product");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });
        jMenu1.add(btnAddProduct);

        printMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        printMenu.setText("Print Table Report");
        printMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printMenuActionPerformed(evt);
            }
        });
        jMenu1.add(printMenu);

        btnLogout.setSelected(true);
        btnLogout.setText("Log Out");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jMenu1.add(btnLogout);

        jMenuBar1.add(jMenu1);

        btnView.setText("View");

        btnProductView.setText("Product View");
        btnProductView.setEnabled(false);
        btnProductView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductViewActionPerformed(evt);
            }
        });
        btnView.add(btnProductView);

        btnUserView.setText("User View");
        btnUserView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserViewActionPerformed(evt);
            }
        });
        btnView.add(btnUserView);

        jMenuBar1.add(btnView);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold desc="OBJECT RESPONSIVE METHODS" defaultstate="collapsed">
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int confirmation = JOptionPane.showConfirmDialog(null,"Do you want to exit.","WARNING",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(confirmation == JOptionPane.YES_OPTION){ 
            this.dispose();
        }else{
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }    
    }//GEN-LAST:event_formWindowClosing

    private void printMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printMenuActionPerformed
        int[] rows = dataTable.getSelectedRows();
        String[][] productData = new String[rows.length][12];
        for(int i=0; i<rows.length; i++) {
            productData[i] = productList[rows[i]];
        }
        ExcelReportService.printProducts(productData);
    }//GEN-LAST:event_printMenuActionPerformed

    private void dataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTableMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()>1) {
            JTable source = (JTable)evt.getSource();
            int row = source.rowAtPoint( evt.getPoint());
            setEnabled(false);
            if(productsTableMode) {
                ViewProductInfo viewProductInfo = new ViewProductInfo(Integer.parseInt(productList[row][12]), this);
                viewProductInfo.setVisible(true);
            } else {
                ViewUserInfo viewUserInfo = new ViewUserInfo(Integer.parseInt(userList[row][10]), this);
                viewUserInfo.setVisible(true);
            }
        }
        
    }//GEN-LAST:event_dataTableMouseClicked

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        // TODO add your handling code here:
        productsTableMode = true;
        setEnabled(false);
        new AddProduct(this).setVisible(true);
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void btnUserViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserViewActionPerformed
        // TODO add your handling code here:
        productsTableMode = false;
        String[] userColumn = new String[]{"Employee ID", "Username", "Authority", "Last Name", "First Name", "Middle Name", "Contact", "E-mail", "Address"};
        userList = UserService.getAllUsers();
        DefaultTableModel model = new DefaultTableModel(userList, userColumn);
        dataTable.setModel(model);
        System.out.println("User Table RELOADED!!!");
        btnUserView.setEnabled(false);
        btnProductView.setEnabled(true);
        enableSearchFields(false);
    }//GEN-LAST:event_btnUserViewActionPerformed

    private void btnProductViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductViewActionPerformed
        // TODO add your handling code here:
        enableSearchFields(true);
        btnUserView.setEnabled(true);
        btnProductView.setEnabled(false);
        reloadTable();
    }//GEN-LAST:event_btnProductViewActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        start -= 28;
        if(start < 1) {
            start = 0;
            btnPrevious.setEnabled(false);
        } else {
            if(searching){
                searchProducts();
            } else {
                reloadTable();
            }
        }
        btnNext.setEnabled(true);
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        start += 28;
        btnNext.setEnabled(!(start+28>listCount));
        btnPrevious.setEnabled(true);
        if(searching) {
            searchProducts();
        } else {
            reloadTable();
        }
        System.out.println(listCount + ": TOTAL LIST COUNT");
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        int confirmation = JOptionPane.showConfirmDialog(null,"Do you want to Logout your account?","CONFIRM LOGOUT",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(confirmation == JOptionPane.YES_OPTION){ 
            this.dispose();
            Login login = new Login();
            login.setVisible(true);
            login.requestFocus();
            if(ProductTable.currentUser.getAuthority().equals("ADMIN")) NetworkHandlerService.closeAllServerConnections();
            else NetworkHandlerService.closeConnection();
            ProductTable.currentUser = null;
        }else{
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }    
    }//GEN-LAST:event_btnLogoutActionPerformed
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("absIcon.png")));
    }
    private void disableResizeFrame(javax.swing.JFrame frame) {
       frame.setResizable(false);
    }
    // </editor-fold>
    
    //<editor-fold desc="MAIN METHOD" defaultstate="collapsed">
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
            java.util.logging.Logger.getLogger(ProductsTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductsTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductsTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductsTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductsTable().setVisible(true);
            }
        });
    }
    //</editor-fold>
    
    //<editor-fold desc="OBJECT DECLARATIONS" defaultstate="collapsed">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgPanel;
    private javax.swing.JMenuItem btnAddProduct;
    private javax.swing.JCheckBoxMenuItem btnLogout;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JMenuItem btnProductView;
    private javax.swing.JMenuItem btnUserView;
    private javax.swing.JMenu btnView;
    private javax.swing.JTable dataTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCurrentUser;
    private javax.swing.JLabel lblTime;
    private javax.swing.JMenuItem printMenu;
    private javax.swing.JTextField txtSearchBrand;
    private javax.swing.JTextField txtSearchItemName;
    private javax.swing.JTextField txtSearchReference;
    private javax.swing.JTextField txtSearchSupplierName;
    private javax.swing.JTextField txtSearchUnit;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
}
