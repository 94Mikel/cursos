/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.sga.cliente.asociaciones;

import jakarta.persistence.*;
import java.util.List;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.slf4j.*;

/**
 *
 * @author mikel
 */
public class ClienteAsociacionesJPA {
    static Logger log = LoggerFactory.getLogger("ClienteAsociacionesJPA");
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        List<Persona> personas = em.createNamedQuery("Persona.findAll").getResultList();
        
        //cerramos la conexión a nuestro entity manager
        em.close();
        
        //Imprimir los objetos de tipo persona
        for (Persona persona : personas) {
            log.info("Persona: "+persona);
            //recuperamos los usuario de cada persona
            for(Usuario usuario: persona.getUsuarioList()){
                log.info("Usuario: "+usuario);
            }
        }
        
    }
    
}
