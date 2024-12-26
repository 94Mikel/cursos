/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.sga.cliente.ciclovidajpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mikel
 */
public class EliminarObjetoJPA {
    static Logger log = LoggerFactory.getLogger("PersistirObjetoJPA");

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //Paso1. Inicia transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        //Paso2. Ejecuta SQL de tipo select
        Persona persona1 = em.find(Persona.class, 8);
        
        /*
        em.remove(persona1);
        
        tx.commit();
        */
        
        //Paso3. termina trasacción 1
        tx.commit();
        
        //objeto en estado detached
        log.info("objeto encontrado: "+persona1);
        
        //Paso4. Iniciar transacción(normalmente no solemos estar en la misma trasacción)
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();
        
        //Paso5. Ejecuta SQL que es un delete
        //Hay que hacer merge primero para sincronizar los cambios con la base de datos.
        em.remove(em.merge(persona1));
        
        tx2.commit();
        
        //Objeto en estado detached ya eliminado
        log.info("objeto eliminado: "+persona1);

        //cerramos el objeto entity manager
        em.close();

    }
}
