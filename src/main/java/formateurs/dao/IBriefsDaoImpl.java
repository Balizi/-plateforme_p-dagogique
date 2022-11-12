package formateurs.dao;

import config.Config;
import entity.Briefs;
import entity.Promos;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class IBriefsDaoImpl implements IBriefs{
    @Override
    public void saveBriefs(Briefs briefs) {
        EntityManager em = Config.getConfig().getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(briefs);
            em.getTransaction().commit();
        }finally {
            if (em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

    @Override
    public ArrayList<Briefs> getMyBrief(Promos p) {
        EntityManager em = Config.getConfig().getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Briefs> query = em.createQuery("SELECT B FROM Briefs B WHERE B.promosByIdpr=:promo",Briefs.class);
        query.setParameter("promo",p);
        ArrayList<Briefs> briefs = (ArrayList<Briefs>) query.getResultList();
        em.getTransaction().commit();
        return briefs;
    }

    @Override
    public void distribuerBrief(int idBrief) {
        EntityManager em = Config.getConfig().getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE Briefs B SET B.status =:status WHERE B.id=:id");
        query.setParameter("status",true);
        query.setParameter("id",idBrief);
        query.executeUpdate();
        em.getTransaction().commit();
    }
}