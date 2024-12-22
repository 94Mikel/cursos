/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pasoporvalor;

import clases.Persona;

/**
 *
 * @author mikel
 */
public class PasoPorReferencia {
    
    public static void main(String[] args) {
        
        //El paso por referencia se realiza con objetos, no con tipos primitivos(int, string...)
        Persona persona1 = new Persona(); 
        persona1.nombre = "Juan";
        System.out.println("persona1.nombre = " + persona1.nombre);
        persona1 = cambiarValor(persona1);
        System.out.println("persona1.nombre cambiado= " + persona1.nombre);
    }
    
    public static Persona cambiarValor(Persona persona){
        /*
        Estamos apuntando a la misma referencia de objeto, 
        lo cual el cambio de valor de variables afecta en los demas metodos...
        */
        
        /*
         Si el metodo tiene void,
         el compilador de java pone un 
         return vacio al final de la linea
        */
        
        // Podemos utilizar varios returns dentro del metodo.
        
        if(persona == null){
            return null;
        }
        
        persona.nombre = "Karla";
        return persona;//Retornamos la refirecia del objeto
        
        
    }
    
    
}
