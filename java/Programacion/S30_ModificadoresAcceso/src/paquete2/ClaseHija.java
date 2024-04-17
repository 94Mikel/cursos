package paquete2;

import paquete1.Clase2;

public class ClaseHija extends Clase2 {
    
    public ClaseHija() {
        super();//Llamar constructor protegido de la clase padre.
        this.atributoProtected = "Modificacion atributo protected";
        System.out.println("this.atributoProtected = " + this.atributoProtected);
        this.metodoProtected();
    }
    
    
}
