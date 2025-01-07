package mx.com.gm.dao;

import jakarta.persistence.Query;
import java.util.List;
import static mx.com.gm.dao.GenericDAO.em;
import mx.com.gm.domain.Curso;

public class CursoDAO extends GenericDAO{
    
    public List<Curso> listar() {
        String consulta = "SELECT p FROM Curso p";
        em = getEntityManger();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }
    
    public void insertar(Curso curso) {
        try {
            em = getEntityManger();
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void actualizar(Curso curso) {
        try {
            em = getEntityManger();
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void eliminar(Curso curso) {
        try {
            em = getEntityManger();
            em.getTransaction().begin();
            em.remove(em.merge(curso));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public Object buscarPorId(Curso curso){
        em = getEntityManger();
        return em.find(Curso.class, curso.getIdCurso());
    }
    
    
}
