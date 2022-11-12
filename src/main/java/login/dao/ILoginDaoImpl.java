package login.dao;

import config.Config;
import entity.Admin;
import entity.Apprenants;
import entity.Formateurs;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class ILoginDaoImpl implements ILogin{
    @Override
    public int login(String email, String password,String role) {
        int count=0;
        ArrayList<Admin> admins = null;
        ArrayList<Formateurs> formateurs = null;
        ArrayList<Apprenants> apprenants = null;
        EntityManager em = Config.getConfig().getEntityManager();
        em.getTransaction().begin();
        if(role.equals("admin")){
            TypedQuery<Admin> query = em.createQuery("SELECT A FROM Admin A WHERE A.email LIKE :email AND A.password LIKE :password",Admin.class);
            query.setParameter("email",email);
            query.setParameter("password",password);
            admins = (ArrayList<Admin>) query.getResultList();
            count = admins.size();
        } else if (role.equals("formateur")) {
            TypedQuery<Formateurs> query = em.createQuery("SELECT F FROM Formateurs F WHERE F.email LIKE :email AND F.password LIKE :password",Formateurs.class);
            query.setParameter("email",email);
            query.setParameter("password",password);
            formateurs = (ArrayList<Formateurs>) query.getResultList();
            count = formateurs.size();
        } else if (role.equals("apprenant")) {
            TypedQuery<Apprenants> query = em.createQuery("SELECT A FROM Apprenants A WHERE A.email LIKE :email AND A.password LIKE :password",Apprenants.class);
            query.setParameter("email",email);
            query.setParameter("password",password);
            apprenants = (ArrayList<Apprenants>) query.getResultList();
            count = apprenants.size();
        }
        em.getTransaction().commit();
        return count;
    }

    @Override
    public ArrayList<Formateurs> getFormateureLogeed(String email, String password, String role) {
        ArrayList<Formateurs> formateurs = new ArrayList<>();
        EntityManager em = Config.getConfig().getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Formateurs> query = em.createQuery("SELECT F FROM Formateurs F WHERE F.email LIKE :email AND F.password LIKE :password",Formateurs.class);
        query.setParameter("email",email);
        query.setParameter("password",password);
        formateurs = (ArrayList<Formateurs>) query.getResultList();
        em.getTransaction().commit();
        return formateurs;
    }

    @Override
    public ArrayList<Apprenants> getApprenantsLogeed(String email, String password, String role) {
        ArrayList<Apprenants> apprenants = new ArrayList<>();
        EntityManager entityManager = Config.getConfig().getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Apprenants> query = entityManager.createQuery("SELECT A FROM Apprenants A WHERE A.email LIKE :email AND A.password LIKE :password",Apprenants.class);
        query.setParameter("email",email);
        query.setParameter("password",password);
        apprenants = (ArrayList<Apprenants>) query.getResultList();
        return apprenants;
    }
}
