package administrateur.dao;

import entity.Apprenants;

import java.util.ArrayList;

public interface IApprenants {

    void saveApprenants(Apprenants apprenants);
    ArrayList<Apprenants> getAllApprenant();

}
