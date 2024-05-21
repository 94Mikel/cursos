/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s5_operadores;

/**
 *
 * @author mikel
 */
public class Unarios {
    
    public static void main(String args[]){
        var a = 3;
        var b = -a;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        
        //operador de negacion
        var c = true;
        var d = !c;
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        
        //operadores incremento 
        //1.preincremento (simbolo antes de la variable)
        var e = 3;
        var f = ++e;//primero se incrementa la variable y despues se usa su valor
        System.out.println("e = " + e);
        System.out.println("f = " + f);
        
        //2.postincremento (simbolo despues de la variable)
        var g = 5;
        var h = g++;
        System.out.println("g = " + g);//teniamos pendiente un incremento
        System.out.println("h = " + h);
       
        
        //decremento
        //1.predecremento
        var i = 2;
        var j = --i;
        System.out.println("i = " + i);//ya esta decrementado
        System.out.println("j = " + j);
        
        //2.postdecremento
        var k = 2;
        var l = k--;
        System.out.println("k = " + k);
        System.out.println("l = " + l);
        
    }
    
}
