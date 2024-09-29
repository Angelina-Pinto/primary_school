/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Dell
 */
public class conductor {
     private String nombre;
    private String licencia;

    
      public conductor(String nombre, String licencia) {
        this.nombre = nombre;
        this.licencia = licencia;
    }
       public String getNombre() {
        return nombre;
    }

    public String getLicencia() {
        return licencia;
    }

    @Override
    public String toString() {
        return "Conductor [Nombre=" + nombre + ", Licencia=" + licencia + "]";
    }
    
}
