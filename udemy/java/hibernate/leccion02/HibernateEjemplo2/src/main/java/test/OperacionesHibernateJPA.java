package test;

import mx.com.gm.dao.PersonaDAO;
import mx.com.gm.domain.Persona;

public class OperacionesHibernateJPA {
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();
        personaDao.listar();
        
        //Creamos e inicialiamos una persona
        Persona persona = new Persona();
        persona.setNombre("Fatima");
        persona.setApellido("Perez");
        persona.setEmail("fperez@mail.com");
        persona.setTelefono("652542148");
        
        //Mandamos a llamar al metodo insertar para añadir la persona que hemos creado en la bd
        //personaDao.insertar(persona);
        
    }
}
