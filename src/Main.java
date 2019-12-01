import Controller.ControllerDAO.Implementaion.AppartmentDAO;
import Controller.ControllerDAO.Implementaion.UserDAO;
import Controller.ControllerManager.Implementation.UserManager;
import Model.EntityUser;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {


        UserManager userManager = new UserManager();
        try {
            userManager.CreateUser("leslie","test","pasfacilelestests","testeur","bon cest bon");
            userManager.CreateUser("axel","test","pasfacilelestests","testeur","bon cest bon");
            userManager.LogUser("axel","bon cest bon");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
