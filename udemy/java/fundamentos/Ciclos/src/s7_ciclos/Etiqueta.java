/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s7_ciclos;

/**
 *
 * @author mikel
 */
public class Etiqueta {
    public static void main(String[] args) {
        
        /*
        Una etiqueta nos va a permitir indicar
        a las palabras continue o brake ir hacia
        un lugar en específico de nuestro programa.
        */
        
        /*
        Warning => go to, 
        puede romper con la logica de nuestros programas
        NO ES COMVENIENTE UTILIZAR.
        */
        
        inicio:
        for (int contador = 0; contador < 3; contador++) {
            if (contador % 2 != 0) {
                continue inicio;//Ir a la linia de codigo de la etiquete.
            }
            System.out.println("contador = " + contador);
        }
    }
}
