/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Jovanie
 */
public class JTextFieldLimit extends PlainDocument{
    /**
    * Inisang Class ko na lang para global at magamit in the future yung class
    * jovanie.daclizon 05-27-2018
    *
    */ 
    
    private final static Logger logger = Logger.getLogger(JTextFieldLimit.class.getName());
    private int limit;
    public JTextFieldLimit( int limit) {
        super();
        this.limit = limit;
        logger.log(Level.SEVERE,"JTextFiledLimit", limit);
    }

    //void
    public void insertString(int offset, String str, AttributeSet a) throws BadLocationException{
        if(str == null){
            return;
        }
        
        if((getLength() + str.length()) <= limit){
            logger.info("Text Field Limit" + str.length());
            super.insertString(offset, str, a);
        } 
    }
}
