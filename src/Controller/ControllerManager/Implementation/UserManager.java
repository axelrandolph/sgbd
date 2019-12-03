package Controller.ControllerManager.Implementation;

import Controller.ControllerDAO.Implementaion.UserDAO;
import Controller.ControllerDAO.Interfaces.IUserDAO;
import Exception.*;
import Controller.ControllerManager.Interfaces.IAppartmentManager;
import Controller.ControllerManager.Interfaces.IConnectionManager;
import Controller.ControllerManager.Interfaces.IUserManager;
import Model.AbstractEntityLocal;
import Model.EntityConnection;
import Model.EntityUser;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserManager implements IUserManager{

        private static EntityUser currentUser;
        private IUserDAO userDAO;

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
        public EntityUser CreateUser(String username, String firstname, String lastname, String function, String password) throws UserException {

                EntityUser user = new EntityUser(username,firstname,lastname,function,password);
                try {
                        userDAO.insert(user);
                } catch (AppartmentException | LocalException | ConnectionException e) {
                        e.printStackTrace();
                }
                return user;
        }


        @Override
        public EntityUser UpdateUser(String username,String firstName, String lastName, String function, String password) throws UserException {

                if (getCurrentUser() != null) {
                        EntityUser user = new EntityUser(username, firstName, lastName, function, password);
                        try {
                                userDAO.update(user,firstName,lastName,function,password);
                        } catch (UserException e) {
                                throw new UserException("L'utilisateur n'est pas udpatée");
                        }

                        return user;
                }
                return null;
        }

        @Override
        public void LogOut() {
                currentUser = null;
        }


        @Override
        public  void LogUser(String username, String password) throws UserException {

                EntityUser entityUser = userDAO.IdentifiedUser(username,password);
                currentUser = entityUser;

        }



}
