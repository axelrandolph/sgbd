package Controller.ControllerManager.Interfaces;

import Model.AbstractEntityLocal;
import Model.EntityUser;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IUserManager {

    EntityUser getCurrentUser();

    void setCurrentUser(EntityUser currentUser);

    public EntityUser CreateUser(String username, String firstname, String lastname, String function, String password) throws SQLException;
    public  void LogUser(String username,String password) throws SQLException;
    public void CreateAppartment(String description, String adresse, ArrayList<AbstractEntityLocal> listLocals);
    public EntityUser UpdateUser(String username, String firstName, String lastName, String function, String password);
    public void LogOut();

}
