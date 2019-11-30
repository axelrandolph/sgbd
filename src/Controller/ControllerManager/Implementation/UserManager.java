package Controller.ControllerManager.Implementation;

import Controller.ControllerDAO.Implementaion.UserDAO;
import Controller.ControllerDAO.Interfaces.IUserDAO;
import Model.EntityUser;

public class UserManager {

        private IUserDAO userDAO;
        private EntityUser currentUser;

        public EntityUser CreateUser(String username, String firstname, String lastname, String function, String password){

                EntityUser user = new EntityUser(username,firstname,lastname,function,password);
                userDAO.insert(user);

                return user;
        }


        public  void LogUser(String username, String password){

               /* currentUser =  (select dans la base de données
               (prepared statement) l'utilisateur correspondant à username et password*/
        }

}
