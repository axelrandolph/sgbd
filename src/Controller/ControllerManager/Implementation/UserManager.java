package Controller.ControllerManager.Implementation;

import Controller.ControllerDAO.Implementaion.UserDAO;
import Controller.ControllerDAO.Interfaces.IUserDAO;
import Controller.ControllerManager.Interfaces.IAppartmentManager;
import Controller.ControllerManager.Interfaces.IUserManager;
import Model.AbstractEntityLocal;
import Model.EntityUser;

import java.util.ArrayList;

public class UserManager implements IUserManager{

        private IUserDAO userDAO;
        private EntityUser currentUser;
        private IAppartmentManager appartmentManager;

        @Override
        public EntityUser CreateUser(String username, String firstname, String lastname, String function, String password){

                EntityUser user = new EntityUser(username,firstname,lastname,function,password);
                userDAO.insert(user);

                return user;
        }

        @Override
        public void CreateAppartment(String description, String adresse, ArrayList<AbstractEntityLocal> listLocals){

        }

        @Override
        public  void LogUser(String username, String password){

               /* currentUser =  (select dans la base de données
               (prepared statement) l'utilisateur correspondant à username et password*/
        }

}
