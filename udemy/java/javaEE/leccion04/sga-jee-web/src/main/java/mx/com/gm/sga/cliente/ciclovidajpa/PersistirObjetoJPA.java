/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.sga.cliente.ciclovidajpa;

import jakarta.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.slf4j.*;

/**
 *
 * @author mikel
 */
public class PersistirObjetoJPA {
    static Logger log = LoggerFactory.getLogger("PersistirObjetoJPA");
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Inicia la transacción
        
        //Paso 1. Crea nuevo objeto
        //Objeto en estado transitivo
        Persona persona1 = new Persona("Juan","Perez","jperez@mail.com","688542542");
        
        //Paso2. Inicia transaccion
        tx.begin();
        
        //Paso3. Ejecutar SQL
        em.persist(persona1);
        
        log.info("Objeto persistido - estado sin commit: "+persona1);
        
        //paso4. commit/roolback
        // En este paso se realiza la inserción en la base de datos.
        tx.commit();
        
        //Comprobar
        //Objeto en estado de detached
        log.info("Objeto persistido - estado detached: "+persona1);
        
        //cerramos el objeto entity manager
        em.close();
        
        
    }
    
}
