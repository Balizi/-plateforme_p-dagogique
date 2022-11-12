package formateurs.dao;

import entity.Apprenants;
import entity.Briefs;
import entity.Promos;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ApprenantDaoImpl apprenantDao = new ApprenantDaoImpl();

        /*ArrayList<Apprenants> apprenants = apprenantDao.getAppWithoutPromo();
        for (Apprenants a:apprenants ) {
            System.out.println(a.toString());
        }*/

        //apprenantDao.addAppToMyPromo(7,3);

       /* ArrayList<Apprenants> apprenants = apprenantDao.appOfMyPromo(4);
        for (Apprenants a:apprenants ) {
            System.out.println(a.toString());
        }*/
        /*IPromosDaoImpl iPromosDao = new IPromosDaoImpl();
        Promos promos = iPromosDao.getPromosById(4);
        IBriefsDaoImpl iBriefsDao = new IBriefsDaoImpl();
        Briefs briefs = new Briefs();
        briefs.setNom("Simplonline Clone - Backend/Frontend");
        briefs.setDescription("La société M ");
        briefs.setStatus(false);
        briefs.setPromosByIdpr(promos);
        System.out.println(briefs.toString());
        iBriefsDao.saveBriefs(briefs);*/

        IBriefsDaoImpl iBriefsDao = new IBriefsDaoImpl();
        iBriefsDao.distribuerBrief(3);
       /* IPromosDaoImpl iPromosDao = new IPromosDaoImpl();
        Promos p = iPromosDao.getPromosById(4);
        ArrayList<Briefs> briefs = iBriefsDao.getMyBrief(p);
        for (Briefs b:briefs) {
            b.getPromosByIdpr().getNom();
            b.getStatus();

            System.out.println(b.toString());
        }*/


    }
}
