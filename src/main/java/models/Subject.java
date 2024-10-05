/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Dell
 */
public class Subject {
   private int  id_subject;
   private String subject_name;
   
    public Subject() {
        // Este constructor no hace nada, pero permite crear un objeto sin parámetros
    }
   
   public Subject(int id_subject,String subject_name){
        this.id_subject=id_subject;
        this.subject_name = subject_name;
   }

    /**
     * @return the id_subject
     */
    public int getId_subject() {
        return id_subject;
    }

    /**
     * @param id_subject the id_subject to set
     */
    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }

    /**
     * @return the subject_name
     */
    public String getSubject_name() {
        return subject_name;
    }

    /**
     * @param subject_name the subject_name to set
     */
    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }
   
   
   
}
