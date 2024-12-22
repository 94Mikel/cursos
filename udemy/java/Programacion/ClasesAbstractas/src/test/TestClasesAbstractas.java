package test;

import doman.*;

public class TestClasesAbstractas {
    public static void main(String[] args) {
        // No se puede instanciar una clase abstracta.
        //FiguraGeometrica figura = new FiguraGeometrica();
        
        //polimorfismo upcasting.
        FiguraGeometrica figura = new Rectangulo("Rectangulo");
        figura.dibujar();
    }
}
