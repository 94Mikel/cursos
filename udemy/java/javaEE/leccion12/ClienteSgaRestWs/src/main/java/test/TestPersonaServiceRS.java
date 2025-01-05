package test;

import domain.Persona;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.*;
import java.util.List;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class TestPersonaServiceRS {

    //Variables que vamos a utilizar
    private static final String URL_BASE = "http://localhost:8080/sga-jee-web/webservice";
    private static Client cliente;
    private static WebTarget webTarget;
    private static Persona persona;
    private static List<Persona> personas;
    private static Invocation.Builder invocationBuilder;
    private static Response response;

    public static void main(String[] args) {
        //Pasamos la autenticación 
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().nonPreemptive().credentials("admin", "admin").build();
        
        //Configuración del cliente
        ClientConfig clientConfig = new ClientConfig();
        //Instaciamos nuestro cliente pasando la seguridad que requiere el EJB
        clientConfig.register(feature);//registramos la configuración
        
        //Declaramos la variable cliente, para registrar toda la configuración que hemos hecho paramos el clientConfig
        cliente = ClientBuilder.newClient(clientConfig);

        //Leer una persona (metodo get)
        webTarget = cliente.target(URL_BASE).path("/personas");
        //Proporcionamos un idPersona valido
        persona = webTarget.path("/9").request(MediaType.APPLICATION_XML).get(Persona.class);
        System.out.println("Persona recuperada: " + persona);

        //Leer todas las personas (metodo get con readEntity de tipo List<>)
        personas = webTarget.request(MediaType.APPLICATION_XML).get(Response.class).readEntity(new GenericType<List<Persona>>() {
        });
        System.out.println("\nPersonas recuperadas");
        imprimirPersonas(personas);

        //Agregar una persona (metodo post)
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre("Carlos");
        nuevaPersona.setApellido("Miranda");
        nuevaPersona.setEmail("cmirandauq@mail.com");
        nuevaPersona.setTelefono("685545742");

        /*
        Lo que vamos ha hacer con el nuevo objeto es llamar al metodo 
        para insertar este objeto de tipo persona.
        Peticion de tipo request a webTarget y asignar a la variable invocation builder
         */
        invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        response = invocationBuilder.post(Entity.entity(nuevaPersona, MediaType.APPLICATION_XML));
        System.out.println("");
        System.out.println(response.getStatus());
        //Recuperamos la persona recien agregada para despues modificarla y al final eliminarla
        Persona personaRecuperada = response.readEntity(Persona.class);
        System.out.println("Persona agregada: " + personaRecuperada);
        
        //Modificar la persona (metodo put)
        //persona recuperada anteriormente
        Persona personaModificar = personaRecuperada;
        personaModificar.setApellido("Ramirez");
        String pathId = "/" + personaModificar.getIdPersona();
        invocationBuilder = webTarget.path(pathId).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.put(Entity.entity(personaModificar, MediaType.APPLICATION_XML));
        
        System.out.println("");
        System.out.println("response: "+response.getStatus());
        System.out.println("Persona modificada: "+response.readEntity(Persona.class));
        
        //Eliminar una persona
        //persona recuperada anteriormente
        Persona personaEliminar = personaRecuperada;
        String pathEliminarID = "/"+personaEliminar.getIdPersona();
        invocationBuilder = webTarget.path(pathEliminarID).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.delete();
        
        System.out.println("");
        System.out.println("response: "+response.getStatus());
        System.out.println("Persona eliminada: "+personaEliminar);
        

    }

    private static void imprimirPersonas(List<Persona> personas) {
        for (Persona p : personas) {
            System.out.println("Personas: " + p);
        }
    }

}
