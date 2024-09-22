/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;

/**
 *
 * @author Dell
 */
public class query extends connectionDB {
     Connection connection;
    PreparedStatement preparedStatement;
    
     public void insert() {
        String sql = "INSERT INTO tb_example (name, email) VALUES (?, ?)";
        try {
            connection = openDB();
            preparedStatement = connection.prepareStatement(sql);
            //numero de columna 
            preparedStatement.setString(1, "Juan Perez");
            preparedStatement.setString(2, "jperez@miumg.edu.gt");
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
