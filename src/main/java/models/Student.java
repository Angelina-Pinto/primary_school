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
    private String birthDate;
    private int age;
    private String sex;
    // Constructor
    
    
   public Student(int id_student,String firstName, String midleName, String firstSurname, String secondSurname, String birthDate, int age, String sex) {
       this.id_student = id_student;
       this.firstName = firstName;
        this.midleName = midleName;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.birthDate = birthDate;
        this.age = age;
        this.sex = sex;
    }
 /**
     * @return the firstName
     */
    public int getIdStudent() {
        return id_student;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setIdStudent(int id_student) {
        this.id_student = id_student;
    }
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the midleName
     */
    public String getMidleName() {
        return midleName;
    }

    /**
     * @param midleName the midleName to set
     */
    public void setMidleName(String midleName) {
        this.midleName = midleName;
    }

    /**
     * @return the firstSurname
     */
    public String getFirstSurname() {
        return firstSurname;
    }

    /**
     * @param firstSurname the firstSurname to set
     */
    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    /**
     * @return the secondSurname
     */
    public String getSecondSurname() {
        return secondSurname;
    }

    /**
     * @param secondSurname the secondSurname to set
     */
    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    /**
     * @return the birthDate
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

   
}