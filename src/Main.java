import Controller.ControllerDAO.UserDAO;
import Model.EntityUser;

public class Main {

    public static void main(String[] args) {

        UserDAO us = new UserDAO();

        String userNam= "lol";
        int password = 123;
        String lastName = "toi";
        String firstName = "moi";
        String functionUser = "lio";
        EntityUser en = new EntityUser(userNam,firstName,lastName,functionUser,password);


        us.insert(en);
    }

}
