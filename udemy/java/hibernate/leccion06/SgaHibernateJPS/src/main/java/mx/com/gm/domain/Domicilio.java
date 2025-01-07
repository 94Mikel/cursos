package mx.com.gm.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Domicilio implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Para que la primaryKey la gestione la base de datos
    @Column(name = "id_domicilio")//Para que se mapee con el nombre real de la base de datos. En la bd tenemos "id_domicilio" en la tabla domicilio
    private Integer idDomicilio;
    
    private String calle;
    
    @Column(name = "no_calle")//en la base de datos es no_calle
    private String noCalle;
    
    private String pais;

    public Domicilio() {
    }

    public Domicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public Integer getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNoCalle() {
        return noCalle;
    }

    public void setNoCalle(String noCalle) {
        this.noCalle = noCalle;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Domicilio{" + "idDomicilio=" + idDomicilio + ", calle=" + calle + ", noCalle=" + noCalle + ", pais=" + pais + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idDomicilio);
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
        final Domicilio other = (Domicilio) obj;
        return Objects.equals(this.idDomicilio, other.idDomicilio);
    }
    
}
