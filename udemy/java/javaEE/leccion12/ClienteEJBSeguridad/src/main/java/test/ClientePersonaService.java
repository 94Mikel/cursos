package test;

import com.sun.enterprise.security.ee.authentication.ProgrammaticLogin;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceRemote;

public class ClientePersonaService {

    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente");
        
        //-------------- SEGURIDAD------------------------
        String authFile = "login.conf";//Esta a nivel raiz en files. Para poder superar la autenticación del lado del servidor
        System.setProperty("java.security.auth.login.config", authFile);
        ProgrammaticLogin programmaticLogin = new ProgrammaticLogin();
        /*
        Usuario y el password registrados en glassfish
        toCharArray para convertir el pass en caracteres porque asi lo solicita el API
        */
        programmaticLogin.login("admin", "admin".toCharArray());
        
        
        //---------------- JNDI---------------
        //Iniciar el contexto de jndi para ubicar el EJB que se ha publicado
        
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee-web/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
            
            List<Persona> personas = personaService.listarPersonas();
            
            for (Persona persona : personas) {
                System.out.println("persona: "+persona);
            }
            
            System.out.println("\nFin de la llamada al EJB desde el cliente");
            
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
        
        
        
    }
}
