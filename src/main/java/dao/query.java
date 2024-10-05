/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Qualification;
import models.Student;
import models.Subject;

/**
 *
 * @author Dell
 */
public class query extends connectionDB {
     Connection connection;
    PreparedStatement preparedStatement;
     /**
     * metodo que inserta estudiante 
     *
     *  objeto de tipo estudiante
     */
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
     
     /**
 *
 * Metodo que inserta materias
 */
     public void insertSubject(Subject subject) {
    try {
        // Abrir la conexión a la base de datos
        connection = openDB();

        // Consulta SQL para insertar una materia
        String sql = "INSERT INTO Subject (subject_name) VALUES (?)";

        // Preparar la consulta
        preparedStatement = connection.prepareStatement(sql);

        // Asignar valor al parámetro
        preparedStatement.setString(1, subject.getSubject_name());

        // Ejecutar la consulta
        preparedStatement.executeUpdate();

        // Cerrar preparedStatement y la conexión
        preparedStatement.close();
        connection.close();
    } catch (SQLException ex) {
        Logger.getLogger(query.class.getName()).log(Level.SEVERE, null, ex);
    }
}
     
     /**
 *
 * metodo que inserta calificaciones dependiendo de que bimestre se haya 
 * asi ingresa la nota 
 */
     public boolean insertQualification(int idStudent, int idSubject, double grade, int bimesterNumber) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    boolean isInserted = false; // Para controlar si la inserción fue exitosa

    try {
        connection = openDB(); // Método que abre la conexión a la base de datos

        // Consulta SQL para insertar la calificación en el bimestre correspondiente
        String sql = "INSERT INTO Qualification (id_student, id_subject, bimester_1, bimester_2, bimester_3, bimester_4, final_average) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idStudent); // Establecer el ID del estudiante
        preparedStatement.setInt(2, idSubject); // Establecer el ID de la materia

        // Inicializar las calificaciones de los bimestres a 0
        double bimester1 = 0.0;
        double bimester2 = 0.0;
        double bimester3 = 0.0;
        double bimester4 = 0.0;

        // Establecer la calificación según el bimestre
        switch (bimesterNumber) {
            case 1:
                bimester1 = grade; // Calificación para el 1er bimestre
                break;
            case 2:
                bimester2 = grade; // Calificación para el 2do bimestre
                break;
            case 3:
                bimester3 = grade; // Calificación para el 3er bimestre
                break;
            case 4:
                bimester4 = grade; // Calificación para el 4to bimestre
                break;
            default:
                throw new IllegalArgumentException("Número de bimestre inválido: " + bimesterNumber);
        }

        // Calcular el promedio final
        double finalAverage = (bimester1 + bimester2 + bimester3 + bimester4) / 4.0;

        // Establecer las calificaciones de los bimestres
        preparedStatement.setDouble(3, bimester1);
        preparedStatement.setDouble(4, bimester2);
        preparedStatement.setDouble(5, bimester3);
        preparedStatement.setDouble(6, bimester4);
        preparedStatement.setDouble(7, finalAverage);

        // Ejecutar la inserción
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            isInserted = true; // Se insertó al menos una fila

            // Actualizar el estado de aprobado o no aprobado
            updateQualificationStatus(idStudent, idSubject);
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Imprimir la excepción en caso de error
    } finally {
        // Cerrar los recursos
        try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if (connection != null) connection.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
    return isInserted; // Devolver true si se insertó correctamente, false en caso contrario
}
/**
 *
 * Funcion que guarda el promedio 
 * toma el id de estudiante y el id de materia y toma las notas
 * * para calcular el porcentaje
 */
private void updateQualificationStatus(int idStudent, int idSubject) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
        connection = openDB(); // Método que abre la conexión a la base de datos

