/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s8_creacionclases;

/**
 *
 * @author mikel
 * Clases en mayuscula
 * Atributos se declaran al inicio
 * seguido de metodos
 * metodos public => para poder utilizar fuera de la clase
 * metodos private => para utilizar solo dentro de esta clase
 * void => no devuelve nada.
 * argumetos => variables que recibe el metodo
 */
public class Persona {
    
    //Atributos de la clase
    String nombre;
    String apellido;
    
    //Metodos de la clase.
    public void desplegarInformacion(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: "+ apellido);
    }
   
}
