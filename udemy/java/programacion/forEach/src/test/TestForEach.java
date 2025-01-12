package test;

import domain.Persona;

public class TestForEach {
    public static void main(String[] args) {
        //Arreglo tipo entero
        int edades[] = {5, 6 ,8, 9};
        for(int edad: edades){
            System.out.println("edad = " + edad);
        }
        
        //foreach con object
        Persona personas[] = {new Persona("pepe"), new Persona("Karla"), new Persona("Agustin")};
        for(Persona persona: personas){
            System.out.println("persona = " + persona);
        }
        
        
        
    }
}
