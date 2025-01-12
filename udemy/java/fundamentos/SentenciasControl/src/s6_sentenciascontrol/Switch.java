/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s6_sentenciascontrol;

/**
 *
 * @author mikel
 */
public class Switch {

    public static void main(String[] args) {
        /*
        var numero = 2;
        var numeroTexto = "Valor desconocido";

        switch (numero) {
            case 1:
                numeroTexto = "Numero uno";
                break;
            case 2:
                numeroTexto = "Numero dos";
                break;
            case 3:
                numeroTexto = "Numero tres";
                break;
            case 4:
                numeroTexto = "Numero cuatro";
                break;
            default:
                numeroTexto = "Numero desconocido";
        }

        System.out.println("numeroTexto = " + numeroTexto);

        */
        
        var mes = 1;
        var estacion = "Estacion desconocida";
        
        switch (mes) {
            case 1: case 2: case 12:
                estacion = "Invierno";
                break;
            case 3: case 4: case 5:
                estacion = "Primavera";
                break;
            case 6: case 7: case 8:
                estacion = "Verano";
                break;
            case 9: case 10: case 11:
                estacion = "otono";
                break;
        }
        
        System.out.println("estacion = "+estacion);

    }

}
