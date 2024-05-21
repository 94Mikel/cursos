package test;

import genericos.ClaseGenerica;

public class TestColeccionesGenericas {
    public static void main(String[] args) {
        //Hay que usar la clase envolvente
        ClaseGenerica<Integer> objetoInt = new ClaseGenerica(15);
        objetoInt.obtenerTipo();
        
        ClaseGenerica<String> objectString = new ClaseGenerica("Juan");
        objectString.obtenerTipo();
        
    }
}
