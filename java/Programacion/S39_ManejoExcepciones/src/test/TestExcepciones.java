package test;

import static aritmetica.Aritmetica.division;
import excepciones.OperacionExcepcion;

public class TestExcepciones {
    public static void main(String[] args) {
        int resultado = 0;
        try {
            resultado = division(10,0);
            System.out.println("resultado = " + resultado);
        } catch (OperacionExcepcion e) {
            //Catch en orden gerarquico
            System.out.println("Ocurrio un error de tipo OperacionExcepcion");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            //Ejecutar pila de excepciones
            System.out.println("Ocurrió un error de tipo Exception: ");
            //e.printStackTrace(System.out);
            System.out.println(e.getMessage());
        } finally {
            //Siemper se ejecuta
            System.out.println("Se reviós la division entre cero");
        }
        System.out.println("resultado = " + resultado);
        
        
    }
}
