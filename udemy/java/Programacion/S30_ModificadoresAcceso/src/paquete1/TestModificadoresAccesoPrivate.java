package paquete1;

public class TestModificadoresAccesoPrivate {
    public static void main(String[] args) {
        //Private
        Clase4 clase4 = new Clase4("Publico");//Tenemos que pasar un argumento para que llame al constructor publico
        //no podemos acceder al atributo privado de la clase clase4.
        //clase4.atributoPrivado = "Cambio";
        
        //Para acceder o modificar el atributo privado debemos utilizar los metodos publicos get y set
        clase4.setAtributoPrivado("cambio valor atributo");
        System.out.println("clase4.getAtributoPrivado() = " + clase4.getAtributoPrivado());
    }
}
