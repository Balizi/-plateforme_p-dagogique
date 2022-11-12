package formateurs.dao;

import config.Config;
import entity.Apprenants;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class ApprenantDaoImpl implements IApprenants{
    @Override
    public ArrayList<Apprenants> getAppWithoutPromo() {
        EntityManager em = Config.getConfig().getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Apprenants> query = em.createQuery("SELECT A FROM Apprenants A WHERE A.idpr is NULL",Apprenants.class);
        ArrayList<Apprenants> apprenants = (ArrayList<Apprenants>) query.getResultList();
        em.getTransaction().commit();
        return apprenants;
    }

    @Override
    public void addAppToMyPromo(int idpr, int id) {
        EntityManager em = Config.getConfig().getEntityManager();
        em.getTransaction().begin();
        //TypedQuery<Apprenants> query = em.createQuery("UPDATE Apprenants SET idpr = :idpr WHERE id = :id",Apprenants.class);
        Query query = em.createQuery("UPDATE Apprenants SET idpr = :idpr WHERE id = :id");
        query.setParameter("idpr",idpr);
        query.setParameter("id",id);
        query.executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public ArrayList<Apprenants> appOfMyPromo(int id) {
        EntityManager em = Config.getConfig().getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Apprenants> query = em.createQuery("SELECT A FROM Apprenants A WHERE A.idpr = :id",Apprenants.class);
        query.setParameter("id",id);
        ArrayList<Apprenants> apprenants = (ArrayList<Apprenants>) query.getResultList();
        em.getTransaction().commit();
        return apprenants;
    }
}
