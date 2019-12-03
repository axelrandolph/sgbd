package Controller.ControllerManager.UnitTests;

import Controller.ControllerDAO.Implementaion.AppartmentDAO;
import Controller.ControllerDAO.Interfaces.IAppartmentDAO;
import Exception.UserException;
import Exception.*;
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
    public void TestSearch() throws Exception {

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

       // assertEquals(listAppart, aptDAO.DisplayAppartmentResulSet());
    }


    @Test
    public void getBy() throws  AppartmentException, ConnectionException, LocalException, UserException, ManagementException {

        EntityAppartment appartment = new EntityAppartment(1,"loool","haha", true);
        IAppartmentDAO aptDAO = new AppartmentDAO();
        aptDAO.getByPrimaryKey(appartment.getIdAppartment());
        assertEquals(appartment, aptDAO.getByPrimaryKey(appartment.getIdAppartment()));

    }

    @Test
    public void createAppt() throws AppartmentException, UserException {
        UserManager userManager = new UserManager() ;
        userManager.LogUser("userName","firstName");

        EntityAppartment appartment = new EntityAppartment(3,"2 rue moi","cette appart est moche", true);

        IAppartmentManager aptman = new AppartmentManager();
        aptman.CreateAppartment("cette appart est moche","2 rue moi");

        assertEquals(appartment, aptman.CreateAppartment("cette appart est moche","2 rue moi"));

    }

}
