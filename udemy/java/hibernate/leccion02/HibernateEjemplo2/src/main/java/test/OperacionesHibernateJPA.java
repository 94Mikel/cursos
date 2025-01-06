package test;

import mx.com.gm.dao.PersonaDAO;
import mx.com.gm.domain.Persona;

public class OperacionesHibernateJPA {
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();
        personaDao.listar();
        
        //Creamos e inicialiamos una persona
        /*
        Persona persona = new Persona();
        persona.setNombre("Fatima");
        persona.setApellido("Perez");
        persona.setEmail("fperez@mail.com");
        persona.setTelefono("652542148");
        */
        
        //Mandamos a llamar al metodo insertar para añadir la persona que hemos creado en la bd
        //personaDao.insertar(persona);
        
        //Modificamos la persona
        //primero recuperamos el objeto persona pasando el id
        /*
        Persona persona = new Persona();
        persona.setIdPersona(0);
        persona = personaDao.buscarPersonaPorId(persona);
        System.out.println("persona encontrada = " + persona);
        //realizamos los set de modificación
        persona.setApellido("Esparza");
        persona.setEmail("cesparza@mail.com");
        //modificamos la persona en la base de datos mediante la instacia personaDao
        personaDao.modificar(persona);
        //listamos todas las personas
        personaDao.listar();
        */
        
        //Eliminasmo la persona
        //Se podria eliminar el objeto sin tener que buscarlo. simplemente creando un objeto y añadiendo el id, ya que se hace un merge primero
        Persona persona = new Persona();
        //Buscamos la persona
        persona.setIdPersona(0);
        persona = personaDao.buscarPersonaPorId(persona);
        System.out.println("persona encontrada = " + persona);
        //eliminamos la persona en la bd
        personaDao.eliminar(persona);
        personaDao.listar();
        
        
    }
}
