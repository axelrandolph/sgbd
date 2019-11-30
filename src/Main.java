import Controller.ControllerDAO.Implementaion.UserDAO;
import Model.EntityUser;

public class Main {

    public static void main(String[] args) {

        UserDAO us = new UserDAO();

        String userNam= "lol";
        String password = "123";
        String lastName = "toi";
        String firstName = "moi";
        String functionUser = "lio";
        String firstName1 = "Divine";

        EntityUser en = new EntityUser(userNam,firstName,lastName,functionUser,password);
        EntityUser en1 = new EntityUser(userNam,firstName1,lastName,functionUser,password);


       // us.insert(en);
        us.update(en1);
    }

}
