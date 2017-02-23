package myhealthylife.telegram.bot.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public enum ChatsDataDao {
	instance;
    private EntityManagerFactory emf;

    private ChatsDataDao() {
        if (emf!=null) {
            emf.close();
        }
        emf = Persistence.createEntityManagerFactory("service01-DataService");
    }

    public EntityManager createEntityManager() {
        try {
            return emf.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;    
    }

    public void closeConnections(EntityManager em) {
        em.close();
    }

    public EntityTransaction getTransaction(EntityManager em) {
        return em.getTransaction();
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
