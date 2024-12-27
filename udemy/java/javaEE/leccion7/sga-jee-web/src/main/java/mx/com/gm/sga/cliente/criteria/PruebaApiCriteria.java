package mx.com.gm.sga.cliente.criteria;

import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import java.util.*;
import mx.com.gm.sga.domain.Persona;
import org.slf4j.*;

public class PruebaApiCriteria {

    static Logger log = LoggerFactory.getLogger("PersistirObjetoJPA");

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder cb = null;
        CriteriaQuery<Persona> criteriaQuery = null;
        Root<Persona> fromPersona = null;
        TypedQuery<Persona> query = null;
        Persona persona = null;
        List<Persona> personas = null;

        //Query utilizando el API de Criteria
        //1. COnsulta de todas las personas
        //Paso1. El objeto EntityManager crea instancia CriteriaBuilder
        cb = em.getCriteriaBuilder();

        //Paso2. Se crea un objeto CriteriaQuery
        criteriaQuery = cb.createQuery(Persona.class);

        //Paso3. Creamos el objeto raiz de query
        fromPersona = criteriaQuery.from(Persona.class);

        //Paso4. seleccionamos lo necesario de from
        criteriaQuery.select(fromPersona);

        //Paso5. Creamos el query typeSafe
        query = em.createQuery(criteriaQuery);

        //Paso6. Ejecutamos la consulta
        personas = query.getResultList();

        //mostrarPersonas(personas);
        //2-a. Consulta de Persona con id = 10
        //jpql = "select p from Persona p where p.idPersona = 10"
        log.info("\n2-a. Consulta de Persona con id = 10");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona).where(cb.equal(fromPersona.get("idPersona"), 10));
        persona = em.createQuery(criteriaQuery).getSingleResult();
        //log.info(persona.toString());

        //2-b. Consulta de Persona con id = 10
        log.info("\n2-b. Consulta de Persona con id = 10");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona);

        //La clase Predicate permite agregar varios criterios dinamicamente.
        List<Predicate> criterios = new ArrayList<Predicate>();

        //Verificamos si tenemos criterios que agregar
        Integer idPersonaParam = 10;
        ParameterExpression<Integer> parameter = cb.parameter(Integer.class, "idPersona");
        criterios.add(cb.equal(fromPersona.get("idPersona"), parameter));

        //Se agregan los criterios
        if (criterios.isEmpty()) {
            throw new RuntimeException("Sin criterios");
        } else if (criterios.size() == 1) {
            criteriaQuery.where(criterios.get(0));
        } else {
            criteriaQuery.where(cb.and(criterios.toArray(new Predicate[0])));
        }
        
        query = em.createQuery(criteriaQuery);
        query.setParameter("idPersona", idPersonaParam);
        
        //Se ejecuta el query
        persona = query.getSingleResult();
        log.info(persona.toString());

    }

    private static void mostrarPersonas(List<Persona> personas) {
        for (Persona persona : personas) {
            log.info(persona.toString());
        }
    }
}
