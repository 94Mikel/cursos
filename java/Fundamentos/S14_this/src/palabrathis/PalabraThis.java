package palabrathis;

/**
 *
 * @author mikel
 */
public class PalabraThis {

    public static void main(String[] args) {
        
        Persona persona = new Persona("Juan", "Perez");
        System.out.println("persona = " + persona);
        System.out.println("persona.nombre = " + persona.nombre);
        System.out.println("persona.apellido = " + persona.apellido);
    }
  
}
/*
Solo es accesible desde el mismo package(palabrathis)
*/
class Persona {
    
    String nombre;//default o package
    String apellido;
    
    Persona(String nombre, String apellido){
        //super(); llamada al constructor de la calse Padre (object)
        //super se encarga de reservar el espacio de memoria.
        // super => En la primera linea del constructos.
        this.nombre = nombre;
        this.apellido = apellido;
        //Dentro de la clase persona imprime el objeto que esta utilizando en ese momento
        System.out.println("Objecto persona usando this = " + this);
        new Imprimir().imprimir(this);
    }
    
}

class Imprimir {
    
    public Imprimir(){
        super(); // el constructor de la clase object (padre) para reservar memoria
    }
    
    public void imprimir(Persona persona){
        System.out.println("persona desde imprimir = " + persona);
        System.out.println("impresion del objeto actual(this) = " + this);
    }
    
}
