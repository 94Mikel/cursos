/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s5_operadores;

/**
 *
 * @author mikel
 */
public class Ternario {
    
    public static void main(String[] args) {
        
        //El operador ternario se utiliza para condiciones simples
        //Si es una condicion compleja se utiliza if
        
        var resultado = (3 > 2) ? "verdadero" : "falso";
        System.out.println("resultado => "+resultado);
        
        var numero = 8;
        resultado = (numero % 2 == 0) ? "par" : "impar";
        System.out.println("resultado => "+resultado);
        
        
    }
    
}
