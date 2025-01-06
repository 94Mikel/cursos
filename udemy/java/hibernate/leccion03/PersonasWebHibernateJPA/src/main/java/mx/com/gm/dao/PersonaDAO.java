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
    public List<Persona> listar() {
        String hql = "SELECT p FROM Persona p";
        Query query = em.createQuery(hql);//recuperamos objetos completos de tipo persona
        List<Persona> personas = query.getResultList();//regresa los objetos de tipo persona que estamos recuperando
        
//        for (Persona persona : personas) {
//            System.out.println("persona = " + persona);
//        }
        return personas;
    }

    /*
    Cuando vamos a insertar un objeto, necesitamos crear una nueva transacción
    Cuando trabajamos en una aplicación empresarial y desplegamos esta aplicación en un servidor como glasfish,
    entonces el servidor de glassfish se encarga de crear tanto esta transacción y también de cerrala.
    Sin embargo si no desplegamos esta aplicación en un servidor empresarial, nosotros somos los responsables 
    de abrir y cerrar esta transacción.
    En este caso como no vamos a desplegar esta aplicación en un servidor como glassfish, entonces somos los responsables
    de abrir y cerrar la transacción.
     */
    public void insertar(Persona persona) {
        try {
            //Prueba local. Tenemos que abrir y cerrar la transaccion nosotros mismos.
            em.getTransaction().begin();//abrimos la transacción
            em.persist(persona);//insertamos la persona
            em.getTransaction().commit();//realizamos el commit
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();//en caso de error para que quede todo como estaba
        } finally {
            //Comprobamos si el entity manager es diferente de null.
            if(em != null){
                //Si no es null mandamos a llamar al metodo close para cerrar la transacción.
                em.close();
            }
        }
    }
    
    //Para modificar una persona en la base de datos
    public void modificar(Persona persona) {
        try {
            //Prueba local. Tenemos que abrir y cerrar la transaccion nosotros mismos.
            em.getTransaction().begin();//abrimos la transacción
            em.merge(persona);//primero sincronicamos el estado del objeto persona con la base de datos.(actualizamos el objeto persona en la bd)
            em.getTransaction().commit();//realizamos el commit
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();//en caso de error para que quede todo como estaba
        }/* finally {
            //Comprobamos si el entity manager es diferente de null.
            if(em != null){
                //Si no es null mandamos a llamar al metodo close para cerrar la transacción.
                em.close();
            }
        }*/
    }
    
    public Persona buscarPersonaPorId(Persona p) {
        //select en la base de datos. obtenmos el objeto persona pasando el idPersona
        //No es necesario iniciar una trasacción ya que estamos recuperando una persona
        return em.find(Persona.class, p.getIdPersona());
    }
    
    public void eliminar(Persona persona) {
        try {
            //Prueba local. Tenemos que abrir y cerrar la transaccion nosotros mismos.
            em.getTransaction().begin();//abrimos la transacción
            //primero sincronicamos el estado del objeto persona con la base de datos y luego eliminamos la persona.
            em.remove(em.merge(persona));
            em.getTransaction().commit();//realizamos el commit
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();//en caso de error para que quede todo como estaba
        }/* finally {
            //Comprobamos si el entity manager es diferente de null.
            if(em != null){
                //Si no es null mandamos a llamar al metodo close para cerrar la transacción.
                em.close();
            }
        }*/
    }

}
