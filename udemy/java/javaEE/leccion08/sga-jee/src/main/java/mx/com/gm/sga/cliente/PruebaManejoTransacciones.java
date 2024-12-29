package mx.com.gm.sga.cliente;

import javax.naming.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceRemote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//CON JDK 11

public class PruebaManejoTransacciones {
   
    private static Logger log = LoggerFactory.getLogger(PruebaManejoTransacciones.class);
    
    public static void main(String[] args) {
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee-web/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
            //java:global/sga-jee-web/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaService
            
            log.info("Iniciando prueba Manejo transaccional PersonaService");
            
            //Buscar un objeto persona
            Persona persona1 = personaService.encontrarPersonaPorId(new Persona(10));
            
            log.info("Persona recuperada:" + persona1);
            //Cambiar el apellido persona
            //persona1.setApellido("cambio con error....................................................................................");
            persona1.setApellido("Perez");
            
            personaService.modificarPersona(persona1);
            log.info("Objeto modificado:" + persona1);
            log.info("Fin prueba EJB transaccional");
            
        } catch (NamingException ex) {
            log.error("aaaaa");
            ex.printStackTrace(System.out);
        }
        
    }
    
}
