package test;

import domain.Persona;

public class PersonaPrueba {
    
    private int contador;

    public static void main(String[] args) {
        Persona persona1 = new Persona("Juan");
        //idPersona se va incrementando porque es de tipo estatico
        //System.out.println("persona1 = " + persona1);

        Persona persona2 = new Persona("Karla");
        //System.out.println("persona2 = " + persona2);

        /*
        Si el contador persona no es estatico 
        se reiniciaria el valor por cada objeto que se crea 
        y siempre seria 1.
         */
        
        //No podemos mandar metodos no estatico dentro de un metodo estatico
        imprimir(persona1);
        imprimir(persona2);
        
    }

    
    public static void imprimir(Persona persona) {
        System.out.println("persona = " + persona);
    }
    
    //Metodo dinamico => puede acceder a metodos static.
    public int getContador(){
        imprimir(new Persona("Carlos"));
        return this.contador;
    }
}
