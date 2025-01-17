package mx.com.gm.data;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import java.util.List;
import mx.com.gm.domain.Persona;

@Stateless
public class PersonaDaoImpl implements PersonaDao{

    @PersistenceContext(unitName = "PersonaPU")
    EntityManager em;//Para comunicarnos con bd
    
    @Override
    public List<Persona> encontrarTodasPersonas() {
        return em.createNamedQuery("Persona.encontrarTodasPersonas").getResultList();
    }

    @Override
    public Persona encontrarPersona(Persona persona) {
        //Encontrar un objeto de tipo persona con el id "persona.getIdPersona()"
        return em.find(Persona.class, persona.getIdPersona());
    }

    @Override
    public void insertarPersona(Persona persona) {
        em.persist(persona);
        //Para obtener el objeto con la llave primaria
        em.flush();
    }

    @Override
    public void actualizarPersona(Persona persona) {
        em.merge(persona);
    }

    @Override
    public void eliminarPersona(Persona persona) {
        //Merge para actualizar el estado en la base de datos
        //remove para eliminar el objeto en la base de datos
        em.remove(em.merge(persona));
    }
    
}
