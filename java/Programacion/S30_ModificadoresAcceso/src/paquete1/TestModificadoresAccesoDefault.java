package paquete1;

public class TestModificadoresAccesoDefault {
    public static void main(String[] args) {
        //Default
        Clase3 clase3 = new Clase3();
        clase3.atributoDefault = "Cambio desde la prueba";
        System.out.println("clase3 atributo default = " + clase3.atributoDefault);
        clase3.metodoDefault();
        
    }
}
