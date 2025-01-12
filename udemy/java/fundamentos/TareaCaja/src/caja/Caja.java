/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caja;

/**
 *
 * @author mikel
 */
public class Caja {
    
    int ancho;
    int profundo;
    int alto;
    
    public Caja(){
        System.out.println("Constructor vacio");
    }
    
    public Caja(int ancho, int profundo, int alto){
        this.ancho = ancho;
        this.profundo = profundo;
        this.alto = alto;
    }
    
    public int getVolumen (){
        return this.ancho * this.profundo * this.alto;
    }
    
}
