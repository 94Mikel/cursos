package mx.com.gm.sga.cliente.cascade;

import jakarta.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.slf4j.*;

public class PersistenciaCascadaJPA {
    static Logger log = LoggerFactory.getLogger("PersistenciaCascadaJPA");
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        //Paso 1. crear nuevo objeto
        //objeto en estado transitivo
        Persona persona1 = new Persona("Hubo", "Hernandez", "hhernandez@mail.com", "557854521");

        //crear objeto usuario (tiene dependencia con el objeto persona);
        Usuario usuario1 = new Usuario("hhernandez", "123", persona1);

        //Paso 3. persistimos el objeto usuario
        em.persist(usuario1);
        
        //Paso 4. Commit transaccion
        tx.commit();
        
        //objeto en estados detached
        log.info("objeto persistido persona: "+persona1);
        log.info("objeto persistido usuario: "+usuario1);
        
        
    }
    
    
}
