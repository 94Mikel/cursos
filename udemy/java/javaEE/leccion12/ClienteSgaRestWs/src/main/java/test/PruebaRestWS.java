package test;

import domain.Persona;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class PruebaRestWS {
    public static void main(String[] args) {
        
        //Pasamos la autenticación 
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().nonPreemptive().credentials("admin", "admin").build();
        
        //Configuración del cliente
        ClientConfig clientConfig = new ClientConfig();
        //Instaciamos nuestro cliente pasando la seguridad que requiere el EJB
        clientConfig.register(feature);//registramos la configuración
        
        //Declaramos la variable cliente, para registrar toda la configuración que hemos hecho paramos el clientConfig
        Client cliente = ClientBuilder.newClient(clientConfig);
        
        //----- Llamada a nuestro cliente
        WebTarget webTarget = cliente.target("http://localhost:8080/sga-jee-web/webservice").path("/personas");
        //Proporcionamos un idPersona valido
        Persona persona = webTarget.path("/10").request(MediaType.APPLICATION_XML).get(Persona.class);
        System.out.println("persona recuperada = " + persona);
        
    }
}
