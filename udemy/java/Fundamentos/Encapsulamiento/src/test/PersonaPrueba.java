package test;

import dominio.Persona;

/**
 *
 * @author mikel
 */
public class PersonaPrueba {
    
    public static void main(String[] args) {
        Persona persona1 = new Persona("Juan", 5000.00, false);
        //System.out.println("persona1.getNombre() = " + persona1.getNombre());
        
        /*
        println de java manda llamar de manera automatica el metodo toString.
        poniendo solo el nombre de clase ejecuta el toString()
        */
        System.out.println("persona1.toString() = " + persona1.toString());
        persona1.setNombre("Juan Carlos");
        /*
        System.out.println("persona1.getNombre() modificado = " + persona1.getNombre());
        System.out.println("persona1.getSueldo() = " + persona1.getSueldo());
        System.out.println("persona1.isEliminado() = " + persona1.isEliminado());
        */
        System.out.println("persona1.toString() = " + persona1.toString());
    }
    
}
