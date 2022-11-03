package administrateur.dao;

import entity.Promos;
import config.Config;

import javax.persistence.*;
import java.util.ArrayList;

public class PromoDaoImpl implements IPromos{
    @Override
    public void save(Promos p) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.persist(p);
            transaction.commit();
        }finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public ArrayList<Promos> getAllPromos() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        entityManager.getTransaction().begin();

        TypedQuery<Promos> query1 = entityManager.createQuery("SELECT p FROM Promos p",Promos.class);


        ArrayList<Promos> promos = (ArrayList<Promos>) query1.getResultList();
        entityManager.getTransaction().commit();
        return promos;
    }

    @Override
    public Promos getPromosById(int id) {
        Promos promos = new Promos();
        EntityManager em = Config.getConfig().getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Promos> query1 = em.createQuery("SELECT p FROM Promos p WHERE p.id = "+id,Promos.class);
        ArrayList<Promos> promo = (ArrayList<Promos>) query1.getResultList();
        for (Promos p:promo ) {
            promos.setId(p.getId());
            promos.setNom(p.getNom());
            promos.setAnnescolaire(p.getAnnescolaire());
            promos.setNiveau(p.getNiveau());
        }
        em.getTransaction().commit();
        return promos;
    }


}
