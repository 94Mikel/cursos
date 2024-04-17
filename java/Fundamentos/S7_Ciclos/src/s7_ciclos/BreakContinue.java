/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s7_ciclos;

/**
 *
 * @author mikel
 */
public class BreakContinue {
    
    public static void main(String[] args) {
        
        for (int contador = 0; contador < 3; contador++) {
            if (contador % 2 != 0) {
                continue;//Ir a la siguiente iteracion.
            }
            System.out.println("contador = " + contador);
        }
        
        /*
        for (int contador = 0; contador < 3; contador++) {
            if (contador % 2 == 0) {
                System.out.println("contador = " + contador);
                break;//Salimos del bucle o ciclo
            }
        }
        */
        
        
    }
    
}
