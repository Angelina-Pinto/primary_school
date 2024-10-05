/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Dell
 */


public class Student {
    private int id_student;
    private String firstName;
    private String midleName;
    private String firstSurname;
    private String secondSurname;
    private String birthDate; // Puedes usar java.sql.Date si estás manejando fechas directamente desde la base de datos
    private int age;
    private String sex;

    // Constructor completo
    public Student(int id_student, String firstName, String midleName, String firstSurname, String secondSurname, String birthDate, int age, String sex) {
        this.id_student = id_student;
        this.firstName = firstName;
        this.midleName = midleName;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.birthDate = birthDate;
        this.age = age;
        this.sex = sex;
    }

    // Constructor vacío por si lo necesitas en alguna parte del código
    public Student() {}

    // Getters y setters

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidleName() {
        return midleName;
    }

    public void setMidleName(String midleName) {
        this.midleName = midleName;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}