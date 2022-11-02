package config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Config {

    private EntityManagerFactory emf;

    private static Config config = new Config();

    private Config(){
        this.emf = Persistence.createEntityManagerFactory("default");
    }

    public EntityManagerFactory getEmf(){
        return emf;
    }

    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public static Config getConfig(){
        return config;
    }

}
