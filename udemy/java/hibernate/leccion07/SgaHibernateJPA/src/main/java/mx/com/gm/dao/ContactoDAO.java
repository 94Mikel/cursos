package mx.com.gm.dao;

import jakarta.persistence.Query;
import java.util.List;
import static mx.com.gm.dao.GenericDAO.em;
import mx.com.gm.domain.Contacto;

public class ContactoDAO extends GenericDAO {

    public List<Contacto> listar() {
        String consulta = "SELECT c FROM Contacto c";
        em = getEntityManger();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }

    public void insertar(Contacto contacto) {
        try {
            em = getEntityManger();
            em.getTransaction().begin();
            em.persist(contacto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } 
//        finally {
//            if (em != null) {
//                em.close();
//            }
//        }
    }

    public void actualizar(Contacto contacto) {
        try {
            em = getEntityManger();
            em.getTransaction().begin();
            em.merge(contacto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } 
//        finally {
//            if (em != null) {
//                em.close();
//            }
//        }
    }

    public void eliminar(Contacto contacto) {
        try {
            em = getEntityManger();
            em.getTransaction().begin();
            em.remove(em.merge(contacto));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } 
//        finally {
//            if (em != null) {
//                em.close();
//            }
//        }
    }

    public Contacto buscarPorId(Contacto contacto) {
        em = getEntityManger();
        return em.find(Contacto.class, contacto.getIdContacto());
    }

}
