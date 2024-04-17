/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caja;

/**
 *
 * @author mikel
 */
public class prueba {
    
    public static void main(String[] args) {
        
        Caja caja1 = new Caja();
        caja1.ancho = 3;
        caja1.alto = 2;
        caja1.profundo = 6;
        System.out.println("c1 volumen = " + caja1.getVolumen());
        
        Caja caja2 = new Caja(3,2,6);
        System.out.println("caja2 volumen = " + caja2.getVolumen());
        
    }
    
}
