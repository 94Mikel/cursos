package test;

import domain.Empleado;

public class TestClaseObject {

    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("juan", 5000);
        Empleado empleado2 = new Empleado("Juan", 5000);

        //Pregutan si tienen la misma referencia en memoria
        if (empleado1 == empleado2) {
            System.out.println("Tienen la misma referencia en memoria");
        } 
        else {
            System.out.println("Tienen distinta referencia en memoria");
        }
        
        //Comparar el contenido de los objetos (con equals)
        if(empleado1.equals(empleado2)){
            System.out.println("Los objetos son iguales en contenido");
        } else {
            System.out.println("Los objetos son distintos en contenido");
        }
        
        //hascode => compara con un valor entero
        if(empleado1.hashCode() == empleado2.hashCode()){
            System.out.println("El valor hascode fue igual");
        }
        else{
            System.out.println("El valor hascode es distinto");
        }
        
    }
}
