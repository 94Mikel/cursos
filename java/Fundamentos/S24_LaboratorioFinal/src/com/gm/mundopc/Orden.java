package com.gm.mundopc;

public class Orden {
    private final int idOrden;
    private Computadora computadoras[];
    private static int contadorOrdenes;
    private int contadorComputadoras;
    private static final int MAX_COMPUTADORAS = 10;

    public Orden() {
        this.idOrden = ++Orden.contadorOrdenes;
        this.computadoras = new Computadora[Orden.MAX_COMPUTADORAS];
    }

    public void agregarComputadora(Computadora computadora) {
        if(this.contadorComputadoras < MAX_COMPUTADORAS){
         this.computadoras[this.contadorComputadoras++] = computadora;   
        }else{
            System.out.println("Máximo de computadora excedido");
        }
    }
    
    public void mostrarOrdenes(){
        System.out.println("Mostrar ordenes:");
        System.out.println("this.idOrdenes = " + this.idOrden);
        System.out.println("Computadoras de la orden: "+this.idOrden);
        for (int i = 0; i < this.contadorComputadoras; i++) {
            System.out.println(this.computadoras[i]);
        }
    }
    
}
