package mx.com.gm.test.ciclovida;

import jakarta.persistence.*;
import mx.com.gm.domain.Contacto;

public class Estado1Persistido {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //1. estado transitivo
        Contacto contacto = new Contacto();
        contacto.setEmail("clara");
        contacto.setTelefono("11223344");
        
        //2.persistimos el objeto
        em.getTransaction().begin();//iniciamos la transaccion
        //persistimos con lo estandar de JPA
        em.persist(contacto);
        //em.flush(); con flush realizamos la sincronicación con la base de datos pero no cerramos la transacción.
        em.getTransaction().commit();//Aqui se modifica la base de datos, cuando se hace commit.También cerramos la transaccion con esto.
        
        //3. detached (separado)
        System.out.println("contacto = " + contacto);
        
        
    }
}
