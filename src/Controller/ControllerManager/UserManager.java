package Controller.ControllerManager;

import Controller.ControllerDAO.UserDAO;
import Model.EntityUser;

public class UserManager {

        public void createUser(String username, String firstname,String lastname,String function, String password){

                EntityUser user = new EntityUser(username,firstname,lastname,function,password);
                UserDAO userDAO = new UserDAO();
                userDAO.insert(user);
        }

        public  void loginUser(String username,String password){


        }
}
