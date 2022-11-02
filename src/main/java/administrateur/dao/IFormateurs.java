package administrateur.dao;

import administrateur.entity.Formateurs;

import java.util.ArrayList;

public interface IFormateurs {
    void save(Formateurs f);
    ArrayList<Formateurs> getAllFormateure();
}
