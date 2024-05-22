package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.*;

/**
 *
 * @author mikel
 */
public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();
        
        /*
        //Insertando un nuevo objeto de tipo Persona
        Persona personaNueva = new Persona("Juan", "Martinez", "juan@gmail.com", "987542174");
        personaDao.insertar(personaNueva);
        */
        
        /*
        //Modificar persona
        Persona personaModificar = new Persona(4, "Juan Carlos", "Esparza", "jcesparza@gmail.com", "5455657876");
        personaDao.actualizar(personaModificar);
        */
        
        /*
        //Eliminar persona
        Persona personaEliminar = new Persona(4);
        personaDao.eliminar(personaEliminar);
        */
        
        List<Persona> personas = personaDao.seleccionar();
        
        for (Persona persona : personas) {
            System.out.println("persona = " + persona);
        }
        
    }
    
}
