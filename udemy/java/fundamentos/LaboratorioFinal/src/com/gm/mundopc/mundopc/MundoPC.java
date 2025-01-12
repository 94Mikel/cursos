package com.gm.mundopc.mundopc;

import com.gm.mundopc.*;

public class MundoPC {
    public static void main(String[] args) {
        
        //Computadora 1
        Monitor monitorS = new Monitor("samsung", 27);
        Teclado tecladoS = new Teclado("usb", "magic eagle");
        Raton ratonS = new Raton("usb", "magic eagle mouse");
        Computadora computadoraS = new Computadora("sony", monitorS, tecladoS, ratonS);
        
        //Computadora 2
        Monitor monitorGamer = new Monitor("Gamer", 32);
        Teclado tecladoGamer = new Teclado("bluetooth", "Gamer");
        Raton ratonGamer = new Raton("bluetooth", "gamer");
        Computadora computadoraGamer = new Computadora("computadora gamer", monitorGamer, tecladoGamer, ratonGamer);
        
        Orden orden = new Orden();
        orden.agregarComputadora(computadoraS);
        orden.agregarComputadora(computadoraGamer);
        orden.mostrarOrdenes();
    }
}
