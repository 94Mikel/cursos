package mx.com.gm.dao;

import jakarta.persistence.Query;
import java.util.List;
import mx.com.gm.domain.Alumno;

public class AlumnoDAO extends GenericDAO {
    
    public List<Alumno> listar() {
        String consulta = "SELECT c FROM Alumno c";
        em = getEntityManger();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }

    public void insertar(Alumno alumno) {
        try {
            em = getEntityManger();
            em.getTransaction().begin();
            em.persist(alumno);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } /*finally {
            if (em != null) {
                em.close();
            }
        }*/
    }

    public void actualizar(Alumno alumno) {
        try {
            em = getEntityManger();
            em.getTransaction().begin();
            em.merge(alumno);
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

    public void eliminar(Alumno alumno) {
        try {
            em = getEntityManger();
            em.getTransaction().begin();
            em.remove(em.merge(alumno));
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

    public Alumno buscarPorId(Alumno alumno) {
        em = getEntityManger();
        return em.find(Alumno.class, alumno.getIdAlumno());
    }
    
}
