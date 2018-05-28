/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Services.UserService;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.image.ColorModel;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Jovanie
 */
public class CreateAccount extends javax.swing.JFrame {

    /**
     * Creates new form CreateAccount2
     */
    
    JTextComponent[] fields;
    JLabel[] labels;
    
    private final static Logger logger = Logger.getLogger(CreateAccount.class.getName());
    
    private static EmailValidator emailValidator;
    private IconGenerator iconGenerator;
    
    
    //String messages
    String requiredMessage = "field is required.";
    String errorMessage = "invalid input.";
    String allRequired = "all field must be required.";
    
    //Color
    Color colorError = Color.RED;
    Color colorValid = Color.GREEN;
    Color colorDefault = Color.BLACK;
    Color color;
    
    int errorIcon = JOptionPane.ERROR_MESSAGE;
    int validIcon = JOptionPane.INFORMATION_MESSAGE;
    
    JFrame previousForm;
    
    private boolean catchRequired = false;
    
    public CreateAccount() {
        initComponents();
        setLimitOnTextFields();
        prepareForm();
    }
    
    public CreateAccount(javax.swing.JFrame previousForm) {
        initComponents();
        this.previousForm = previousForm;
        setLimitOnTextFields();        
        prepareForm();
       
    }
    
    //void confirmation password
    private boolean isPasswordMatched(){
         boolean confirm= false;
          if(Arrays.equals(txtPassword.getPassword(), txtConfirmPassword.getPassword())){
              confirm = true;
              consolePrint("tama yung password");
          }else{
              confirm = false;
              consolePrint("Error yung password.");
          }
          return confirm;
    }
    
    private void prepareForm() {
        color = lblUsername.getForeground();
        fields = new JTextComponent[]{txtEmployeeNo, txtUsername, txtPassword, txtConfirmPassword, txtFirstName, 
        txtMiddleName, txtLastName, txtEmailAddress, txtContactNumber, txtAddress};
        labels = new JLabel[]{lblEmployeeNo, lblUsername, lblPassword, lblConfirmPassword, lblFirstName,
        lblMiddleName, lblLastName, lblEmailAddress, lblContactNumber, lblAddress};
        int i =0;
        for(JTextComponent component : fields) {
//            component.setBackground(Color.RED);
//            component.addFocusListener(new java.awt.event.FocusAdapter() {
//                public void focusGained(java.awt.event.FocusEvent evt) {
//                    componentFocusGained(component, evt);
//                }
//            });
            final int index = i;
            labels[i].setForeground(Color.RED);
            component.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            if(component.getText().isEmpty()) {
                                System.out.println("RED");
                                labels[index].setForeground(Color.RED);
                            } else {
                                System.out.println("DEFAULT");
                                labels[index].setForeground(color);
                            }
                        }
                    });
                }
            });
            i++;
        }
    }
    
    private void componentFocusGained(JComponent component, java.awt.event.FocusEvent evt) {
        component.setBackground(color);
        lblErrorMessage.setText("");
    }
    
    //void setLimitOnFields
    private void setLimitOnTextFields(){      
        txtUsername.setDocument(new JTextFieldLimit((20)));
        txtPassword.setDocument(new JTextFieldLimit((20)));
        txtConfirmPassword.setDocument(new JTextFieldLimit((20)));
        txtEmailAddress.setDocument(new JTextFieldLimit((40)));
    }
       
    private void txtfieldValidation(){
       someFieldEmpty();
       if(txtUsername.getText().isEmpty()){lblUsername.setForeground(colorError);}else{lblUsername.setForeground(colorDefault);}
       if(txtPassword.getText().isEmpty()){lblPassword.setForeground(colorError);}else{lblPassword.setForeground(colorDefault);}
       if(txtPassword.getText().isEmpty()){lblConfirmPassword.setForeground(colorError);}else{lblConfirmPassword.setForeground(colorDefault);}
       if(txtFirstName.getText().isEmpty()){lblFirstName.setForeground(colorError);}else{lblFirstName.setForeground(colorDefault);}
       if(txtLastName.getText().isEmpty()){lblLastName.setForeground(colorError);}else{lblLastName.setForeground(colorDefault);}
       if(txtMiddleName.getText().isEmpty()){lblMiddleName.setForeground(colorError);}else{lblMiddleName.setForeground(colorDefault);}
       if(txtEmailAddress.getText().isEmpty()){lblEmailAddress.setForeground(colorError);}else{lblEmailAddress.setForeground(colorDefault);}
       if(txtContactNumber.getText().isEmpty()){lblContactNumber.setForeground(colorError);}else{lblContactNumber.setForeground(colorDefault);}
       if(txtAddress.getText().isEmpty()){lblAddress.setForeground(colorError);}else{lblAddress.setForeground(colorDefault);}
//       if(comboBox.getS){}else{}
    }
 
   private String consolePrint(java.lang.String a){
       System.out.println(a);
       return a;
   }
   
   private boolean someFieldEmpty(){
        if(txtUsername.getText().isEmpty() || txtUsername.getText().isEmpty() 
               || txtConfirmPassword.getText().isEmpty() || txtFirstName.getText().isEmpty()
               || txtLastName.getText().isEmpty() || txtMiddleName.getText().isEmpty() 
               || txtContactNumber.getText().isEmpty() || txtEmailAddress.getText().isEmpty()
               || txtAddress.getText().isEmpty()){
          lblErrorMessage.setText(allRequired.toUpperCase());
          lblErrorMessage.setVisible(true);
          logger.log(Level.SEVERE, allRequired);
          return true;
       }else{
           lblErrorMessage.setVisible(false);
           logger.log(Level.SEVERE, requiredMessage);
           return false;
       }
   }
    
