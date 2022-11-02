package administrateur.dao;

import administrateur.entity.Formateurs;

import javax.persistence.*;
import java.util.ArrayList;

public class FormateurDaoImpl implements IFormateurs{

    @Override
    public void save(Formateurs f) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.persist(f);
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
    public ArrayList<Formateurs> getAllFormateure() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        entityManager.getTransaction().begin();
        TypedQuery<Formateurs> query1 = entityManager.createQuery("SELECT f FROM Formateurs f",Formateurs.class);
        ArrayList<Formateurs> formateurs = (ArrayList<Formateurs>) query1.getResultList();
        return formateurs;
    }
}
