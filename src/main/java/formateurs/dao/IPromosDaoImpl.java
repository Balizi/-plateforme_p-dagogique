package formateurs.dao;

import config.Config;
import entity.Promos;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class IPromosDaoImpl implements IPromos{
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
