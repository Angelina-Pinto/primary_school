/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import models.Curso;
import models.Estudiante;

/**
 *
 * @author Dell
 */
public class Matricula {
     private Estudiante estudiante;
    private Curso curso;  // El nombre de la variable debe ser en minúsculas
    private String fechaMatricula;
    private String estado; 
    
     public Matricula(Estudiante estudiante, Curso curso, String fechaMatricula) {
        this.estudiante = estudiante;
        this.curso = curso;  // Usamos la variable en minúsculas
        this.fechaMatricula = fechaMatricula;
        this.estado = "Activa";  // Por defecto, la matrícula es activa
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {  // En minúsculas
        return curso;
    }

    public void setCurso(Curso curso) {  // En minúsculas
        this.curso = curso;
    }

    public String getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(String fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Método para cancelar la matrícula
    public void cancelarMatricula() {
        this.estado = "Cancelada";
    }

    // Método para activar la matrícula
    public void activarMatricula() {
        this.estado = "Activa";
    }

    // Método para mostrar la información de la matrícula
    public void mostrarInformacionMatricula() {
        System.out.println("Matrícula - Estudiante: " + estudiante.getNombre() + 
                           ", Curso: " + curso.getNombreCurso() +  // Llamada al método correcto
                           ", Fecha: " + fechaMatricula + 
                           ", Estado: " + estado);
    }

}
