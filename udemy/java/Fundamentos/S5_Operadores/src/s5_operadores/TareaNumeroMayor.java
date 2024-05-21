/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s5_operadores;

import java.util.Scanner;

/**
 *
 * @author mikel
 */
public class TareaNumeroMayor {
    public static void main(String[] args) {
        var numero1 = 0;
        var numero2 = 0;
        var console = new Scanner(System.in);
    
        System.out.println("Tarea5 => El mayor de dos números");
        System.out.println("Proporciona el numero1:");
        numero1 = Integer.parseInt(console.nextLine());
                
        System.out.println("Proporciona el numero2:");
        numero2 = Integer.parseInt(console.nextLine());
        
        var resultado = numero1 > numero2 ? numero1 : numero2;
        System.out.println("El numero mayor es: "+resultado);
        
    }
}
