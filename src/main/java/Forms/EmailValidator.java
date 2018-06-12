/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

/**
 *
 * @author Jovanie
 * 
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
   
   /**
    * Inisang Class ko na lang para global at magamit in the future yung class
    * jovanie.daclizon 05-27-2018
    */ 
    
    //global boolean for email validation
    public static boolean validateEmail(String email){
        boolean status = false;
        //regex for all invalid characters of email
        String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\""
            + "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")"
            + "@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.)"
            + "{3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:"
            + "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\"
            + "[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
         
        //pattern
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        //matcher
        Matcher matcher = pattern.matcher(email);
        //status if match in regex true or false;
        status = (matcher.matches())? true : false;
        return status;
        
    }
  
}
