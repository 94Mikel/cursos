
package test;

import domain.Persona;

public class TestMatrices {
    public static void main(String[] args) {
        //tres lineas y dos columnas en tabla
        int edades[][] = new int[3][2];//object de tipo enteros
        System.out.println("edades = " + edades);
        
        edades[0][0] = 5;
        edades[0][1] = 7;
        edades[1][0] = 8;
        edades[1][1] = 4;
        
        System.out.println("edades[0][0] = " + edades[0][0]);
        System.out.println("edades[0][1] = " + edades[0][1]);    
        
        //Ciclos anidados
        for (int ren = 0; ren < edades.length; ren++) {
            for (int col = 0; col < edades[ren].length; col++) {
                System.out.println("edades "+ren+"-"+col+" = " + edades[ren][col]);
            }
        }
        
        //Sintaxis simplificada
        String frutas[][] = {{"Naraja","Limon"},{"Fresa","Zarzamora"}};
        imprimir(frutas);
        
        Persona personas[][] = new Persona[2][3];
        personas[0][0] = new Persona("Juan");
        personas[0][1] = new Persona("Karla");
        imprimir(personas);
    }
    
    public static void imprimir(Object matriz[][]){
        for (int ren = 0; ren < matriz.length; ren++) {
            for (int col = 0; col < matriz[ren].length; col++) {
                System.out.println("matriz = " + ren + "-" + col + ": " + matriz[ren][col]);
            }
        }
    }
}
