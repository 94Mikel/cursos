package mx.com.gm.test.ciclovida;

import jakarta.persistence.*;
import mx.com.gm.domain.Contacto;

public class Estado4EliminarObjeto {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();

        //Para recuperar un objeto no es necesario abrir una transaccion
        //definimos la variable
        Contacto contacto = null;

        //Recuperar un objeto(contacto) de la base de datos con id 4
        //1. transitivo
        contacto = em.find(Contacto.class, 4);

        //Iniciamos transacción
        em.getTransaction().begin();

        //2.remove
        em.remove(em.merge(contacto));
        em.getTransaction().commit();//sincronciacón con la base de datos + cerrar transaccion

        //3. transitivo. Este objeto ya no se puede sincronizar con la base de datos. No esta en la bd
        System.out.println("contacto = " + contacto);

    }
}
