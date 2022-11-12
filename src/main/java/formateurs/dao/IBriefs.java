package formateurs.dao;

import entity.Briefs;
import entity.Promos;

import java.util.ArrayList;

public interface IBriefs {

    void saveBriefs(Briefs briefs);
    ArrayList<Briefs> getMyBrief(Promos p);
    void distribuerBrief(int idBrief);

}
