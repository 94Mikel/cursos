/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s5_operadores;

/**
 *
 * @author mikel
 */
public class Relacionales {

    public static void main(String args[]) {

        var a = 3;
        var b = 2;
        var g = a > b;
        var h = a >= b;

        System.out.println("g = " + g);
        System.out.println("h = " + h);

        //Par o impar
        if (a % 2 == 0) {
            System.out.println("Es numero par => " + a);
        } else {
            System.out.println("Es numero impar => " + a);
        }
        
        //Relacion entra variables numéricos
        var edad = 10;
        var adulto = 18;
        
        if(edad >= adulto){
            System.out.println("Es un adulto");
        }else{
            System.out.println("Es menor de edad");
        }
        
    }

}
