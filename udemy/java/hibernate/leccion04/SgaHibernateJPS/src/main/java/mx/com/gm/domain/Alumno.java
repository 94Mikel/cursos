package mx.com.gm.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Para que la primaryKey la gestione la base de datos
    @Column(name = "id_alumno")
    private Integer idAlumno;

    private String nombre;

    private String apellido;

    //para indicar cual es la columna de union. En este caso id_domicilio
    //name hacer referencia a la tabla de alumno y referencedColumnName hace referencia a la tabla de domicilio
    @JoinColumn(name = "id_domicilio", referencedColumnName = "id_domicilio")
    @ManyToOne//Asociación mucho a uno
    private Domicilio domicilio;//Obtenemos objetos completos de domicilio

    @JoinColumn(name = "id_contacto", referencedColumnName = "id_contacto")
    @ManyToOne
    private Contacto contacto;
    
    //se mapera a traves el atributo alumno de la clase Alumno
    //Mappeo bidireccional ya que en esta tabla tenemos la lista de asignaciones y en la clase asignacion tenemos el alumno
    @OneToMany(mappedBy = "alumno")
    private List<Asignacion> asignaciones;
    
    public Alumno() {
    }

    public Alumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
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

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }
    
    //En los metodos toString no se recomienda añadir las listas relacionadas a la clase de entidad
    //Porque podria ser muy pesado imprimir toda la lista de asociada a cada alumno
    //No añadimos asociaciones
    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio=" + domicilio + ", contacto=" + contacto + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idAlumno);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        return Objects.equals(this.idAlumno, other.idAlumno);
    }

}
