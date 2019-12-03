package Controller.ControllerManager.Interfaces;

import Exception.UserException;
import Model.AbstractEntityLocal;
import Model.EntityConnection;
import Model.EntityUser;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IUserManager {

    public EntityUser CreateUser(String username, String firstname, String lastname, String function, String password) throws SQLException;
    public  void LogUser(String username,String password) throws SQLException, UserException;
    public EntityUser UpdateUser(String username, String firstName, String lastName, String function, String password);
    public void LogOut();

}
