/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import javax.swing.ImageIcon;

/**
 *
 * @author Jovanie
 */

public class IconGenerator {
    /**
     * Mockup Solution in "icon null pointer exeption". This class to generate icon on any swing container
     */
   
   protected ImageIcon createImageIcon(String path,String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        }else{
            System.err.println("Couldn't find file: " + path);
            return null;
        }
   } 
}
