/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

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
    //Para acceder a estas variables desde otro packete es necesario poner public
    //Ojo => no es buena practica
    public String nombre;
    public String apellido;
    
    //Metodos de la clase.
    public void desplegarInformacion(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: "+ apellido);
    }
   
}
