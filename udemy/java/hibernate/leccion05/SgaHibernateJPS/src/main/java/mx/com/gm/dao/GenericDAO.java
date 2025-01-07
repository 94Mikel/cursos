package mx.com.gm.dao;

import jakarta.persistence.*;

public abstract class GenericDAO {
    
    protected static EntityManager em;
    private static EntityManagerFactory emf;
    private static final String PU = "HibernateJpaPU";

    public GenericDAO() {
        if(emf == null){
            emf = Persistence.createEntityManagerFactory(PU);
        }
    }
    
    protected EntityManager getEntityManger(){
        if(em == null){
            em = emf.createEntityManager();
        }
        
        return em;
    }
    
}
