package Controller.ControllerManager.Implementation;

import Controller.ControllerDAO.Implementaion.UserDAO;
import Controller.ControllerDAO.Interfaces.IUserDAO;
import Controller.ControllerManager.Interfaces.IAppartmentManager;
import Controller.ControllerManager.Interfaces.IConnectionManager;
import Controller.ControllerManager.Interfaces.IUserManager;
import Model.AbstractEntityLocal;
import Model.EntityConnection;
import Model.EntityUser;
import View.MainView;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserManager implements IUserManager{

        private static EntityUser currentUser;
        private IUserDAO userDAO;
        private MainView mainView;

        public UserManager() {
                this.userDAO = new UserDAO();
        }

        public static EntityUser getCurrentUser() {
                return currentUser;
        }

        public void setCurrentUser(EntityUser currentUser) {
                UserManager.currentUser = currentUser;
        }

        @Override
        public EntityUser CreateUser(String username, String firstname, String lastname, String function, String password) throws SQLException {

                EntityUser user = new EntityUser(username,firstname,lastname,function,password);
                userDAO.insert(user);

                return user;
        }


        @Override
        public EntityUser UpdateUser(String username,String firstName, String lastName, String function, String password) {

                if (getCurrentUser() != null) {
                        EntityUser user = new EntityUser(username, firstName, lastName, function, password);
                        userDAO.update(user);

                        return user;
                }
                return null;
        }

        @Override
        public void LogOut() {
                currentUser = null;
        }


        @Override
        public  void LogUser(String username, String password) throws SQLException {

                EntityUser entityUser = userDAO.IdentifiedUser(username,password);
                currentUser = entityUser;
        }



}
