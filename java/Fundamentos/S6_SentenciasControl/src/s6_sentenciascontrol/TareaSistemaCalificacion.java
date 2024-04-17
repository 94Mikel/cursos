/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s6_sentenciascontrol;

import java.util.Scanner;

/**
 *
 * @author mikel
 */
public class TareaSistemaCalificacion {
    
    public static void main(String[] args) {
        var console = new Scanner(System.in);
        var calificacion = 0;
        var resultado = "Valor desconocida";
        System.out.println("Tarea 6 => calificacion");
        System.out.println("Introduzca un número: ");
        calificacion = Integer.parseInt(console.nextLine());
        
        if(calificacion >= 9 && calificacion <= 10){
            resultado = "A";
        } else if(calificacion >= 8 && calificacion < 9){
            resultado = "B";
        } else if(calificacion >= 7 && calificacion < 8){
            resultado = "C";
        } else if(calificacion >= 6 && calificacion < 7){
            resultado = "D";
        } else if(calificacion >= 0 && calificacion < 6){
            resultado = "F";
        }
        System.out.println("resultado = " + resultado);
    }
}
