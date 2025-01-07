package mx.com.gm.dao;

import jakarta.persistence.Query;
import java.util.List;
import mx.com.gm.domain.Domicilio;

public class DomicilioDAO extends GenericDAO {
    
    public List<Domicilio> listar() {
        String consulta = "SELECT p FROM Domicilio p";
        em = getEntityManger();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }
    
    public void insertar(Domicilio domicilio) {
        try {
            em = getEntityManger();
            em.getTransaction().begin();
            em.persist(domicilio);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void actualizar(Domicilio domicilio) {
        try {
            em = getEntityManger();
            em.getTransaction().begin();
            em.merge(domicilio);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void eliminar(Domicilio domicilio) {
        try {
            em = getEntityManger();
            em.getTransaction().begin();
            em.remove(em.merge(domicilio));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public Object buscarPorId(Domicilio domicilio){
        em = getEntityManger();
        return em.find(Domicilio.class, domicilio.getIdDomicilio());
    }
    
}
