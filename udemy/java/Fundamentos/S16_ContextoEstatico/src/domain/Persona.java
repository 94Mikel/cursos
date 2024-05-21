package domain;

/**
 *
 * @author mikel
 */
public class Persona {

    private int idPersona;
    private String nombre;
    private static int contadorPersonas;

    public Persona(String nombre) {
        this.nombre = nombre;
        //incrementar contador por cada objeto nuevo.
        //Para acceder a variables static no se recomienda utilizar this.
        Persona.contadorPersonas++;//Nombre de la clase es opcional(se recomienda poner)
        //Asignar el nuevo valor a la variable idPersona
        this.idPersona = Persona.contadorPersonas;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static int getContadorPersonas() {
        return contadorPersonas;
    }

    public static void setContadorPersonas(int contadorPersonas) {
        Persona.contadorPersonas = contadorPersonas;
    }
    //Anotacion que indica que estamos sobrescribiedo el metodo toString.
    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + '}';
    }

}
