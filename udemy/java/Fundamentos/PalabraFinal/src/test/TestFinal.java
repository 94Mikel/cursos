package test;

import domain.Persona;

public class TestFinal {
    public static void main(String[] args) {
        //En variables => una vez creado no podemos modificarlos
        final int miVariable = 10;
        System.out.println("miVariable = " + miVariable);
        
        //Persona.MI_CONSTANTE = 5;
        System.out.println("Persona.MI_CONSTANTE  = " + Persona.MI_CONSTANTE );
        
        /*
            Si a esta variable se quire asignar una referecia de un nuevo objeto
            no se podría.
        */
        
        final Persona persona1 = new Persona();
        //persona1 = new Persona();
        //No podemos asignar la referencia a al variable persona1 poque se marco como final.
        //Pero modemos modificar el valor de atributos mediante getters && setters
        persona1.setNombre("Juan");
        System.out.println("persona1.getNombre() = " + persona1.getNombre());
        persona1.setNombre("Carlos");
        System.out.println("persona1.getNombre() = " + persona1.getNombre());
    }
}
