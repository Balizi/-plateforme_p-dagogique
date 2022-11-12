package apprenants.dao;

import entity.Briefs;
import entity.Promos;

import java.util.ArrayList;

public interface IApprenants {

    ArrayList<Briefs> getBriefPromo(Promos pr);
    Promos getPromosById(int id);

}
