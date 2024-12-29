package mx.com.gm.sga.cliente.jpql;

import jakarta.persistence.*;
import java.util.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.slf4j.*;

public class PruebaJPQL {

    static Logger log = LoggerFactory.getLogger("PruebaJPQL");

    public static void main(String[] args) {
        String jpql = null;
        Query q = null;
        List<Persona> personas = null;
        Persona persona = null;
        Iterator iter = null;
        Object[] tupla = null;
        List<String> nombres = null;
        List<Usuario> usuarios = null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //1. Consulta de todos los objetos de tipo Persona
        log.info("\n1. Consulta de todas las Personas");
        jpql = "select p from Persona p";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);

        //2. Consulta de la Persona con id = 10
        log.info("\n2. Consulta de la Persona con id = 10");
        jpql = "select p from Persona p where p.idPersona = 10";
        persona = (Persona) em.createQuery(jpql).getSingleResult();//Cast de tipo Object a tipo persona
        //log.info(persona.toString());

        //3. Consulta de la Persona por nombre
        jpql = "select p from Persona p where p.nombre = 'Juan'";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);

        //4. Consulta de datos individuales, se crea un arreglo(tupla) de tipo object de 3 columnas
        log.info("\n4. Consulta de datos individuales, se crea un arreglo (tupla) de tipo object de 3 columnas");
        jpql = "select p.nombre as Nombre, p.apellido as Apellido, p.email as Email from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            String nombre = (String) tupla[0];
            String apellido = (String) tupla[1];
            String email = (String) tupla[2];
            //log.info("nombre: " + nombre + ", apellido: " + apellido + ", email: " + email);
        }

        //5. Obtiene el objeto Persona y el id, se crea un arreglo de tipo Object con 2 columnas
        log.info("\n5. Obtiene el objeto Persona y el id, se crea un arreglo de tipo Object con 2 columnas");
        jpql = "select p, p.idPersona from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            persona = (Persona) tupla[0];
            int idPersona = (int) tupla[1];
            //log.info("persona: " + persona.toString() + ", idPersona: " + idPersona);
        }

        //6. Consulta de todas las personas con solo el idPersona el resto null
        log.info("\n6. Consulta de todas las personas con solo el idPersona el resto null");
        jpql = "select new mx.com.gm.sga.domain.Persona(p.idPersona) from Persona p";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);

        //7. Regresa el valor minimo y el maximo de idPersona (scaler result)
        log.info("\n7. Regresa el valor minimo y el maximo de idPersona (scaler result)");
        jpql = "select min(p.idPersona) as MinId, max(p.idPersona) as MaxId, count(p.idPersona) as Contador from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            Integer idMin = (Integer) tupla[0];
            Integer idMax = (Integer) tupla[1];
            Long count = (Long) tupla[2];
            //log.info("idMin: " + idMin + ", idMax: " + idMax + ", count: " + count);
        }
        
        //8. Cuenta los nombres de las personas que son distintos
        log.info("\n 8. Cuenta los nombres de las personas que son distintos");
        jpql = "select count(distinct p.nombre) from Persona p";
        Long contador = (Long) em.createQuery(jpql).getSingleResult();
        //log.info("no. de personas con nombre distinto: "+contador);
        
        //9. Concatenar y convierte a mayusculas el nombre y apellido
        log.info("\n9. Concatenar y convierte a mayusculas el nombre y apellido");
        jpql = "select CONCAT(p.nombre, ' ', p.apellido) as Nombre from Persona p";
        nombres = em.createQuery(jpql).getResultList();
        for (String nombreCompleto: nombres) {
            //log.info(nombreCompleto.toUpperCase());
        }
        
        //10. Obtiene el objeto persona con id igual al parametro proporcionado
        log.info("\n10. Obtiene el objeto persona con id igual al parametro proporcionado");
        int idPersona = 10;
        jpql = "select p from Persona p where p.idPersona = :id";
        q = em.createQuery(jpql);
        q.setParameter("id", idPersona);
        persona = (Persona) q.getSingleResult();
        //log.info(persona.toString());
        
        //11. Obtiene las personas que contengan una letra a en el nombre, sin importar si es mayusculas o minusculas
        log.info("\n11. Obtiene las personas que contengan una letra a en el nombre, sin importar si es mayusculas o minusculas");
        jpql = "select p from Persona p where upper(p.nombre) like upper(:parametro)";
        String parametroString = "%a%";//es el caracter que utilizamos para la sentencia like.
        q = em.createQuery(jpql);
        q.setParameter("parametro", parametroString);
        personas = q.getResultList();
        //mostrarPersonas(personas);
        
        //12. Uso de between
        log.info("\n12. Uso de between");
        jpql = "select p from Persona p where p.idPersona between 7 and 10";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        //13. Uso del ordenamiento
        log.info("\n13. Uso del ordenamiento");
        jpql = "select p from Persona p where p.idPersona > 6 order by p.nombre desc, p.apellido desc";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        //14. Uso de subquery
        log.info("\n14. Uso de subquery");
        jpql = "select p from Persona p where p.idPersona in (select min(p1.idPersona) from Persona p1)";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        //15. Uso de join con lazy loading
        log.info("\n15. Uso de join con lazy loading");
        jpql="select u from Usuario u join u.persona p";
        usuarios = em.createQuery(jpql).getResultList();
        //mostarUsuarios(usuarios);
        
        //16. Uso de left join con eager loading
        //poniendo fetch ya indicamos que es de eager loading
        log.info("\n16. Uso de left join con eager loading");
        jpql="select u from Usuario u left join fetch u.persona";
        usuarios = em.createQuery(jpql).getResultList();
        mostarUsuarios(usuarios);

    }

    private static void mostrarPersonas(List<Persona> personas) {
        for (Persona persona : personas) {
            log.info(persona.toString());
        }
    }

    private static void mostarUsuarios(List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            log.info(usuario.toString());
        }
    }

}
