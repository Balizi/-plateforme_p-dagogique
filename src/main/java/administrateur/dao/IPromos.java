package administrateur.dao;

import entity.Promos;

import java.util.ArrayList;

public interface IPromos {
    void save(Promos p);
    ArrayList<Promos> getAllPromos();

    Promos getPromosById(int id);
}
