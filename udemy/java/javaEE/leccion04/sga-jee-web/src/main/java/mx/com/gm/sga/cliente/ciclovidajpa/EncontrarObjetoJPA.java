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
public class EncontrarObjetoJPA {
    static Logger log = LoggerFactory.getLogger("PersistirObjetoJPA");
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        //Paso1. Inicia transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        //Paso2. Ejecutar SQL de tipo select
        Persona persona1 = em.find(Persona.class, 10);
        
        //Paso3. Termina la transaccion
        tx.commit();
        
        //Objeto en estado de detached
        log.info("objeto recuperado: "+persona1);
        
        //cerramos el objeto entity manager
        em.close();
        
    }
}
