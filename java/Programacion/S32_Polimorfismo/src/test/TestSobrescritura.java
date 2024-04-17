package test;

import domain.*;

public class TestSobrescritura {
    public static void main(String[] args) {
        Empleado empleado = new Empleado("Juan", 5000);
        //System.out.println("Empleado = "+empleado.obtenerDetalles());
        imprimir(empleado);
        
        //Puede almacenar referencias de la clase padre o de la clase hija.
        Gerente gerente/*empleado*/ = new Gerente("Contabilidad", "Karla", 10000);
        //System.out.println("gerente = " + gerente.obtenerDetalles());
        imprimir(gerente);
        
    }
    
    //Un tipo padre puede aputar objetos de tipo hijo. Se puede pasar gerente
    //podemos ejecutar con el mismo tipo diferentes metodos de diferentes tipo
    public static void imprimir(Empleado empleado){
        String detalles = empleado.obtenerDetalles();
        System.out.println("empleado = " + detalles);
    }
    
}
