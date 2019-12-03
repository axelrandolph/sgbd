package Controller.ControllerManager.Interfaces;

import Exception.*;
import Model.AbstractEntityLocal;
import Model.EntityConnection;
import Model.EntityUser;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IUserManager {

    public EntityUser CreateUser(String username, String firstname, String lastname, String function, String password) throws UserException ;
    public  void LogUser(String username,String password) throws  UserException;
    public EntityUser UpdateUser(String username, String firstName, String lastName, String function, String password) throws UserException;
    public void LogOut();

}
