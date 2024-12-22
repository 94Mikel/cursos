package s5_operadores;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mikel
 * 
 * Sesion 5 Fundamentos Java: Operaciones en Java
 */
public class Aritmeticos {
    
    public static void main(String args[]) {
        
        int a=3, b=2;
        
        var resultado = a + b;
        
        System.out.println("resultado suma = " + resultado);
        
        resultado = a - b;
        System.out.println("resultado resta = " + resultado);
        
        resultado = a * b;
        System.out.println("resultado multiplicacion = " + resultado);
        
        var resultado2 = 3D / b;
        System.out.println("resultado de la division = " + resultado2);
        
        //Operador de modulo
        resultado = a % b;
        System.out.println("resultado modulo = "+resultado);
        
        if (a % 2 == 0) {
            System.out.println("Es numero par");
        } else {
            System.out.println("Es numero impar");
        }
                
        
    }
    
}
