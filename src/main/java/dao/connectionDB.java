/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class connectionDB {
    String dbUrl = "jdbc:mysql://localhost:3306/primarySchool";
    String username = "root";
    String password = "Rosul2022*";
    
    
    public Connection openDB() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, username, password);
        if (connection == null) {
            throw new SQLException("Can't connection to database");
        }
        return connection;
    }
}
