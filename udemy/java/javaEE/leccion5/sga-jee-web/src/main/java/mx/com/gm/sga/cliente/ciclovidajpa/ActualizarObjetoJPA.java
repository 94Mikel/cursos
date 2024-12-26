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
public class ActualizarObjetoJPA {
    static Logger log = LoggerFactory.getLogger("PersistirObjetoJPA");
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        //Paso1. Inicia transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //Paso2. Ejecuta SQL de tipo select
        //El id proporcionado debe existir en la base de datos
        Persona persona1 = em.find(Persona.class, 8);
        
        //Paso3. termina la trasacción 1
        tx.commit();
        
        //Objeto en estado de detached
        log.info("objeto recuperado: "+ persona1);
        
        //Paso4. setValue (nuevoValor)
        persona1.setApellido("Juarez");
        
        //Paso5. Iniciar trasacción 2
        EntityTransaction tx2 = em.getTransaction();
        tx.begin();
        
        //paso6. Modificamos el objeto
        em.merge(persona1);
        
        //Vaciado de cualquier modificación pendiente sin cerar la transacción
        //em.flush();
        
        //paso7. Terminar transacción 2
        tx2.commit();
        
        //objeto en estado detached ya modificado
        log.info("Objeto recuperado: "+persona1);
        
        //cerramos el objeto entity manager
        em.close();
        
    }
}
