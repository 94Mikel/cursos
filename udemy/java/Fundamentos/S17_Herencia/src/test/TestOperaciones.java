package test;

import operaciones.Operaciones;

public class TestOperaciones {
    public static void main(String[] args) {
        var resultado = Operaciones.sumar(5, 3);
        System.out.println("resultado = " + resultado);
        
        var resultado2 = Operaciones.sumar(2.0,3);//al menos 1 tiene que ser double
        System.out.println("resultado = " + resultado2);
        
        //tipo long no soporta el int, pero double si
        //Se llama al metodo que sea compatible
        var resultado3 = Operaciones.sumar(3, 5L);
        System.out.println("resultado3 = " + resultado3);
    }
}
