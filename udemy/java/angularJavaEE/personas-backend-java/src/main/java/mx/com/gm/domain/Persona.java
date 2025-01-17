package mx.com.gm.domain;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
    @NamedQuery(name = "Persona.encontrarTodasPersonas", query = "SELECT p FROM Persona p ORDER BY p.idPersona")
})
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Para indicar como vamos a generar esta llave primaria(en este caso autoincrementable en la bd)
    @Column(name = "id_persona")//para indicar el nombre que tenemos en la base de datos. Si el nombre es el mismo no hay necesidad de agregar esta anotacion.
    private int idPersona;

    private String nombre;

    public Persona() {
    }

    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(int idPersona, String nombre) {
        this.idPersona = idPersona;
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + '}';
    }

}
