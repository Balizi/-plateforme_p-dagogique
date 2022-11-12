package login.dao;

import entity.Apprenants;
import entity.Formateurs;

import java.util.ArrayList;

public interface ILogin {
    int login(String email,String password,String role);
    ArrayList<Formateurs> getFormateureLogeed(String email,String password,String role);
    ArrayList<Apprenants> getApprenantsLogeed(String email,String password,String role);
}
