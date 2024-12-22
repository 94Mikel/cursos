/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s5_operadores;

/**
 *
 * @author mikel
 */
public class IgualdadRelaciones {
    public static void main(String args[]){
        var a = 3;
        var b = 2;
        
        var c = (a == b);//false
        System.out.println("c = " + c);
        
        var d = (a != b);//true 
        System.out.println("d = " + d);
        
        
        var cadena = "hola";
        var cadena2 = "adios";
        
        //Compara la referencia de objetos que almacena esta variable
        var e = cadena == cadena2;
        System.out.println("e = "+e);
        
        //Compara el contenido de las candenas
        var f = cadena.equals(cadena2);
        System.out.println("f = "+f);
        
        
        
        
        
        
    }
}
