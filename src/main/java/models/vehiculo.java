/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Dell
 */
public class vehiculo {
    private String marca;
    private String modelo;
    private String matricula;
    
      public vehiculo(String marca, String modelo, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
    }
       public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "Vehículo [Marca=" + marca + ", Modelo=" + modelo + ", Matrícula=" + matricula + "]";
    }
}