//    private void setIcon() {
//        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("absIcon.png")));
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblConfirmPassword = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        lblMiddleName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblEmailAddress = new javax.swing.JLabel();
        lblContactNumber = new javax.swing.JLabel();
        txtContactNumber = new javax.swing.JTextField();
        txtEmailAddress = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtMiddleName = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmPassword = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        lblAuthority = new javax.swing.JLabel();
        cbxAuthority = new javax.swing.JComboBox<>();
        lblAddress = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        lblErrorMessage = new javax.swing.JLabel();
        lblEmployeeNo = new javax.swing.JLabel();
        txtEmployeeNo = new javax.swing.JTextField();
        btnCreateAccount = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CreateAccount"); // NOI18N
        setIconImage(getIconImage());
        setIconImages(null);
        setName("Create Account"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel4.setBackground(new java.awt.Color(0, 102, 0));

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblUsername.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUsername.setLabelFor(txtUsername);
        lblUsername.setText("USERNAME*");

        lblPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPassword.setLabelFor(txtPassword);
        lblPassword.setText("PASSWORD*");

        lblConfirmPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblConfirmPassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblConfirmPassword.setLabelFor(txtConfirmPassword);
        lblConfirmPassword.setText("CONFIRM PASSWORD*");

        lblFirstName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFirstName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFirstName.setLabelFor(txtFirstName);
        lblFirstName.setText("FIRST NAME*");

        lblMiddleName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMiddleName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMiddleName.setLabelFor(txtMiddleName);
        lblMiddleName.setText("MIDDLE NAME*");

        lblLastName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblLastName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLastName.setLabelFor(txtLastName);
        lblLastName.setText("LAST NAME*");

        lblEmailAddress.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEmailAddress.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEmailAddress.setLabelFor(txtEmailAddress);
        lblEmailAddress.setText("EMAIL ADDRESS*");

        lblContactNumber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblContactNumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblContactNumber.setLabelFor(txtContactNumber);
        lblContactNumber.setText("CONTACT NUMBER*");

        txtContactNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtContactNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContactNumber.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtEmailAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEmailAddress.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmailAddress.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtLastName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtLastName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLastName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtMiddleName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMiddleName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMiddleName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtFirstName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtFirstName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFirstName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsername.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtUsername.setName("USERNAME"); // NOI18N

        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        txtConfirmPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtConfirmPassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblConfirmPassword)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblContactNumber))))
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(txtMiddleName)
                    .addComponent(txtLastName)
                    .addComponent(txtEmailAddress)
                    .addComponent(txtContactNumber)
                    .addComponent(txtUsername)
                    .addComponent(txtPassword)
                    .addComponent(txtConfirmPassword))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblConfirmPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblAuthority.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAuthority.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAuthority.setLabelFor(cbxAuthority);
        lblAuthority.setText("AUTHORITY*");

        cbxAuthority.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxAuthority.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EMPLOYEE", "ADMIN", " ", " " }));
        cbxAuthority.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblAddress.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAddress.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAddress.setLabelFor(txtAddress);
        lblAddress.setText("HOME ADDRESS*");

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        txtAddress.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(txtAddress);

        lblErrorMessage.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblErrorMessage.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorMessage.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblEmployeeNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEmployeeNo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEmployeeNo.setLabelFor(txtUsername);
        lblEmployeeNo.setText("EMPLOYEE NO.*");

        txtEmployeeNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEmployeeNo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmployeeNo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtEmployeeNo.setName("USERNAME"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblErrorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmployeeNo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAuthority, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxAuthority, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmployeeNo))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmployeeNo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmployeeNo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAuthority, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxAuthority, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(lblErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnCreateAccount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCreateAccount.setForeground(new java.awt.Color(0, 102, 102));
        btnCreateAccount.setText("CREATE ACCOUNT");
        btnCreateAccount.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreateAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("A    B    S    O   L   U   T   E");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Industiral  Solutions Inc");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Absolute Solution for your Bussiness needs");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(447, 447, 447))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 11, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(2, 2, 2)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //Todo add your handling here:
        int confirmation = JOptionPane.showConfirmDialog(null,"Do you want to exit.","WARNING",JOptionPane.YES_OPTION,errorIcon);
        if(confirmation == JOptionPane.YES_OPTION){ 
            this.dispose();
            new Login().setVisible(true);
        }else{
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }    
    }//GEN-LAST:event_formWindowClosing

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccountActionPerformed
        // TODO add your handling code here:
        txtfieldValidation();

        //Todo make a boolean for email validation
       boolean validEmail = emailValidator.validateEmail(txtEmailAddress.getText());    

       if(someFieldEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill up all required text fields", "INCOMPLETE FORM", 0);
        } else if(!validEmail) {
            JOptionPane.showMessageDialog(null, "Please enter a valid e-mail", "INVALID EMAIL", 0);
            logger.log(Level.SEVERE, "email not valid.", validEmail);
        } else if(!isPasswordMatched()) {
            JOptionPane.showMessageDialog(null, "Password not matched!!", "UNMATCHED PASSWORD", 0);
        } else if(UserService.isUsernameExists(txtUsername.getText().trim())){
            JOptionPane.showMessageDialog(null, "Username already exists", "USERNAME EXISTS", 0);
        } else {
            if(JOptionPane.showConfirmDialog(null, "Are you sure you want to create this user?", "CONFIRM CREATE USER", JOptionPane.OK_CANCEL_OPTION, 3) == 0) {
                String employee_id = txtEmployeeNo.getText().trim();
                String username = txtUsername.getText().trim();
                String password = String.valueOf(txtPassword.getPassword());
                String firstName = txtFirstName.getText().trim();
                String middleName = txtMiddleName.getText().trim();
                String lastName = txtLastName.getText().trim();
                String authority = cbxAuthority.getSelectedItem().toString();
                String email = txtEmailAddress.getText().trim();
                String contact = txtContactNumber.getText().trim();
                String address = txtAddress.getText().trim();
                if(UserService.createUser(employee_id, username, password, firstName, middleName, lastName, authority, email, contact, address)){
                    String successPrompt = "NEW USER SUCCESSFULLY CREATED: \n" +
                            "Username: \t" +    username    + "\n" +
                            "Password: \t" +    password    + "\n" +
                            "Employee ID: \t" + employee_id + "\n" +
                            "First Name: \t" +  firstName   + "\n" +
                            "Middle Name: \t" + middleName  + "\n" +
                            "Last Name: \t" +   lastName    + "\n" +
                            "Authority: \t" +   authority   + "\n" +
                            "E-mail: \t" +      email       + "\n" +
                            "Contact: \t" +     contact     + "\n" +
                            "Address: \t" +     address;
                    for(JTextComponent component : fields) {
                      component.setText("");
                    }
                    JOptionPane.showMessageDialog(null, successPrompt, "CREATE SUCCESS", 1);
                } else {
                    JOptionPane.showMessageDialog(null, "USER FAILED TO CREATE\nPLEASE CONTACT THE ADMINISTRATOR!", "CREATE FAILED", 0);
                }    
            }
            
        }
        
    }//GEN-LAST:event_btnCreateAccountActionPerformed
       
    
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
            java.util.logging.Logger.getLogger(CreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateAccount;
    private javax.swing.JComboBox<String> cbxAuthority;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAuthority;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblContactNumber;
    private javax.swing.JLabel lblEmailAddress;
    private javax.swing.JLabel lblEmployeeNo;
    private javax.swing.JLabel lblErrorMessage;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblMiddleName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtEmailAddress;
    private javax.swing.JTextField txtEmployeeNo;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMiddleName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

}
