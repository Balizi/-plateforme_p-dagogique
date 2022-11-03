package formateurs.dao;

import entity.Apprenants;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ApprenantDaoImpl apprenantDao = new ApprenantDaoImpl();
        ArrayList<Apprenants> apprenants = apprenantDao.getAppWithoutPromo();
        for (Apprenants p:apprenants ) {
            System.out.println(p.toString());
        }
    }
}
