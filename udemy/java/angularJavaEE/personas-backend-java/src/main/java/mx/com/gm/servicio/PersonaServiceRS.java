package mx.com.gm.servicio;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.core.Response.Status;
import java.util.List;
import mx.com.gm.data.PersonaDao;
import mx.com.gm.domain.Persona;

/*
    No vamos a crear la capa de servicio ya que la implementación de este servicio es muy simple
    Portanto no vamos a agregar la capa de negocio. Directamente en esta clase vamos a utilizar la clase PersonaDao
    Para no hacer mas grande nuestra aplicacion.
 */
@Stateless
@Path("/personas")//EJB de tipo jax-rs. 
public class PersonaServiceRS {

    @Inject//Inyectamos este objeto. Para instanciar el objeto
    private PersonaDao personaDao;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)//Regresara información de tipo json para front (angular)
    public List<Persona> listarPersonas() {
        List<Persona> personas = personaDao.encontrarTodasPersonas();
        System.out.println("personas encontradas = " + personas);
        return personas;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")//hace referencia al path: /persona/{id}, ej. /personas/1
    public Persona encontrarPersona(@PathParam("id") int id) {//PathParam => para indicar el nombre del parametro que vamos a recibir
        Persona persona = personaDao.encontrarPersona(new Persona(id));
        System.out.println("persona encontrada por id = " + persona);
        return persona;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)//Obtendremos objeto de tipo json
    @Produces(value = MediaType.APPLICATION_JSON)//Devolvemos objeto de tipo json
    public Persona agregarPersona(Persona persona) {
        personaDao.insertarPersona(persona);
        System.out.println("Persona agregada: " + persona);
        return persona;//porque el cliente lo utilizara con su idPersona
    }
    
    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)//Obtendremos objeto de tipo json
    @Produces(value = MediaType.APPLICATION_JSON)//Devolvemos objeto de tipo json
    @Path("{id}")//hace referencia al path: /persona/{id}, ej. /personas/1
    public Response modificarPersona(@PathParam("id") int id, Persona personaModificada){
        Persona persona = personaDao.encontrarPersona(new Persona(id));
        if(persona != null){
            personaDao.actualizarPersona(personaModificada);
            System.out.println("personaModificada = " + personaModificada);
            return Response.ok().entity(personaModificada).build();
        }else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)//Devolvemos objeto de tipo json
    @Path("{id}")//hace referencia al path: /persona/{id}, ej. /personas/1
    public Response eliminarPersona(@PathParam("id") int id) {//PathParam => para indicar el nombre del parametro que vamos a recibir
        personaDao.eliminarPersona(new Persona(id));
        System.out.println("persona eliminada con el id = " + id);
        return Response.ok().build();
    }

}
