//    Las clases tienen que estar dentro del paquete mx.com.gm si no spring no los encuentra
package mx.com.gm.domain;

import lombok.Data;

@Data//Gracias a lombok transaformamos esta clase en una clase java bean
public class Persona {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
}
