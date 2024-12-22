package test;

import domain.*;

public class TestSobrescritura {
    public static void main(String[] args) {
        Gerente gerente1 = new Gerente("Sistemas", "Juan", 5000);
        System.out.println("gerente1 = " + gerente1.obtenerDetalles());
        
    }
}
