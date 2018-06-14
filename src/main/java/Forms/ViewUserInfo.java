/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Entities.ProductTable;
import Entities.Users;
import Services.UserService;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.text.JTextComponent;

/**
 *
 * 05-19-2018
 */
public class ViewUserInfo extends javax.swing.JFrame {

    
    Users user;
    JTextComponent components[];
    private JFrame previousForm = null;
    
    /**
     * Creates new form ViewProduct
     */
    public ViewUserInfo() {
        initComponents();
    }

    ViewUserInfo(int userId, JFrame previousForm) {
        initComponents();
        this.previousForm = previousForm;
        components = new JTextComponent[]{txtEmployeeID, txtFirstName, txtMiddleName, txtLastName,
            txtUsername, txtEmail, txtContact, txtAddress};
        enableFields(false);    // disable all fields by default
        user = UserService.getUserBy(userId);
        initializeData();
    }
    
    /*****************************************CUSTOME METHODS*****************************************/
    
    // sets enability of fields
    private void enableFields(boolean enability){
        txtEmployeeID.setEditable(enability);
        txtFirstName.setEditable(enability);
        txtMiddleName.setEditable(enability);
        txtLastName.setEditable(enability);
        txtUserRole.setEditable(enability);
        txtUsername.setEditable(enability);
        txtEmail.setEditable(enability);
        txtContact.setEditable(enability);
        txtAddress.setEditable(enability);
        txtUserRole.setEnabled(enability);
    }
    
    // initialize fields with product passed
    private void initializeData() {
        try{
            lblName.setText(user.getFirstName() + " " + user.getMiddleName().charAt(0) + "." + user.getLastName());
            txtEmployeeID.setText(user.getEmployee_id());
            txtFirstName.setText(user.getFirstName());
            txtMiddleName.setText(user.getMiddleName());
            txtLastName.setText(user.getLastName());
            txtAddress.setText(user.getAddress());
            txtUserRole.setSelectedIndex(((user.getAuthority().equals("ADMIN"))?1:0));
            txtUsername.setText(user.getUsername());
            txtEmail.setText(user.getEmail());
            txtContact.setText(user.getContact());
            
        }catch(StringIndexOutOfBoundsException ex){
            System.err.println(ex);
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
        txtLastName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtEmployeeID = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        btnViewPassword = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtMiddleName = new javax.swing.JTextField();
        txtUserRole = new javax.swing.JComboBox<>();

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
        jLabel9.setText("LAST NAME:  ");

        txtLastName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtLastName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLastName.setToolTipText("");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("USER ROLE:  ");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("USERNAME:  ");

        txtUsername.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsername.setToolTipText("");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("E-MAIL:  ");

        txtEmail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setToolTipText("");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("CONTACT:  ");

        txtContact.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtContact.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContact.setToolTipText("");

        lblName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtAddress.setColumns(20);
        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAddress.setRows(5);
        jScrollPane1.setViewportView(txtAddress);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("EMPLOYEE ID:  ");

        txtEmployeeID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtEmployeeID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmployeeID.setToolTipText("");
        txtEmployeeID.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtFirstName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtFirstName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFirstName.setToolTipText("");

        btnViewPassword.setBackground(new java.awt.Color(0, 0, 0));
        btnViewPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnViewPassword.setForeground(new java.awt.Color(0, 153, 51));
        btnViewPassword.setText("View Password");
        btnViewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPasswordActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(0, 0, 0));
        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(0, 153, 51));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("FIRST NAME:  ");

