package Controller.ControllerManager;

import Controller.ControllerDAO.UserDAO;
import Model.EntityUser;

public class UserManager {

        public void createUser(EntityUser entityUser){

                UserDAO user = new UserDAO();
                user.insert(entityUser);
        }

        public  void loginUser(String username,String password){


        }
}
