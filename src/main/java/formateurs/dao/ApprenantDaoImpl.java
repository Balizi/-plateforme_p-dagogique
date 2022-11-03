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
        //TypedQuery<Apprenants> query = em.createQuery("SELECT A FROM Apprenants A WHERE A.idpr = :id ",Apprenants.class);
        Query query = em.createQuery("SELECT A FROM Apprenants A WHERE A.idpr = :id");
        query.setParameter("id",null);
        return (ArrayList<Apprenants>) query.getResultList();
    }
}
