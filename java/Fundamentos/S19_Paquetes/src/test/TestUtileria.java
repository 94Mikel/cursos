package test;

//Imports de las clases
//import mx.com.globalmentoring.* <= Para importar todas las clases
import mx.com.globalmentoring.Utileria;
//import static mx.com.globalmentoring.Utileria.imprimir;//import static

//No por importar carga la memoria
//Se carga en memoria cuan utilicemos las clases

public class TestUtileria {
    public static void main(String[] args) {
        Utileria.imprimir("Saludos");
        
        //import static:
        //imprimir("saludos");
        
        //Nombre completamente calificado.(no es recomendable)
        //mx.com.globalmentoring.Utileria.imprimir("adios");
    }
}
