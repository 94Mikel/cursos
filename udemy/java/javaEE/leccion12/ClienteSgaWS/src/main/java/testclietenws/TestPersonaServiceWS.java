/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testclietenws;

import clientews.servicio.Persona;
import clientews.servicio.PersonaServiceImplService;
import clientews.servicio.PersonaServiceWs;
import jakarta.xml.ws.BindingProvider;
import java.util.List;

/**
 *
 * @author mikel
 */
public class TestPersonaServiceWS {

    public static void main(String[] args) {
        PersonaServiceWs personaService = new PersonaServiceImplService().getPersonaServiceImplPort();
        
        //-----Seguridad---------
        //Validación con el servidor
        ((BindingProvider)personaService).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
        ((BindingProvider)personaService).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "admin");
        

        System.out.println("Ejecutamos servicio listar personas ws");
        List<Persona> personas = personaService.listarPersonas();
        for (Persona persona : personas) {
            System.out.println("persona idPersona: " + persona.getIdPersona() + ", nombre: " 
                    + persona.getNombre() + ", apellido: " + persona.getApellido() + ", email: " + persona.getEmail());
        }
        
        System.out.println("Fin servicio listar persona ws");

    }
}
