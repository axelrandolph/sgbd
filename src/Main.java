import Controller.ControllerDAO.Implementaion.AppartmentDAO;
import Controller.ControllerDAO.Implementaion.UserDAO;
import Controller.ControllerManager.Implementation.UserManager;
import Model.EntityUser;
import View.mainView;
import Exception.*;
import javax.swing.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws UserException, AppartmentException {

        mainView view = new mainView();
        view.Affichage();

        }


    }


