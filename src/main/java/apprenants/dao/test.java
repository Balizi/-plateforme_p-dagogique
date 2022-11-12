package apprenants.dao;

import entity.Apprenants;
import entity.Briefs;
import entity.Promos;
import login.dao.ILoginDaoImpl;

import java.util.ArrayList;

public class test {

    public static void main(String[] args) {
        ILoginDaoImpl loginDao = new ILoginDaoImpl();
        ArrayList<Apprenants> apprenants = loginDao.getApprenantsLogeed("med@gmail.com","123","apprenant");

        if(apprenants.get(0).getIdpr() != null){
            IApprenantsDaoImpl iApprenantsDao = new IApprenantsDaoImpl();
            Promos promos = iApprenantsDao.getPromosById(apprenants.get(0).getIdpr());

            ArrayList<Briefs> briefs = iApprenantsDao.getBriefPromo(promos);
            for (Briefs b:briefs) {
                    System.out.println(b.toString());
            }
        }
    }

}
