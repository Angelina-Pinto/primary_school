/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.primary_school;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import javax.swing.UIManager;
import screen.home;
import dao.query;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import static javax.swing.UIManager.put;
import models.Curso;
import models.Student;
import screen.subject;
/**
 *
 * @author Dell
 */
public class main {

    public static void main(String[] args) {
//         FlatLightLaf.setup();
//         FlatMaterialLighterIJTheme.setup();

//    
        UIManager.put( "Button.arc", 999 );
            home hom = new home();
            hom.setVisible(true);
        //System.out.println("Hello World!");
        
       // query myquery = new query();
       //myquery.insert();



    }
    
}
