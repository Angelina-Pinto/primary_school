/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.primary_school;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import javax.swing.UIManager;
import screen.home;
import dao.query;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import static javax.swing.UIManager.put;
import models.Curso;
import models.Estudiante;
import models.Matricula;
import models.asignacion;
import models.conductor;
import models.vehiculo;
import screen.curso;
/**
 *
 * @author Dell
 */
public class main {

    public static void main(String[] args) {
         //FlatLightLaf.setup();
        // FlatMaterialLighterIJTheme.setup();

//    
        UIManager.put( "Button.arc", 999 );
            home hom = new home();
            hom.setVisible(true);
        //System.out.println("Hello World!");
        
       // query myquery = new query();
       
//        Estudiante estudiante1 = new Estudiante("Ana Gómez", 21, "2020101234");
//        Estudiante estudiante2 = new Estudiante("Luis Martínez", 22, "2020105678");
//        Estudiante estudiante3 = new Estudiante("Carla Rodríguez", 20, "2020117890");

        // quitar comentarios para sistema de escuela 
         // Crear cursos
//        Curso curso1 = new Curso("CS101", "Programación I", 4);
//        Curso curso2 = new Curso("MAT201", "Cálculo II", 3);
//
//        
//          // Nuevas matrículas
//        Matricula matricula1 = new Matricula(estudiante1, curso1, "2024-09-15");
//        Matricula matricula2 = new Matricula(estudiante2, curso2, "2024-10-01");
//        Matricula matricula3 = new Matricula(estudiante3, curso1, "2024-08-20");
//
//        
//          // Asociar matrículas a los estudiantes
//        estudiante1.agregarCurso(matricula1);
//        estudiante2.agregarCurso(matricula2);
//        estudiante3.agregarCurso(matricula3);
//    // Mostrar la tabla de estudiantes matriculados
//        List<Matricula> todasLasMatriculas = new ArrayList<>();
//        todasLasMatriculas.add(matricula1);
//        todasLasMatriculas.add(matricula2);
//        todasLasMatriculas.add(matricula3);

//        mostrarEstudiantesMatriculados(todasLasMatriculas);

        // Cancelar una matrícula y mostrar nuevamente
//        matricula2.cancelarMatricula();
//        System.out.println("\nDespués de cancelar la matrícula de Luis Martínez:");
//        mostrarEstudiantesMatriculados(todasLasMatriculas);
//      
////        
//         public static void mostrarEstudiantesMatriculados(List<Matricula> matriculas) {
//        System.out.println("Tabla de estudiantes matriculados (Estado Activo):");
//        System.out.println("--------------------------------------------------");
//        System.out.printf("%-15s %-20s %-10s %-15s\n", "Nombre", "Curso", "Fecha", "Estado");
//        System.out.println("--------------------------------------------------");
//
////       
//        System.out.println("--------------------------------------------------");
//     System.out.println("Tabla de estudiantes matriculados (Estado Activo):");
//        System.out.println("--------------------------------------------------");
//        System.out.printf("%-15s %-20s %-10s %-15s\n", "Nombre", "Curso", "Fecha", "Estado");
//        System.out.println("--------------------------------------------------");
//
//       
         // Crear conductores
//        conductor conductor1 = new conductor("Juan Pérez", "AB12345");
//        conductor conductor2 = new conductor("Ana Gómez", "BC67890");
//        conductor conductor3 = new conductor("Luis Martínez", "CD23456");

        // Crear vehículos
//        vehiculo vehiculo1 = new vehiculo("Toyota", "Corolla", "XYZ789");
//        vehiculo vehiculo2 = new vehiculo("Ford", "Fiesta", "ABC123");
//        vehiculo vehiculo3 = new vehiculo("Honda", "Civic", "LMN456");
//
//        // Crear una lista de asignaciones
//        List<asignacion> asignaciones = new ArrayList<>();
//
//        // Crear asignaciones
//        asignaciones.add(new asignacion(conductor1, vehiculo1, "Activa"));
//        asignaciones.add(new asignacion(conductor2, vehiculo2, "Inactiva"));
//        asignaciones.add(new asignacion(conductor3, vehiculo3, "Activa"));
//
//        // Imprimir las asignaciones
//        System.out.println("Tabla de asignaciones de vehículos a conductores:");
//        for (asignacion asignacion : asignaciones) {
//            asignacion.mostrarAsignacion();
//        }
//    



    }
      public static void mostrarEstudiantesMatriculados(List<Matricula> matriculas) {
        System.out.println("Tabla de estudiantes matriculados (Estado Activo):");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-15s %-20s %-10s %-15s\n", "Nombre", "Curso", "Fecha", "Estado");
        System.out.println("--------------------------------------------------");

        for (Matricula matricula : matriculas) {
            if (matricula.getEstado().equals("Activa")) {
                System.out.printf("%-15s %-20s %-10s %-15s\n", 
                        matricula.getEstudiante().getNombre(), 
                        matricula.getCurso().getNombreCurso(), 
                        matricula.getFechaMatricula(), 
                        matricula.getEstado());
            }
        }

        System.out.println("--------------------------------------------------");
    }
}
