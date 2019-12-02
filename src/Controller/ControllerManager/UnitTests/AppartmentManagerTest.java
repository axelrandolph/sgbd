package Controller.ControllerManager.UnitTests;

import Controller.ControllerException.UserException;
import Controller.ControllerManager.Implementation.AppartmentManager;
import Controller.ControllerManager.Implementation.UserManager;
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
        EntityAppartment appart = new EntityAppartment(1, "address", "description",true);
        listAppart.add(appart);
        EntityBedroom bedroom = new EntityBedroom(1, appart, "description1",3, "type","typeLocal");
        AppartmentManager aptManager = new AppartmentManager();
        assertEquals(listAppart, aptManager.SearchAppartmentByCaracteristics(0, 1, 0, 0, 0, "typeLocal"));
    }
}
