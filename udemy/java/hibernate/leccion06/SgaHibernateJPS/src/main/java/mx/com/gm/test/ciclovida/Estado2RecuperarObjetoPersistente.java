/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.test.ciclovida;

import jakarta.persistence.*;
import mx.com.gm.domain.Contacto;

/**
 *
 * @author mikel
 */
public class Estado2RecuperarObjetoPersistente {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //Para recuperar un objeto no es necesario abrir una transaccion
        
        //definimos la variable
        Contacto contacto = null;
        
        //Recuperar un objeto(contacto) de la base de datos con id 3 
        contacto = em.find(Contacto.class, 3);
        
        //detached o separado de la base de datos
        System.out.println("contacto = " + contacto);
        
    }
}
