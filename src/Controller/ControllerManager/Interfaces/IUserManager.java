package Controller.ControllerManager.Interfaces;

import Model.AbstractEntityLocal;
import Model.EntityUser;

import java.util.ArrayList;

public interface IUserManager {

    public EntityUser CreateUser(String username, String firstname, String lastname, String function, String password);
    public  void LogUser(String username,String password);
    public void CreateAppartment(String description, String adresse, ArrayList<AbstractEntityLocal> listLocals);

}
