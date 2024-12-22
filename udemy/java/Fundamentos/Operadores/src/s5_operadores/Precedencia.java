/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s5_operadores;

/**
 *
 * @author mikel
 */
public class Precedencia {
    
    public static void main(String[] args) {
        
        /*
            La precedencia de operadores, es el orden en que 
            se van a evaluar los operadores en una expresión
        */
        
        /*
            1 - Operadores unarios
            2 - Parentesis
            3 - Operadores aritmeticos
            4 - Concatenacion de cadenas
            ...
        */
        
        var x = 5;
        var y = 10;
        var z = ++x + y--;
        //y => primero se utiliza para la suma y luego se resta
        
        /*
            En la suma:
            ++x => pre incremento 6
            y-- => post decremento 10
        */
        
        System.out.println("x => "+x);
        System.out.println("y => "+y);
        System.out.println("resultado => "+z);
        
        var resultado = 4 + 5 * 6 / 3;// 4 + ((5*6)/3) => 14
        System.out.println("resultado => "+resultado);
        
        resultado = (4+5) * 6 / 3;//(9*5) / 3 => 18
        System.out.println("resultado => "+resultado);
        
    }
    
}
