package mx.com.gm.dao;

import jakarta.persistence.*;
import java.util.List;
import mx.com.gm.domain.Persona;

public class PersonaDAO {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    /*
        Creamos el constructor de la clase.
        En esta clase es donde vamos a crear la instacia de nuestra fábrica para 
        podernos conectar con la unidad de persistencia de Hibernate.
    */
    
    public PersonaDAO() {
        //utilizamos la unidad de persistencia para asignarlo a nuestra variable entityManagerFactory
        emf = Persistence.createEntityManagerFactory("HibernatePU");
        //Instanciasmos nuestra fabrica
        em = emf.createEntityManager();
    }
    
    /*
    Utilizamos tambien el API de JPA. Nos estamos apoyando de todos los objetos que utiliza el API DE JPA(java persistence API)
    Lo que estamos haciendo es conectarnos con la api de Hibernate.
    hql => hibernate query language
    */
    
    public void listar() {
        String hql = "SELECT p FROM Persona p";
        Query query = em.createQuery(hql);//recuperamos objetos completos de tipo persona
        List<Persona> personas = query.getResultList();//regresa los objetos de tipo persona que estamos recuperando
        for (Persona persona : personas) {
            System.out.println("persona = " + persona);
        }
    }
    
}
