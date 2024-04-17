package test;

public class TestArreglos {
    public static void main(String[] args) {
        //new int[3] => crear objeto arreglo int de longitud 3
        int edades[] = new int[3];
        System.out.println("edades = " + edades);
        
        //Modificar los elementos del arreglo:
        edades[0] = 10;
        System.out.println("edades[0] = " + edades[0]);
        
        edades[1] = 4;
        edades[2] = 8;
        
        System.out.println("edades[1] = " + edades[1]);
        System.out.println("edades[2] = " + edades[2]);
        
        //edades[3] = 6; no se puede porque la máxima longitud es 3.
        
        for (int i = 0; i < edades.length; i++) {
            System.out.println("edades elemento " + i + ": " + edades[i]);
        }
        
    }
}
