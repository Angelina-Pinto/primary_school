/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.primary_school;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import javax.swing.UIManager;
import screen.home;
import dao.query;
import javax.swing.JLabel;
/**
 *
 * @author Dell
 */
public class main {

    public static void main(String[] args) {
         //FlatLightLaf.setup();
         FlatMaterialLighterIJTheme.setup();
         
        //UIManager.put( "Button.arc", 999 );
            
        //System.out.println("Hello World!");
        
        query myquery = new query();
        myquery.insert();
        home home_screen = new home();
        
        
        
       
       
        home_screen.setVisible(true);
        
        
    }
}
