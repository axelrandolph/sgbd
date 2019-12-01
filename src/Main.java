import Controller.ControllerDAO.Implementaion.AppartmentDAO;
import Controller.ControllerDAO.Implementaion.UserDAO;
import Controller.ControllerManager.Implementation.UserManager;
import Model.EntityUser;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
/*
        String userNam= "lol";
        String password = "123";
        String lastName = "toi";
        String firstName = "moi";
        String functionUser = "lio";
        String firstName1 = "Divine";

        EntityUser en = new EntityUser(userNam,firstName,lastName,functionUser,password);
        EntityUser en1 = new EntityUser(userNam,firstName1,lastName,functionUser,password);
       */

        UserManager userManager = new UserManager();
        try {
            userManager.CreateUser("axel","test","pasfacilelestests","testeur","bon cest bon");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