        // Actualizar el estado de aprobado o no aprobado basado en el promedio final
        String sql = "UPDATE Qualification " +
                     "SET status = CASE " +
                     "WHEN final_average >= 60 AND final_average <= 80 THEN 'Aprobado' " +
                     "ELSE 'No Aprobado' END " +
                     "WHERE id_student = ? AND id_subject = ?";

        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idStudent);
        preparedStatement.setInt(2, idSubject);

        preparedStatement.executeUpdate(); // Ejecutar la actualización
    } catch (SQLException ex) {
        ex.printStackTrace(); // Manejo de excepciones
    } finally {
        // Cerrar los recursos
        try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if (connection != null) connection.close(); } catch (SQLException e) { e.printStackTrace(); }
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
    
    public List<Student> getStudentNamesAndIds() {
    List<Student> students = new ArrayList<>();
    try {
        connection = openDB();
        String sql = "SELECT id_student, firstName, firstSurname FROM Student";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            // Solo obtener el id y el nombre del estudiante
            Student student = new Student();
            student.setId_student(resultSet.getInt("id_student"));
            student.setFirstName(resultSet.getString("firstName"));
            student.setFirstSurname(resultSet.getString("firstSurname"));
            students.add(student);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    } catch (SQLException ex) {
        Logger.getLogger(query.class.getName()).log(Level.SEVERE, null, ex);
    }
    return students;
}
    public int getStudentIdByNameAndLastName(String firstName, String firstSurname) {
    int studentId = -1; // Valor predeterminado si no se encuentra
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;

    try {
        connection = openDB(); // Asegúrate de que esta función esté definida
        String sql = "SELECT id_student FROM Student WHERE firstName = ? AND firstSurname = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, firstName); // Establecer el primer nombre en el primer parámetro
        preparedStatement.setString(2, firstSurname); // Establecer el apellido en el segundo parámetro
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            studentId = resultSet.getInt("id_student"); // Asegúrate de que el nombre de la columna sea correcto
        }
    } catch (SQLException ex) {
        Logger.getLogger(query.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Asegúrate de cerrar todos los recursos
        try { if (resultSet != null) resultSet.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if (connection != null) connection.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
    return studentId; // Retorna el id del estudiante o -1 si no se encontró
}

public List<Subject> getAllSubjects() {
    List<Subject> subjects = new ArrayList<>();
    try {
        // Abrir conexión con la base de datos
        connection = openDB();

        // Consulta SQL para obtener el id y nombre de las materias
        String sql = "SELECT id_subject, subject_name FROM Subject";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        // Iterar sobre el resultado de la consulta
        while (resultSet.next()) {
            // Crear un objeto Subject con id y nombre
            Subject subject = new Subject();
            subject.setId_subject(resultSet.getInt("id_subject"));
            subject.setSubject_name(resultSet.getString("subject_name"));
            subjects.add(subject); // Añadir la materia a la lista
        }

        // Cerrar recursos
        resultSet.close();
        preparedStatement.close();
        connection.close();
    } catch (SQLException ex) {
        Logger.getLogger(query.class.getName()).log(Level.SEVERE, null, ex);
    }

    // Retornar la lista de materias
    return subjects;
}
 
   public int getSubjectIdByName(String subjectName) {
        int subjectId = -1; // Valor predeterminado si no se encuentra
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = openDB(); // Asegúrate de que esta función esté definida
            String sql = "SELECT id_subject FROM Subject WHERE subject_name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, subjectName); // Establecer el nombre de la materia en el primer parámetro
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                subjectId = resultSet.getInt("id_subject"); // Obtiene el ID de la materia
            }
        } catch (SQLException ex) {
            Logger.getLogger(query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Asegúrate de cerrar todos los recursos
            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (connection != null) connection.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return subjectId; // Retorna el id de la materia o -1 si no se encontró
    }
   
   public List<Qualification> getAllQualifications() {
    List<Qualification> qualifications = new ArrayList<>();
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;

    // Definir la consulta SQL
    String sql = "SELECT q.id_qualification, s.id_student, s.firstName, s.firstSurname, " +
                 "sub.id_subject, sub.subject_name, " +
                 "q.bimester_1, q.bimester_2, q.bimester_3, q.bimester_4, " +
                 "q.final_average, q.status " +
                 "FROM Qualification q " +
                 "JOIN Student s ON q.id_student = s.id_student " +
                 "JOIN Subject sub ON q.id_subject = sub.id_subject";

    try {
        connection = openDB(); // Asegúrate de que esta función esté definida
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();

        // Procesar el resultado de la consulta
        while (resultSet.next()) {
            Qualification qualification = new Qualification(
                resultSet.getInt("id_qualification"),
                resultSet.getInt("id_student"),
                resultSet.getInt("id_subject"),
                resultSet.getDouble("bimester_1"),
                resultSet.getDouble("bimester_2"),
                resultSet.getDouble("bimester_3"),
                resultSet.getDouble("bimester_4"),
                resultSet.getDouble("final_average"),
                resultSet.getString("status")
            );
            qualifications.add(qualification); // Agregar a la lista
        }

    } catch (SQLException e) {
        Logger.getLogger(query.class.getName()).log(Level.SEVERE, null, e); // Manejo de excepciones
    } finally {
        // Asegúrate de cerrar todos los recursos
        try { if (resultSet != null) resultSet.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if (connection != null) connection.close(); } catch (SQLException e) { e.printStackTrace(); }
    }

    return qualifications; // Retornar la lista de calificaciones
}

    
}
