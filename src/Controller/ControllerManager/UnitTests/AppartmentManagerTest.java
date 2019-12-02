package Controller.ControllerManager.UnitTests;

import Controller.ControllerDAO.Implementaion.AppartmentDAO;
import Controller.ControllerDAO.Interfaces.IAppartmentDAO;
import Controller.ControllerException.UserException;
import Controller.ControllerManager.Implementation.AppartmentManager;
import Controller.ControllerManager.Implementation.UserManager;
import Controller.ControllerManager.Interfaces.IAppartmentManager;
import Model.EntityAppartment;
import Model.EntityBedroom;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AppartmentManagerTest {

    @Test
    public void TestSearch() throws UserException, SQLException {

        UserManager userManager = new UserManager() ;
      //  userManager.CreateUser("userName","lol","moi","toi","firstname");
        userManager.LogUser("userName","firstName");
        ArrayList<EntityAppartment> listAppart = new ArrayList<EntityAppartment>();
        EntityAppartment appart = new EntityAppartment(1, "2 rue toi", "cette appart est beau",false);
        listAppart.add(appart);
        IAppartmentManager aptManager = new AppartmentManager();
        assertEquals(listAppart, aptManager.SearchAppartmentByCaracteristics(0, 1, 0, 0, 0, "simple"));
    }

    @Test
    public void TestDisplay() throws UserException, SQLException {
        EntityAppartment appartment = new EntityAppartment(1,"loool","haha", true);
        IAppartmentDAO aptDAO = new AppartmentDAO();
        ArrayList<EntityAppartment> listAppart = new ArrayList<EntityAppartment>();
        listAppart.add(appartment);

        assertEquals(listAppart, aptDAO.DisplayAppartmentResulSet());
    }
}
