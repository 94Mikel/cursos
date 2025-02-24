package com.ipartek.formacion.ejemplopoo.abstractas;

public class EjemploInterfaces {

    public static void main(String[] args) {
        Rodable[] rodables = new Rodable[2];

        rodables[0] = new Naranja();
        rodables[1] = new Balon();

        for (Rodable rodable : rodables) {
            if (rodable instanceof Comestible) {
                ((Comestible) rodable).comer();
            }

            rodable.rodar();
        }
    }
}
