/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.primary_school;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import screen.home;
import dao.query;
/**
 *
 * @author Dell
 */
public class main {

    public static void main(String[] args) {
         FlatLightLaf.setup();
        UIManager.put( "Button.arc", 999 );
            
        System.out.println("Hello World!");
        
        query myquery = new query();
        myquery.insert();
//        home home_screen = new home();
//        home_screen.setVisible(true);
        
        
    }
}
