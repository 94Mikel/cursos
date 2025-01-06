package mx.com.gm.domain;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="persona") //la tabla en la base de datos esta en minuscula
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    //Column para mapear el idPersona con el id_persona de la base de datos
    @Column(name = "id_persona")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersona;

    //Si el nombre de la columna es igual a la de bd no es necesario poner la anotación @Column
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    public Persona() {
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("idPersona=").append(idPersona);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellido=").append(apellido);
        sb.append(", email=").append(email);
        sb.append(", telefono=").append(telefono);
        sb.append('}');
        return sb.toString();
    }

}
