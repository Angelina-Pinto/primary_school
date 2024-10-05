/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Dell
 */

public class Qualification {
    private int id_qualification;    // Identificador de la calificación
    private int id_student;           // ID del estudiante
    private int id_subject;           // ID de la materia
    private double bimester_1;        // Calificación del primer bimestre
    private double bimester_2;        // Calificación del segundo bimestre
    private double bimester_3;        // Calificación del tercer bimestre
    private double bimester_4;        // Calificación del cuarto bimestre
    private double final_average;     // Promedio final calculado
    private String status;            // Estado de aprobación

    public Qualification(int id_qualification, int id_student, int id_subject,
                         double bimester_1, double bimester_2, double bimester_3, double bimester_4,
                         double final_average, String status) {
        this.id_qualification = id_qualification;
        this.id_student = id_student;
        this.id_subject = id_subject;
        this.bimester_1 = bimester_1;
        this.bimester_2 = bimester_2;
        this.bimester_3 = bimester_3;
        this.bimester_4 = bimester_4;
        this.final_average = final_average;
        this.status = status;
    }

    // Getters y Setters
    public int getId_qualification() {
        return id_qualification;
    }

    public void setId_qualification(int id_qualification) {
        this.id_qualification = id_qualification;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public int getId_subject() {
        return id_subject;
    }

    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }

    public double getBimester_1() {
        return bimester_1;
    }

    public void setBimester_1(double bimester_1) {
        this.bimester_1 = bimester_1;
    }

    public double getBimester_2() {
        return bimester_2;
    }

    public void setBimester_2(double bimester_2) {
        this.bimester_2 = bimester_2;
    }

    public double getBimester_3() {
        return bimester_3;
    }

    public void setBimester_3(double bimester_3) {
        this.bimester_3 = bimester_3;
    }

    public double getBimester_4() {
        return bimester_4;
    }

    public void setBimester_4(double bimester_4) {
        this.bimester_4 = bimester_4;
    }

    public double getFinal_average() {
        return final_average;
    }

    public void setFinal_average(double final_average) {
        this.final_average = final_average;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
