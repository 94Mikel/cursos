package test;

import paquete1.*;
import paquete2.ClaseHija;

public class testModificadoresAcceso {
    public static void main(String[] args) {
        //Public
        Clase1 clase1 = new Clase1();
        System.out.println("clase1 = " + clase1.atributoPublico);
        clase1.metodoPublico();
        
        //Protected
        Clase2 clase2 = new Clase2("Publico");
        //No podemos acceder a atributos y metodos protected de otro paquete no heredado.
        /*
        System.out.println("clase2 = " + clase2.atributoProtected);
        clase2.metodoProtected();
        */
        ClaseHija claseHija = new ClaseHija();
        System.out.println("claseHija = " + claseHija);
        
        //Default
        
        
        
    }
}
