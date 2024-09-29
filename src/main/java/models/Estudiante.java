/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Dell
 */


public class Estudiante {
    private String nombre;
    private int edad;
    private String id;
    private List<Matricula> cursosMatriculados;  // Lista para almacenar las matrículas

    // Constructor
    public Estudiante(String nombre, int edad, String id) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
        this.cursosMatriculados = new ArrayList<>(); // Inicialización de la lista
    }

    // Método para agregar un curso
    public void agregarCurso(Matricula matricula) {
        if (cursosMatriculados != null) {
            cursosMatriculados.add(matricula); // Agregar matrícula a la lista
        }
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getId() {
        return id;
    }

    public List<Matricula> getCursosMatriculados() {
        return cursosMatriculados;
    }

    // Otros métodos según sea necesario
}