/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utilities.HibernateUtil;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author AISI-IVY
 */
public class JSONService {
    
    private static boolean connected = false;
    private static File file;
    private static JSONObject object;
    private static String path = "extra-resources\\databaseconfig.json";
    
    public static JSONObject getJSONFile() {
        JSONObject p = new JSONObject();
        try {
            JSONParser parser = new JSONParser();
            File file = new File(path);
            if(file.createNewFile()) {
                setJSONFile();
            }
            file = new File(path);
            p = (JSONObject) parser.parse(new FileReader(file));
            return p;
        } catch (Exception ex) {
            Logger.getLogger(HibernateUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
        
    }
    
    public static void setJSONFile() {
        JSONObject p = new JSONObject();
        java.io.FileReader reader = null;
        JPanel configPanel = new JPanel();
        configPanel.setLayout(new GridLayout(4, 2, 10, 10));
        JLabel lblDbName = new JLabel("DATABASE NAME:  ");
        lblDbName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JTextField txtDbName = new JTextField(30);
        JLabel lblHostIP = new JLabel("HOST IP:  ");
        lblHostIP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JTextField txtHostIP = new JTextField(30);
        JLabel lblUsername = new JLabel("USERNAME:  ");
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JTextField txtUsername = new JTextField(30);
        JLabel lblPassword = new JLabel("PASSWORD:  ");
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JTextField txtPassword = new JTextField(30);
        configPanel.add(lblDbName);
        configPanel.add(txtDbName);
        configPanel.add(lblHostIP);
        configPanel.add(txtHostIP);
        configPanel.add(lblUsername);
        configPanel.add(txtUsername);
        configPanel.add(lblPassword);
        configPanel.add(txtPassword);
        int selection = JOptionPane.showOptionDialog(null, configPanel, "SET DATABASE CONFIGURATION", 
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"OK", "CANCEL"}, null);
        try {
            if(selection == 0) {
                String dbName = txtDbName.getText().trim();
                String hostIP = txtHostIP.getText().trim();
                String username = txtUsername.getText().trim();
                String password = txtPassword.getText().trim();
                String url = "jdbc:mysql://" + hostIP + ":3306/" + dbName + "?zeroDateTimeBehavior=convertToNull";
                p.put("hibernate.connection.url", url);
                p.put("hibernate.connection.username", username);
                p.put("hibernate.connection.password", password);
                FileWriter writeFile = new FileWriter(path);
                writeFile.write(p.toString());
                System.out.println(p.toString());
                System.out.println("Successfully Copied JSON Object to File...");
                System.out.println("\nJSON Object: " + p);
                writeFile.close();
                reader = new java.io.FileReader(path);
                org.json.simple.parser.JSONParser parser = new JSONParser();
                p = (JSONObject) parser.parse(reader);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(JSONService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(JSONService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
