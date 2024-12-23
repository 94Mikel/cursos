package test;

import jakarta.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClienteEntidadPersona {
    private static final Logger log = LoggerFactory.getLogger(ClienteEntidadPersona.class);
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Inicia la transaccion
        tx.begin();
        //No se debe especificar el ID de la base de datos
        Persona persona1 = new Persona("Maria","Gutierrez","mgutierrez@mail.com","88991199");
        log.info("Objeto a persistir: " + persona1);
        //System.out.println("Objeto a persistir:" + persona1);
        //Persistimos el objeto
        em.persist(persona1);
        //terminamos la transaccion
        tx.commit();
        log.info("Objeto persistido: " + persona1);
        //System.out.println("Objeto a persistir:" + persona1);
        em.close();
    }
}
