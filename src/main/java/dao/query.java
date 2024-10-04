/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;
import models.Student;

/**
 *
 * @author Dell
 */
public class query extends connectionDB {
     Connection connection;
    PreparedStatement preparedStatement;
    
     public void insert(Student student) {
       // String sql = "INSERT INTO tb_example (name, email) VALUES (?, ?)";
  try {
    // Abrir la conexión a la base de datos
    connection = openDB();
    
    // Consulta SQL para insertar un estudiante con los campos modificados
    String sql = "INSERT INTO Student (firstName, midleName, firstSurname, secondSurname, birthDate, age, sex) VALUES (?, ?, ?, ?, ?, ?, ?)";

    // Preparar la consulta
    preparedStatement = connection.prepareStatement(sql);

    // Asignar valores a los parámetros
    preparedStatement.setString(1, student.getFirstName()); // Primer nombre (firstName)
    preparedStatement.setString(2, student.getMidleName()); // Segundo nombre (midleName)
    preparedStatement.setString(3, student.getFirstSurname()); // Primer apellido (firstSurname)
    preparedStatement.setString(4, student.getSecondSurname()); // Segundo apellido (secondSurname)
    preparedStatement.setDate(5, java.sql.Date.valueOf(student.getBirthDate())); // Fecha de nacimiento (birthDate)
    preparedStatement.setInt(6, student.getAge()); // Edad (age)
    preparedStatement.setString(7, student.getSex()); // Sexo (sex: 'M' o 'F')

    // Ejecutar la consulta
    preparedStatement.executeUpdate();

    // Cerrar el preparedStatement y la conexión
    preparedStatement.close();
    connection.close();
} catch (SQLException ex) {
    Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
}


    }
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try {
            connection = openDB();
            String sql = "SELECT id_student, firstName, midleName, firstSurname, secondSurname, birthDate, age, sex FROM Student";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student(
                    resultSet.getInt("id_student"), // Recupera el id_student
                    resultSet.getString("firstName"),
                    resultSet.getString("midleName"),
                    resultSet.getString("firstSurname"),
                    resultSet.getString("secondSurname"),
                    resultSet.getString("birthDate"),
                    resultSet.getInt("age"),
                    resultSet.getString("sex")
                );
                students.add(student);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
}
