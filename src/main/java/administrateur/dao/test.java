package administrateur.dao;

import entity.Apprenants;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        /*PromoDaoImpl promoDao =new PromoDaoImpl();
        Promos p = promoDao.getPromosById(4);
        System.out.println(p.toString());*/
       /* Promos p = new Promos();
        p.setId(4);
        p.setNom("Alan Turing");
        p.setNiveau("A1");
        p.setAnnescolaire("2022");*/
        //promoDao.save(p);

        /*EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        ArrayList<Promos> promos = (ArrayList<Promos>) entityManager.createNativeQuery("promo",Promos.class);
        for (Promos p:promos){
            System.out.println(p.toString());
        }*/

        /*PromoDaoImpl promoDao = new PromoDaoImpl();
        ArrayList<Promos> promos = promoDao.getAllPromos();
        promos.stream().forEach(pr-> System.out.println(pr.toString()));*/

        /*FormateurDaoImpl formateurDao = new FormateurDaoImpl();
        Formateurs formateurs = new Formateurs();
        formateurs.setNom("Echadi");
        formateurs.setPrenom("Youness");
        formateurs.setEmail("echadi@gmail.com");
        formateurs.setPassword("1234567");
        formateurs.setPromosByIdpr(p);
        formateurDao.save(formateurs);*/
        //System.out.println(formateurs.toString());

        //JPAStreamer.of("default").stream(Promos.class).forEach(System.out::println);
        /*FormateurDaoImpl formateurDao = new FormateurDaoImpl();
        ArrayList<Formateurs> formateurs = formateurDao.getAllFormateure();
        for (Formateurs f :formateurs ) {
            System.out.println(f.getNom());
        }*/

       /* ApprenantsDaoImpl apprenantsDao = new ApprenantsDaoImpl();
        Apprenants apprenants = new Apprenants();
        apprenants.setNom("Blz");
        apprenants.setPrenom("Med");
        apprenants.setEmail("med@gmail.com");
        apprenants.setPassword("123");
        System.out.println(apprenants.toString());
        apprenantsDao.saveApprenants(apprenants);*/

        ApprenantsDaoImpl apprenantsDao = new ApprenantsDaoImpl();
        ArrayList<Apprenants> apprenants = apprenantsDao.getAllApprenant();
        for (Apprenants a:apprenants ) {
            System.out.println(a.toString());
        }

    }
}
