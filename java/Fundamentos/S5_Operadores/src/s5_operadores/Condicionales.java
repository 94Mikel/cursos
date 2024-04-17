/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s5_operadores;

/**
 *
 * @author mikel
 */
public class Condicionales {

    public static void main(String[] args) {
        
        //Operadores condicionales AND Y OR
        
        var a = 10;
        var valorMinimo = 0;
        var valorMaximo = 10;
        
        //Operador de && => (AND)
        var resultado = a >= 0 && a <= 10;//true
        if(resultado){
            System.out.println("Dentro del rango");
        } else {
            System.out.println("Fuera de rango");
        }
        
        var vacaciones = false;
        var diaDescanso = false;
        
        if(vacaciones || diaDescanso){
            //Si alguna expresion es true
            System.out.println("El padre puede asisti al juedo de su hijo");
        } else {
            //Si ambas expresiones son false.
            System.out.println("El padre esta ocupado");
        }   
    }
}
