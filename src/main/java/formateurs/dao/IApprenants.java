package formateurs.dao;

import entity.Apprenants;

import java.util.ArrayList;

public interface IApprenants {

    ArrayList<Apprenants> getAppWithoutPromo();
    void addAppToMyPromo(int idpr, int id);
    ArrayList<Apprenants> appOfMyPromo(int id);

}
