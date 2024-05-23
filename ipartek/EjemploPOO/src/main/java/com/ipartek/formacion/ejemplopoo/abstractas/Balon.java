package com.ipartek.formacion.ejemplopoo.abstractas;

public class Balon extends ObjetoDeporte implements Rodable {

    @Override
    public void rodar() {
        System.out.println("Bal�n rodando");
    }

}
