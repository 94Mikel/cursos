/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s5_operadores;

/**
 *
 * @author mikel
 */
public class Asignacion {
    
    public static void main(String args[]){
        int a = 3, b=2;
        int c = a + 5 - b; // 3 + 5 - 2 -> 6
        System.out.println("c = "+c);
        
        a += 1; // a = a + 1
        System.out.println("a = " + a);
        
        a += 3; // a = a + 3
        System.out.println("a = " + a);
        
        a -= 2;// a = a - 2
        System.out.println("a = " + a);
        
        a *= 2;// a = a * 2
        System.out.println("a = " + a);
        
        a /= 5; 
        System.out.println("a = " + a);
        
        a %= 2;
        System.out.println("a = " + a);
        
        
    }
    
}
