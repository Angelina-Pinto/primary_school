/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Dell
 */
public class asignacion {
     private conductor conductor;
    private vehiculo vehiculo;
 private String estadoAsignacion; //
 
     public asignacion(conductor conductor, vehiculo vehiculo, String estadoAsignacion) {
         this.conductor = conductor;
        this.vehiculo = vehiculo;
        this.estadoAsignacion = estadoAsignacion; // In
        
    }
        public void mostrarAsignacion() {
        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-20s %-10s\n", "Conductor", "Vehículo", "Matrícula", "Estado");
        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-20s %-10s\n", 
                conductor.getNombre(), 
                vehiculo.getMarca() + " " + vehiculo.getModelo(), 
                vehiculo.getMatricula(), 
                estadoAsignacion); // Muestra el estado de la asignación
        System.out.println("--------------------------------------------------------------");
    }
         public String getEstadoAsignacion() {
        return estadoAsignacion;
    }

    // Setter para el estado de la asignación
    public void setEstadoAsignacion(String estadoAsignacion) {
        this.estadoAsignacion = estadoAsignacion;
    }
}
