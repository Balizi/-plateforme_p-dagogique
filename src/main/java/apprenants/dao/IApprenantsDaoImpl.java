package apprenants.dao;

import config.Config;
import entity.Briefs;
import entity.Promos;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class IApprenantsDaoImpl implements IApprenants{
    @Override
    public ArrayList<Briefs> getBriefPromo(Promos p) {
        EntityManager entityManager = Config.getConfig().getEntityManager();
        TypedQuery<Briefs> query = entityManager.createQuery("SELECT B FROM Briefs B",Briefs.class);
        ArrayList<Briefs> briefs1 = (ArrayList<Briefs>) query.getResultList();
        ArrayList<Briefs> briefs = new ArrayList<>();
        for (Briefs b:briefs1 ) {
            if(b.getStatus() == true && b.getPromosByIdpr().equals(p)){
                briefs.add(b);
            }
        }
        return briefs;
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
