package mx.com.gm.test.ciclovida;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.com.gm.domain.Contacto;

public class Estado3ModificarObjetoPersistente {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //Para recuperar un objeto no es necesario abrir una transaccion
        
        //definimos la variable
        Contacto contacto = null;
        
        //Recuperar un objeto(contacto) de la base de datos con id 4
        //1. transitivo
        contacto = em.find(Contacto.class, 4);
        
        //modificamos el objeto
        contacto.setEmail("clara@mail.com");
        
        //Iniciamos transacción
        em.getTransaction().begin();
        
        //2.estado persistente
        em.persist(contacto);
        em.getTransaction().commit();//sincronciacón con la base de datos + cerrar transaccion
        
        //3. detached o separado de la base de datos
        System.out.println("contacto = " + contacto);
        
    }
}
