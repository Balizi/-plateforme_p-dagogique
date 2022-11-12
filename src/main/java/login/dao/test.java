package login.dao;

import entity.Apprenants;
import entity.Formateurs;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ILoginDaoImpl loginDao = new ILoginDaoImpl();
        //int a = loginDao.login("admin@gmail.com","azeq","formateur");
        //System.out.println("value "+a);
        //ArrayList<Formateurs> formateurs = loginDao.getFormateureLogeed("admin@gmail.com","azeq","formateur");


        ArrayList<Apprenants> apprenants = loginDao.getApprenantsLogeed("Abdelghafour@gmail.com","12345","apprenant");

        System.out.println(apprenants.get(0).getIdpr());

    }
}