        btnDelete.setBackground(new java.awt.Color(0, 0, 0));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 153, 0));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("ADDRESS:  ");

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("MIDDLE NAME:  ");

        txtMiddleName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMiddleName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMiddleName.setToolTipText("");

        txtUserRole.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtUserRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EMPLOYEE", "ADMIN" }));
        txtUserRole.setEnabled(false);
        txtUserRole.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                txtUserRoleCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnViewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtContact, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtUserRole, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUserRole, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnViewPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPasswordActionPerformed
        String message = "<html><strong style=\"color: red;\">Please enter your password to<br>view the password of this user.</strong></html";
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 5, 10));
        JLabel label = new JLabel(message);
        JPasswordField passwordField = new JPasswordField(15);
        panel.add(label);
        panel.add(passwordField);
        Object[] options1 = {"OK", "CHANGE PASSWORD", "CANCEL"};
        int result = JOptionPane.showOptionDialog(null, panel, "CONFIRM VIEW PASSWORD", 
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, null);
        if(result == 2) {
            
        }else if(String.valueOf(passwordField.getPassword())
                        .equals(ProductTable.currentUser.getPassword())) {
            switch(result) {
                case 0:
                    JOptionPane.showMessageDialog(null, "PASSWORD IS: " + user.getPassword());
                    break;
                case 1:
                    JPanel changePasswordPanel = new JPanel();
                    changePasswordPanel.setLayout(new GridLayout(3, 2, 10, 10));
                    JLabel oldPasswordLabel = new JLabel("OLD PASSWORD:  ");
                    oldPasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                    JLabel newPasswordLabel = new JLabel("NEW PASSWORD:  ");
                    newPasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                    JLabel confirmNewPasswordLabel = new JLabel("CONFIRM NEW PASSWORD:  ");
                    confirmNewPasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                    JPasswordField oldPasswordField = new JPasswordField(15);
                    JPasswordField newPasswordField = new JPasswordField(15);
                    JPasswordField confirmNewPasswordField = new JPasswordField(15);
                    changePasswordPanel.add(oldPasswordLabel);
                    changePasswordPanel.add(oldPasswordField);
                    changePasswordPanel.add(newPasswordLabel);
                    changePasswordPanel.add(newPasswordField);
                    changePasswordPanel.add(confirmNewPasswordLabel);
                    changePasswordPanel.add(confirmNewPasswordField);
                    int selection = JOptionPane.showOptionDialog(null, changePasswordPanel, "CHANGE PASSWORD", 
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"OK", "CANCEL"}, null);
                    if(!String.valueOf(oldPasswordField.getPassword()).equals(user.getPassword())) {
                        JOptionPane.showMessageDialog(null, "OLD PASSWORD DOES NOT MATCHED", "CHANGE PASSWORD FAILED", 0);
                    } else if(!String.valueOf(newPasswordField.getPassword()).equals(String.valueOf(confirmNewPasswordField.getPassword()))) {
                        JOptionPane.showMessageDialog(null, "NEW PASSWORD DOES NOT MATCHED", "CHANGE PASSWORD FAILED", 0);
                    }else {
                        if(selection == 0) {
                            if(UserService.updateUserPassword(user.getId(), String.valueOf(newPasswordField.getPassword()))) {
                                user = UserService.getUserBy(user.getId());
                                initializeData();
                                ProductTable.productsTableForm.updateUserTable();
                                JOptionPane.showMessageDialog(null, "Password successfully changed", "CHANGE PASSWORD SUCCESS" , 1);
                            } else {
                                JOptionPane.showMessageDialog(null, "CHANGE PASSWORD FAILED, PLEASE CONTACT TECHNICAL SUPPORT", "CHANGE PASSWORD FAILED", 0);
                            }
                        }
                    }
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Wrong Password", "ACCESS DENIED", 0);
        }
    }//GEN-LAST:event_btnViewPasswordActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if(btnEdit.getText().equals("Edit")) {
            btnBack.setText("Cancel");
            btnEdit.setText("Done!");
            btnViewPassword.setEnabled(false);
            btnDelete.setEnabled(false);
            enableFields(true);
            
        } else {
            btnEdit.setText("Edit");
            btnBack.setText("Back");
            if(JOptionPane.showConfirmDialog(null, "Are you sure you want to UPDATE this User?", "CONFIRM UPDATE", JOptionPane.OK_CANCEL_OPTION, 3) == 0) {
                user.setEmployee_id(txtEmployeeID.getText().trim());
                user.setFirstName(txtFirstName.getText().trim());
                user.setMiddleName(txtMiddleName.getText().trim());
                user.setLastName(txtLastName.getText().trim());
                user.setAuthority(txtUserRole.getSelectedItem().toString());
                user.setUsername(txtUsername.getText());
                user.setEmail(txtEmail.getText().trim());
                user.setContact(txtContact.getText().trim());
                user.setAddress(txtAddress.getText().trim());
                if(UserService.updateUser(user)) {    
                    JOptionPane.showMessageDialog(null, "Item successfully updated!", "UPDATE SUCCESS", 1);
                } else {
                    JOptionPane.showMessageDialog(null, "Item failed to update!", "UPDATE FAILED", 1);
                }
            } else initializeData();
            btnViewPassword.setEnabled(true);
            btnDelete.setEnabled(true);
            enableFields(false);
            btnBack.setText("Back");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete "+" "+user.getFirstName()+" "+user.getLastName(),"CONFIRM DELETE", JOptionPane.OK_CANCEL_OPTION, 3) == 0) {
            if(UserService.deleteUser(user)) {
                JOptionPane.showMessageDialog(null, lblName.getText()+" "+ "Useer Successfully Deleted!!", "DELETE SUCCESSFUL", 1);
                ProductTable.productsTableForm.reloadTable();
                ProductTable.productsTableForm.setEnabled(true);
                ProductTable.productsTableForm.requestFocus();
        dispose();
            } else {
                JOptionPane.showMessageDialog(null, lblName.getText() + " Unable to Delete!!", "DELETE FAILED", 0);
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
                ProductTable.productsTableForm.setVisible(true);
                ProductTable.productsTableForm.requestFocus();
            }
        } else {
            btnBack.setText("Back");
            btnEdit.setText("Edit");
            btnViewPassword.setEnabled(true);
            btnDelete.setEnabled(true);
            initializeData();
            enableFields(false);   
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtUserRoleCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtUserRoleCaretPositionChanged
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, evt.toString());
    }//GEN-LAST:event_txtUserRoleCaretPositionChanged

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
            java.util.logging.Logger.getLogger(ViewUserInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewUserInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewUserInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewUserInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewUserInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg_Panel;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnViewPassword;
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
    private javax.swing.JLabel lblName;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmployeeID;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMiddleName;
    private javax.swing.JComboBox<String> txtUserRole;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
