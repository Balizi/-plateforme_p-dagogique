package administrateur.dao;

import entity.Formateurs;

import java.util.ArrayList;

public interface IFormateurs {
    void save(Formateurs f);
    ArrayList<Formateurs> getAllFormateure();
}
