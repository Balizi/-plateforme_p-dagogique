package administrateur.dao;

import entity.Apprenants;
import config.Config;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class ApprenantsDaoImpl implements IApprenants{
    @Override
    public void saveApprenants(Apprenants apprenants) {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(apprenants);
            entityManager.getTransaction().commit();
        }finally {
            if (entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            entityManager.close();
        }
    }

    @Override
    public ArrayList<Apprenants> getAllApprenant() {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        TypedQuery<Apprenants> query = entityManager.createQuery("SELECT A from Apprenants A",Apprenants.class);
        ArrayList<Apprenants> apprenants = (ArrayList<Apprenants>) query.getResultList();
        return apprenants;
    }
}
