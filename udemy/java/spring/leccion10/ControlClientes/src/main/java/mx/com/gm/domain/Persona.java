//    Las clases tienen que estar dentro del paquete mx.com.gm si no spring no los encuentra
package mx.com.gm.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import lombok.Data;

@Data//Gracias a lombok transaformamos esta clase en una clase java bean
@Entity
@Table(name = "persona")//Mappear con el nombre de la base de datos
public class Persona implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    
    @NotEmpty
    private String nombre;
    
    @NotEmpty
    private String apellido;
    
    @NotEmpty
    @Email
    private String email;
    
    private String telefono;
}