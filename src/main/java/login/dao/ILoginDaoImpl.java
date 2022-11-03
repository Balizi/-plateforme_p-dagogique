package login.dao;

import config.Config;
import entity.Admin;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class ILoginDaoImpl implements ILogin{
    @Override
    public int login(String email, String password,String role) {
        ArrayList<Admin> admins = null;
        EntityManager em = Config.getConfig().getEntityManager();
        em.getTransaction().begin();
        if(role.equals("admin")){
            TypedQuery<Admin> query = em.createQuery("SELECT A FROM Admin A WHERE A.email LIKE :email AND A.password LIKE :password",Admin.class);
            query.setParameter("email",email);
            query.setParameter("password",password);
            admins = (ArrayList<Admin>) query.getResultList();
        } else if (role.equals("formateur")) {

        }
        em.getTransaction().commit();
        return admins.size();
    }
}
